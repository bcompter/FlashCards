package FlashCards;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random; 
import java.time.*;

/**
 * A lesson
 */
public class Lesson {
    
    /**
     * Time this lesson started
     */
    Date timeStarted;
    
    /**
     * Reference to the parent gui
     */
    MainFrame theGui;
    
    /**
     * The deck we are studying
     */
    Deck theDeck;
    
    /**
     * The current index in the deck
     */
    int index = 0;
    
    /**
     * Gate some actions
     */
    boolean waitForEnter = false;
    
    /**
     * A flag to determine if the lesson is still running
     */
    boolean isRunning = true;
    
    /**
     * The direction of the flashcard
     */
    boolean isRUEN = true;
    
    /**
     * A list of indexes to determine the order of vocab from our deck
     */
    ArrayList <Integer> deckOrder;
    
    /**
     * Wrapper to play audio files
     */
    Mp3Player mediaPlayer = new Mp3Player();
    
    /**
     * Number of vocab in the lesson
     */
    int numVocab = 100;
    int vocabCount = 0;
    
    /**
     * Time the lesson started
     */
    Date startTime;
    
    /**
     * Create a new Lesson
     */
    public Lesson(MainFrame m, Deck d, boolean dir, int lessonSize)
    {
        // Set references
        theGui = m;
        theDeck = d;
        isRUEN = dir;   // True for RU-EN, false for EN-RU
        
        // Set vocab numbers
        numVocab = lessonSize;
        vocabCount = 0;
        if (d.vocabulary.size() < numVocab)
            numVocab = d.vocabulary.size();
        
        // Prepare deck order
        Random rand = new Random();
        deckOrder = new ArrayList<Integer>();
        for (int i = 0; i < d.vocabulary.size(); i++)
        {
            deckOrder.add(-1);
        }
        for (int i = 0; i < deckOrder.size(); i++)
        {
            int pos = rand.nextInt(deckOrder.size());
            while (deckOrder.get(pos) != -1)
            {
                pos++;
                if (pos >= deckOrder.size())
                    pos = 0;
            }
            deckOrder.set(pos, i);
        }
        
        // Prepare gui
        NextWord();
        theGui.SetProgress(vocabCount, numVocab);
        
        // Start the timer
        startTime = new Date();
    }
    
    /**
     * Handle input from the user, did they get it right?
     */
    public void HandleInput (String ans)
    {
        // Nothing to do if the lesson is cmoplete
        if (!isRunning)
        {
            return;
        }
        
        // Are we waiting for the user to ack?
        if (waitForEnter)
        {
            // Step to the next vocab
            index++;
            vocabCount++;
            theGui.SetProgress(vocabCount, numVocab);
            if (vocabCount < numVocab)
            {
                NextWord();
            }
            else
            {
                EndLesson();
            }
            waitForEnter = false;      
            return;
        }

        // Keeping it clean
        Vocab vocab = theDeck.GetVocab(deckOrder.get(index));
        
        // Parse the result and update
        if (isRUEN)
        {
            vocab.theResult = Parser.GetResult(vocab.GetEnglish(), ans);
            theGui.SetAnswer(vocab.english);
            vocab.timesStudiedRUEN++;
        }
        else
        {
            vocab.theResult = Parser.GetResult(vocab.GetRussian(), ans);
            theGui.SetAnswer(vocab.russian);
            vocab.timesStudiedENRU++;
            PlaySound();
        }

        // Check the result, only if we have not seen this vocab today
        if (vocab.theResult.result.compareTo(Result.eRESULT.GOOD) >= 0)
        {
            // Check date, don't improve rating if we already reviewed this vocab today
            boolean upgradeGrade;
            if (isRUEN)
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                upgradeGrade = !( sdf.format(vocab.lastSeenRUEN).equals(sdf.format(new Date())) );
            }
            else
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                upgradeGrade = !( sdf.format(vocab.lastSeenENRU).equals(sdf.format(new Date())) );
            }
            
            // Display result
            switch (vocab.theResult.result) {
                case PERFECT:
                    theGui.SetResult("Perfect!");
                    break;
                case GOOD:
                    theGui.SetResult("Good!");
                    break;
                case CLOSE:
                    theGui.SetResult("Close!");
                    break;
                default:
                    break;
            }
            
            // Upgrade grade
            if (null != vocab.theResult.result && upgradeGrade)
            switch (vocab.theResult.result) {
                case PERFECT:
                    if (isRUEN)
                    {
                        vocab.gradeRUEN += (100-vocab.gradeRUEN) * 0.25;
                    }
                    else
                    {
                        vocab.gradeENRU += (100-vocab.gradeENRU) * 0.25;
                    }   break;
                case GOOD:
                    if (isRUEN)
                    {
                        vocab.gradeRUEN += (100-vocab.gradeRUEN) * 0.25;
                    }
                    else
                    {
                        vocab.gradeENRU += (100-vocab.gradeENRU) * 0.25;
                    }   break;
                case CLOSE:
                    if (isRUEN)
                    {
                        vocab.gradeRUEN += (100-vocab.gradeRUEN) * 0.25;
                    }
                    else
                    {
                        vocab.gradeENRU += (100-vocab.gradeENRU) * 0.25;
                    }   break;
                default:
                    break;
            }
            
            // Clamp grades
            vocab.gradeRUEN = Math.min(vocab.gradeRUEN, 100);
            vocab.gradeENRU = Math.min(vocab.gradeENRU, 100);
        }
        else
        {
            theGui.SetResult("InCorrect!");
            if (isRUEN)
            {
                vocab.gradeRUEN *= 0.5;
                vocab.gradeRUEN = Math.max(vocab.gradeRUEN, 0);
            }
            else
            {
                vocab.gradeENRU *= 0.5;
                vocab.gradeENRU = Math.max(vocab.gradeENRU, 0);
            }
        }
        
        // Reset the date to today
        if (isRUEN)
        {
            vocab.lastSeenRUEN = new Date();
        }
        else
        {
            vocab.lastSeenENRU = new Date();
        }

        // Wait for user to ack
        waitForEnter = true;
    }
    
    /**
     * Move on to the next word
     */
    public void NextWord()
    {
        // Setup the gui
        if (isRUEN)
        {
            theGui.SetQuestion(theDeck.GetVocab(deckOrder.get(index)).russian);
            
            // Load and play the sound if one exists
            PlaySound();
        }
        else
        {
            theGui.SetQuestion(theDeck.GetVocab(deckOrder.get(index)).english);
        }
        
        theGui.SetResult("");
        theGui.SetAnswer("");
        theGui.ClearAnswertestField();
    }
    
    /**
     * Play the current sound again
     */
    public void PlaySound()
    {
        //mediaPlayer.PlayWav(theGui.GetDeckPath() + "audio/" + theDeck.GetVocab(deckOrder.get(index)).audioFile);
        mediaPlayer.PlayMP3(theGui.GetDeckPath() + "audio/" + theDeck.GetVocab(deckOrder.get(index)).audioFile);
    }
    
    /**
     * End the lesson
     */
    public void EndLesson()
    {
        index = 0;
        isRunning = false;
        theGui.SetResult("");
        theGui.SetAnswer("");
        theGui.SetQuestion("");
        theGui.ClearAnswertestField();
        theGui.SetResult("Lesson Completed");

        // Log lesson stats
        try{
            Date stopTime = new Date();

            long elapsedTime = stopTime.getTime() - startTime.getTime();    // ms
            elapsedTime /= 1000;    // Seconds

            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("LessonLog.txt"), true));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            bfw.append(dateFormat.format(startTime) + "," + vocabCount + "," + elapsedTime);
            bfw.newLine();            
            
            bfw.flush();
            bfw.close();
        }
        catch (Exception ex){}                

        System.out.println("Saved lesson data to log file.");
    }
    
} // end class
