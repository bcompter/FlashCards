package FlashCards;

/**
 * A result
 */
public class Result {
  
    /**
     * Possible result outcomes
     */
    public static enum eRESULT
    {
        NONE,
        INCORRECT,
        CLOSE,
        GOOD,
        PERFECT
    }
    
    /**
     * Create a new result with the given output
     */
    public Result(eRESULT r)
    {
        result = r;
    }
    
    /**
     * Member variables
     */
    eRESULT result = eRESULT.NONE;
    
}
