package AppPackage;

//All code is added to create the widget. Follow the "Create a Widget" tutorial if you want to know how I did it.

//import static AppPackage.MainClass.shuffle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MP3PlayerGUI extends javax.swing.JDialog 
{
    MainClass MC = new MainClass();
    int xMouse;
    int yMouse;
    
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 185;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height - 180;
    
    public MP3PlayerGUI(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocation(width, height);
        //MC.setError("");
        MC.readFile();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Play = new javax.swing.JLabel();
        SelectFile = new javax.swing.JLabel();
        Pause = new javax.swing.JLabel();
        Loop = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        Next = new javax.swing.JLabel();
        speakerChooser = new javax.swing.JComboBox<>();
        Prev = new javax.swing.JLabel();
        Shuffle = new javax.swing.JLabel();
        errorPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        closeError = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AmpliPi");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Play.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/play.png"))); // NOI18N
        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 90, 83));

        SelectFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectFileMouseReleased(evt);
            }
        });
        getContentPane().add(SelectFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 30));

        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseMouseReleased(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 50, 60, 60));

        Loop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/loop.png"))); // NOI18N
        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 437, 40, 30));
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 310, 20));

        Next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NextMouseReleased(evt);
            }
        });
        getContentPane().add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 424, 60, 60));

        speakerChooser.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        speakerChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "This Device", "BT Device", "BT Device" }));
        speakerChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                speakerChooserMouseReleased(evt);
            }
        });
        getContentPane().add(speakerChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 5, 190, -1));

        Prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrevMouseReleased(evt);
            }
        });
        getContentPane().add(Prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 424, 60, 50));

        Shuffle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Shuffle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/shuffle.png"))); // NOI18N
        Shuffle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ShuffleMouseReleased(evt);
            }
        });
        getContentPane().add(Shuffle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 40, 40));

        errorPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Oops");

        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Error Message Here");
        errorMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        errorMessage.setAlignmentX(10.0F);
        errorMessage.setPreferredSize(new java.awt.Dimension(60, 60));

        closeError.setText("OK");
        closeError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeErrorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout errorPanelLayout = new javax.swing.GroupLayout(errorPanel);
        errorPanel.setLayout(errorPanelLayout);
        errorPanelLayout.setHorizontalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(closeError)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(errorPanelLayout.createSequentialGroup()
                .addGroup(errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(errorPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2))
                    .addGroup(errorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        errorPanelLayout.setVerticalGroup(
            errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeError)
                .addContainerGap())
        );

        errorMessage.setLayout(null);

        getContentPane().add(errorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 250, 130));
        setVisible(false);

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/background2.png"))); // NOI18N
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BackgroundMouseDragged

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BackgroundMousePressed
    
    String setError(String message)
    {
        
        return message;
    }
    
    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseReleased
        
        /*if(MC.isPaused == true)
        {   
            try {
                MC.Resume();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
        System.out.println(MC.mode);
        
        if(MC.mode==0)
        {
            MC.mode = 1;
            //MC.readFile();
            MC.Play(MC.playlist[MC.i]);
            Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/pause.png")));
        }
        
        else if(MC.getMode()==1)
        {
            MC.mode = 2;
            MC.Pause();
            Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/play.png")));
        }
        
        else if(MC.getMode()==2)
        {
            MC.mode = 1;
            try {
                MC.Resume();
                Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/pause.png")));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*switch (MC.getMode())
        {
            
            case 0: //not playing
                MC.Play(MC.shuffle());
                Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/pause.png")));
                MC.setMode(1);
            case 1: //if playing
                MC.Pause();
                //MC.setMode(2);
            case 2: //if paused
            {
                try 
                {
                    MC.Resume();
                    //MC.setMode(0);
                }
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (LineUnavailableException ex) 
                {
                    Logger.getLogger(MP3PlayerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        /*if(MC.isPlaying == false)
        {
            MC.Play(MC.shuffle());
            Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/pause.png")));
            MC.isPlaying = true;
        }
        
        /*
        if(MC.isPlaying == true)
        {
            MC.Pause();
            MC.isPaused = true;
            Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/play.png")));
        }
        */
        
    }//GEN-LAST:event_PlayMouseReleased

    private void PauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseMouseReleased
        MC.Pause();
    }//GEN-LAST:event_PauseMouseReleased

    private void SelectFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectFileMouseReleased
       
        {

           MC.chooseSong();
               
       }
    }//GEN-LAST:event_SelectFileMouseReleased

    private void NextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextMouseReleased
        MC.setI(1,1); 
        MC.Stop();
        MC.Play(MC.playlist[MC.i]);
    }//GEN-LAST:event_NextMouseReleased

    private void PrevMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevMouseReleased
        MC.setI(-1, 0);
        MC.Stop();
        MC.Play(MC.playlist[MC.i]);
    }//GEN-LAST:event_PrevMouseReleased

    private void ShuffleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShuffleMouseReleased
        
        MC.settoggleShuffle();   
        Shuffle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/shuffleActive.png")));
        //MC.shuffleArray(MC.playlist);
        //MC.show(MC.playlist);
    }//GEN-LAST:event_ShuffleMouseReleased

    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseReleased
        MC.setLoop();
        Loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/loopActive.png")));
    }//GEN-LAST:event_LoopMouseReleased

    private void speakerChooserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speakerChooserMouseReleased
        MC.getSpeakers();
    }//GEN-LAST:event_speakerChooserMouseReleased

    private void closeErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeErrorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeErrorActionPerformed

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                MP3PlayerGUI dialog = new MP3PlayerGUI(new javax.swing.JFrame(), true);
                //dialog.setAlwaysOnTop(true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                errorPanel.setVisible(false);
                dialog.setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel Loop;
    private javax.swing.JLabel Next;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel Play;
    private javax.swing.JLabel Prev;
    private javax.swing.JLabel SelectFile;
    private javax.swing.JLabel Shuffle;
    public javax.swing.JButton closeError;
    public static javax.swing.JLabel errorMessage;
    public static javax.swing.JPanel errorPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> speakerChooser;
    // End of variables declaration//GEN-END:variables
}
