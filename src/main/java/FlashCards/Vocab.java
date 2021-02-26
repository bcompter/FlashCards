package FlashCards;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A vocabulary pair
 */
public class Vocab {
    
    /**
     * Translations
     */
    String english;
    String russian;
    
    /**
     * Filename for an audio file for this vocab
     */
    String audioFile = "none";
    
    /**
     * The last time we saw this vocab
     */
    Date lastSeenRUEN = new Date();
    Date lastSeenENRU = new Date();
    
    /**
     * The result of studying this word
     */
    Result theResult = new Result(Result.eRESULT.NONE);
    
    /**
     * Current grade, an estimate of how well we know this word
     */
    float gradeRUEN = 0.0f;
    float gradeENRU = 0.0f;
    
    /**
     * Number of times we studied this word
     */
    int timesStudiedRUEN = 0;
    int timesStudiedENRU = 0;
    
    /**
     * Relative frequency in the language
     */
    int frequency = 99;
    
    /**
     * Default constructor
     */
    public Vocab()
    {
        /* do nothing... */
    }
    
    /**
     * Create a new vocab
     */
    public Vocab(String eng, String rus)
    {
        english = eng;
        russian = rus;
    }       
    
    /**
     * Get the english translation for this vocab
     */
    String GetEnglish()
    {
        return english;
    }
    
    /**
     * Get the Russian translation for this vocab
     */
    String GetRussian()
    {
        return russian;
    }
    
    /**
     * Clear the result
     */
    void ClearResult()
    {
        theResult = new Result(Result.eRESULT.NONE);
    }
    
    /**
     * Convert this vocab to a string for storage
     */
    String ConvertToString()
    {
        // Format our date in advance
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String lastSeenStrRUEN = "NA";
        String lastSeenStrENRU = "NA";
        if (lastSeenStrRUEN != null)
        {
            lastSeenStrRUEN = formatter.format(lastSeenRUEN);
        }
        if (lastSeenStrENRU != null)
        {
            lastSeenStrENRU = formatter.format(lastSeenENRU);
        }

        return  english + "," +
                russian + "," +
                gradeRUEN + "," +
                timesStudiedRUEN + "," +
                lastSeenStrRUEN + "," +
                gradeENRU + "," +
                timesStudiedENRU + "," +
                lastSeenStrENRU + "," +                
                frequency + "," +
                audioFile;
    }    
}
