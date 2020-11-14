/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlashCards;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Track time
 */
public class TimeLogger {
    
    /**
     * File location
     */
    final String fileName = "usagedata.txt";
    
    /**
     * Tracks time spent working in seconds
     */
    int timeSpent;
    
    /**
     * Create a new time logger
     */
    void TimeLogger()
    {
        
    }
    
    /**
     * Log time to disk
     */
    void LogTime(int seconds)
    {
        // Read in file
        try {
            String input;
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            input = bfr.readLine();
            bfr.close();

            // Split into separate values
            String[] split = input.split(",");
            
            if (split.length != 2 || split[0] != "timeSpent")
            {
                System.out.println("Invalid usage file...");
                return;
            }
            
            timeSpent = Integer.parseInt(split[1]);
            timeSpent += seconds;
            
            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(fileName)));
            bfw.write("timeSpent," + timeSpent);
            bfw.close();
        }
        catch (Exception e) 
        {
            System.out.println("Invalid usage file...");
            return;
        }        
        
    }
    
}  // end class
