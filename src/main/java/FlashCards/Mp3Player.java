package FlashCards;

import java.io.File;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

/**
 * Wrapper to play MP3 files
 */
public class Mp3Player {
    
    
    /**
     * Create a new Mp3Player
     */
    public Mp3Player()
    {
        final JFXPanel fxPanel = new JFXPanel();
    }
    
    /**
     * Play a MP3 file once
     */
    void PlayWav(String fileName)
    {
        try {
            
            // Check if the file exists
            File f = new File(fileName);
            if (!f.exists())
            {
                System.out.println("No such file " + fileName);
                return;
            }
            
            // Load and play
            Clip clip;
            AudioInputStream audioInputStream =  
                AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile()); 
            clip = AudioSystem.getClip(); 
            clip.open(audioInputStream);
            clip.start(); 
        } 
        catch (Exception e) 
        {
            System.out.println("Error loading " + fileName + ", Error: " + e.getMessage());
        }
    }
    
    /**
     * Play a MP3 file once
     */
    void PlayMP3(String fileName)
    {
        // Check if the file exists
        File f = new File(fileName);
        if (!f.exists())
        {
            System.out.println("No such file " + fileName);
            return;
        }
        
        Media hit = new Media(new File(fileName).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    
    
}  // end class
