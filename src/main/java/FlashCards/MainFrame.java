package FlashCards;

import javax.swing.UIManager;
import javax.swing.JFileChooser;
import java.io.File;

/**
 * Our main gui
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * The lesson being studied
     */
    Lesson theLesson;
    
    /**
     * The currently loaded deck
     */
    Deck theDeck = new Deck();

    /**
     * The maximum number of active words to learn
     */
    int numActiveVocab = 100;
    
    /**
     * Path to the loaded deck
     */
    String deckPath = "";
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        // Blank out everything
        SetQuestion("");
        SetAnswer("");
        SetResult("Load a Deck to study...");
    }
    
    /**
     * Set the question text
     */
    public void SetQuestion(String s)
    {
        jLabelQuestion.setText(s);
    }
    
    /**
     * Set the answer
     */
    public void SetAnswer(String s)
    {
        jLabelAnswer.setText(s);
    }

    /**
     * Set the result
     */
    public void SetResult(String s)
    {
        jLabelResult.setText(s);
    }
    
    /**
     * Clear the answer text field
     */
    public void ClearAnswertestField()
    {
        jTextFieldAnswer.setText("");
    }
    
    /**
     * Return the path to the deck file
     */
    public String GetDeckPath()
    {
        return deckPath;
    }
    
    /**
     * Set the progress indicators
     */
    public void SetProgress(int count, int total)
    {
        jLabelVocabCount.setText("" + count);
        jLabelVocabNum.setText("" + total);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelStudy = new javax.swing.JPanel();
        jTextFieldAnswer = new javax.swing.JTextField();
        jLabelQuestion = new javax.swing.JLabel();
        jLabelAnswer = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jLabelLessonTimer = new javax.swing.JLabel();
        jButtonStudy = new javax.swing.JButton();
        jButtonLoad = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabelVocabCount = new javax.swing.JLabel();
        jLabelVocabNum = new javax.swing.JLabel();
        jButtonStudyReverse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLessonSize = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flash Russian V0");
        setName("FlashRussian"); // NOI18N

        jTextFieldAnswer.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jTextFieldAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnswerActionPerformed(evt);
            }
        });

        jLabelQuestion.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuestion.setText("jLabel1");
        jLabelQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelQuestionMouseClicked(evt);
            }
        });

        jLabelAnswer.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAnswer.setText("jLabel2");
        jLabelAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAnswerMouseClicked(evt);
            }
        });

        jLabelResult.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResult.setText("jLabel1");

        jLabelLessonTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLessonTimer.setText("0:00");

        javax.swing.GroupLayout jPanelStudyLayout = new javax.swing.GroupLayout(jPanelStudy);
        jPanelStudy.setLayout(jPanelStudyLayout);
        jPanelStudyLayout.setHorizontalGroup(
            jPanelStudyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAnswer)
                    .addComponent(jLabelAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStudyLayout.createSequentialGroup()
                        .addGroup(jPanelStudyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelStudyLayout.createSequentialGroup()
                                .addGap(0, 570, Short.MAX_VALUE)
                                .addComponent(jLabelLessonTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(jLabelQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelStudyLayout.setVerticalGroup(
            jPanelStudyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStudyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLessonTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonStudy.setText("RU-EN");
        jButtonStudy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudyActionPerformed(evt);
            }
        });

        jButtonLoad.setText("Load");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelVocabCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVocabCount.setText("###");
        jLabelVocabCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelVocabNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVocabNum.setText("###");
        jLabelVocabNum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonStudyReverse.setText("EN-RU");
        jButtonStudyReverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudyReverseActionPerformed(evt);
            }
        });

        jLabel1.setText("Lesson Size");

        jTextFieldLessonSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldLessonSize.setText("100");

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelVocabNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelVocabCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldLessonSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonStudy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonStudyReverse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelStudy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelStudy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStudy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStudyReverse)
                        .addGap(25, 25, 25)
                        .addComponent(jButtonLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSave)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLessonSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelVocabCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelVocabNum)
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStudyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudyActionPerformed

        // Check if the deck is loaded
        if (theDeck.NumberOfWords() == 0)
        {
            SetResult("No vocab to study!");
            System.out.println("No vocab to study!");
            return;
        }

        // Start a new lesson
        theLesson = new Lesson(this, theDeck, true, Integer.parseInt(jTextFieldLessonSize.getText()));

        // Set focus and away we go
        jTextFieldAnswer.setCaretPosition(0);
        
    }//GEN-LAST:event_jButtonStudyActionPerformed

    private void jTextFieldAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnswerActionPerformed
        
        // Nothing to do if the lesson is not running
        if (theLesson == null)
            return;

        // Send to the lesson for processing
        theLesson.HandleInput(jTextFieldAnswer.getText());
        
    }//GEN-LAST:event_jTextFieldAnswerActionPerformed

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed
        
        // Open a file chooser and select a csv file to load
        JFileChooser jfc = new JFileChooser();
        int retval = jfc.showOpenDialog(this);
        if (retval == JFileChooser.APPROVE_OPTION)
        {
            File f = jfc.getSelectedFile();
            theDeck.LoadFromFile(f);
            
            String split [] = f.getPath().split("/");
            deckPath = "";
            for (int i  = 0; i < split.length-1; i++)
            {
                deckPath += (split[i] + "/");
            }
            
            System.out.println("File path: " + deckPath);
            System.out.println("Loaded " + theDeck.NumberOfWords() + " words.");
            
            jLabelResult.setText("Deck Loaded. " + theDeck.NumberOfWords() + " words.  Ready to start a lesson.");
        }
        
    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        // Save a previously loaded deck to csv
        theDeck.SaveToFile(deckPath);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jLabelQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuestionMouseClicked
        // Play the sound again
        theLesson.PlaySound();
    }//GEN-LAST:event_jLabelQuestionMouseClicked

    private void jButtonStudyReverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudyReverseActionPerformed
        // Check if the deck is loaded
        if (theDeck.NumberOfWords() == 0)
        {
            SetResult("No vocab to study!");
            System.out.println("No vocab to study!");
            return;
        }

        // Start a new lesson
        theLesson = new Lesson(this, theDeck, false, Integer.parseInt(jTextFieldLessonSize.getText()));

        // Set focus and away we go
        jTextFieldAnswer.setCaretPosition(0);

    }//GEN-LAST:event_jButtonStudyReverseActionPerformed

    private void jLabelAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAnswerMouseClicked
        // Play the sound again
        theLesson.PlaySound();
    }//GEN-LAST:event_jLabelAnswerMouseClicked

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        theLesson.EndLesson();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
                } 
                catch (Exception e) {
                   // handle exception
                }

                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonStudy;
    private javax.swing.JButton jButtonStudyReverse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAnswer;
    private javax.swing.JLabel jLabelLessonTimer;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel jLabelVocabCount;
    private javax.swing.JLabel jLabelVocabNum;
    private javax.swing.JPanel jPanelStudy;
    private javax.swing.JTextField jTextFieldAnswer;
    private javax.swing.JTextField jTextFieldLessonSize;
    // End of variables declaration//GEN-END:variables
}
