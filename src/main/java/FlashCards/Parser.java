package FlashCards;

import java.util.Arrays;
import java.util.Collections;

/**
 * Parse answers for correctness
 */
public class Parser {
    
    /**
     * Parse an answer to see if it is correct
     */
    static public Result GetResult(String answer, String input)
    {
        // Ignore anything between parens
        if (answer.contains("(") && answer.contains(")"))
        {
            answer = answer.substring(0, answer.indexOf("("));
        }        
        
        // Prepare input
        input = input.trim().toLowerCase();        
            
        // Handle multiple possible answers
        String [] answers = answer.split("/");
        int [] results = new int[answers.length];
        
        for (int i = 0; i < answers.length; i++)
        {
            answers[i] = answers[i].trim().toLowerCase();
                    
            if (answers[i].equalsIgnoreCase(input))
            {
                results[i] = 4;
                continue;
            }

            int dist = LevenshteinDist(answers[i], input);
            if (dist <= 2)
            {
                results[i] = 3;
            }
            else if (dist <= 4)
            {
                results[i] = 2;
            }
            else
            {
                results[i] = 1;
            }
        }

        // Return max result
        int max = 0;
        for (int i : results)
        {
            if (i > max)
                max = i;
        }
        if (max == 4)
            return new Result(Result.eRESULT.PERFECT);
        else if (max == 3)
            return new Result(Result.eRESULT.GOOD);
        else if (max == 2)
            return new Result(Result.eRESULT.CLOSE);
        else
            return new Result(Result.eRESULT.INCORRECT);
    }
    
    /**
     * Levenshtein Distance
     */
    static int LevenshteinDist(String x, String y) 
    {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1] 
                     + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
                      dp[i - 1][j] + 1, 
                      dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }
    
    /**
     * Cost of substitution
     */
    public static int costOfSubstitution(char a, char b) 
    {
        return a == b ? 0 : 1;
    }
    
    /**
     * Min function
     */
    public static int min(int... numbers) 
    {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
    
}
