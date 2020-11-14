package FlashCards;

import java.util.ArrayList;
import java.io.File;
import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;

/**
 * A collection of vocab that can be studied
 */
public class Deck {
    
    /**
     * A name for this deck
     */
    String name;
    
    /**
     * List of all the vocab in this deck
     */
    ArrayList <Vocab> vocabulary = new ArrayList();
    
    /**
     * Load a deck from a file
     */
    public void LoadFromFile(File f)
    {        
        // Clear out any previous vocab
        vocabulary.clear();
        
        // Set the name
        name = f.getName();
        
        // Read through and parse all the vocab data
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String input = bfr.readLine(); // skip the header
            while ( (input = bfr.readLine() ) != null )
            {
                // Split into separate values
                String[] split = input.split(",");
                
                // Size check, ignore if wrong
                if (split.length != 10)
                    continue;
                
                Vocab v = new Vocab();
                v.english = split[0];
                v.russian = split[1];
                v.gradeRUEN = Float.parseFloat(split[2]);
                v.timesStudiedRUEN = Integer.parseInt(split[3]);
                
                if (split[4].equalsIgnoreCase("NA"))
                {
                    v.lastSeenRUEN = new Date();
                }
                else
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    v.lastSeenRUEN = formatter.parse(split[4]);
                }
                
                v.gradeENRU = Float.parseFloat(split[5]);
                v.timesStudiedENRU = Integer.parseInt(split[6]);
                if (split[7].equalsIgnoreCase("NA"))
                {
                    v.lastSeenENRU = new Date();
                }
                else
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    v.lastSeenENRU = formatter.parse(split[7]);
                }

                v.frequency = Integer.parseInt(split[8]);
                v.audioFile = split[9];
                
                // Add the completed vocab to our list
                vocabulary.add(v);
            }
        }
        catch (Exception e) {}
    }
    
    /**
     * Save this deck to a file
     */
    public void SaveToFile(String deckPath)
    {
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(deckPath + "/" + name)));
            
            // Header
            bfw.write("English,Russian,RU-EN,Times Studied,Last Seen,EN-RU,Times Studied,Last Seen,Frequency,Audio File");
            bfw.newLine();
            
            // All the vocab
            int count = 0;
            for (Vocab v : vocabulary)
            {
                bfw.write(v.ConvertToString());
                bfw.newLine();
                count++;
            }
            bfw.flush();
            bfw.close();
            
            System.out.println("Saved " + count + " words to " + "/" + name);
            
        }
        catch (Exception e) 
        {
            System.out.println("Failed to save due to error " + e.getMessage());
        }
    }
    
    /**
     * Add a new vocab to this deck
     */
    public void AddVocab(Vocab v)
    {
        vocabulary.add(v);
    }
    
    /**
     * Get a vocab at a particular index
     */
    public Vocab GetVocab(int i)
    {
        return vocabulary.get(i);
    }
    
    /**
     * Get the size of our vocab list
     */
    public int NumberOfWords()
    {
        return vocabulary.size();
    }
}
