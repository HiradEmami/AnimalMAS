/**
 *
 * @author Ebombo2
 * This class is basically the main frame and UI
 */
package animalsimulation.view;

//required imports 
import animalsimulation.model.bee.BeeScout;
import animalsimulation.model.bee.BeeHive;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    private int spread, gridHeight, gridWidth, numWorkers, origin = 0;      //Height of the main grid(will be collected by user input), Width if the grid (will be collected by user input)
    private double amountScouts;

    private ArrayList<BeeScout> scouts = new ArrayList<>();     //List of all created scouts
    private ArrayList<BeeHive> hives = new ArrayList<>();       //List of all created hives

    public MainFrame() {
        System.out.println("Initializing Components:");
        initComponents();                                                   //Creating and managing the main components
        System.out.println("Initializing Components Completed");
        System.out.println("Initializing Variables:");
        frameSetup();               
    }
    
    //This method will rebuild all the parameters and can be used to reset them
    public void frameSetup() {
//        //set the guide icons
//        guid_hive.setIcon(icons.get(0));
//        guid_food.setIcon(icons.get(1));
//        guid_beeScout.setIcon(icons.get(2));
//        guid_beeWorker.setIcon(icons.get(3));
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_worldPanel = new javax.swing.JPanel();
        worldPanel1 = new animalsimulation.view.WorldPanel();
        jp_infoPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        combo_agnet = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jp_guide = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        guid_food = new javax.swing.JLabel();
        guid_hive = new javax.swing.JLabel();
        guid_beeScout = new javax.swing.JLabel();
        guid_beeWorker = new javax.swing.JLabel();
        jp_SetupPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jb_SetupButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jsl_animal = new javax.swing.JSlider();
        tlb_animal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jp_worldPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));

        javax.swing.GroupLayout worldPanel1Layout = new javax.swing.GroupLayout(worldPanel1);
        worldPanel1.setLayout(worldPanel1Layout);
        worldPanel1Layout.setHorizontalGroup(
            worldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        worldPanel1Layout.setVerticalGroup(
            worldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_worldPanelLayout = new javax.swing.GroupLayout(jp_worldPanel);
        jp_worldPanel.setLayout(jp_worldPanelLayout);
        jp_worldPanelLayout.setHorizontalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(worldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jp_worldPanelLayout.setVerticalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(worldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel13.setText("Icons:");

        guid_food.setText("Food");

        guid_hive.setText("Hive");

        guid_beeScout.setText("Scout");

        guid_beeWorker.setText("Worker");

        javax.swing.GroupLayout jp_guideLayout = new javax.swing.GroupLayout(jp_guide);
        jp_guide.setLayout(jp_guideLayout);
        jp_guideLayout.setHorizontalGroup(
            jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_guideLayout.createSequentialGroup()
                .addGroup(jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_guideLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel13))
                    .addGroup(jp_guideLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(guid_food)
                        .addGap(66, 66, 66)
                        .addComponent(guid_hive)
                        .addGap(62, 62, 62)
                        .addComponent(guid_beeScout)
                        .addGap(70, 70, 70)
                        .addComponent(guid_beeWorker)))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jp_guideLayout.setVerticalGroup(
            jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_guideLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel13)
                .addGap(40, 40, 40)
                .addGroup(jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guid_hive)
                    .addComponent(guid_food)
                    .addComponent(guid_beeScout)
                    .addComponent(guid_beeWorker))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jp_infoPanel.add(jp_guide, "card3");

        jp_SetupPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel1.setText("World Setup: ");

        jb_SetupButton.setText("Setup");
        jb_SetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_SetupButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Animal:");

        jsl_animal.setValue(10);
        jsl_animal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsl_animalStateChanged(evt);
            }
        });

        tlb_animal.setText(Integer.toString(jsl_animal.getValue()));

        javax.swing.GroupLayout jp_SetupPanelLayout = new javax.swing.GroupLayout(jp_SetupPanel);
        jp_SetupPanel.setLayout(jp_SetupPanelLayout);
        jp_SetupPanelLayout.setHorizontalGroup(
            jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                        .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tlb_animal)
                                    .addComponent(jsl_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_SetupButton)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addContainerGap())))
        );
        jp_SetupPanelLayout.setVerticalGroup(
            jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(92, 92, 92)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jsl_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tlb_animal)
                .addGap(28, 28, 28)
                .addComponent(jb_SetupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5))
                .addGap(69, 69, 69))
        );

        jsl_animal.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_worldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_SetupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_SetupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_worldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action Event for the setup button that runs the simulation
    private void jb_SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SetupButtonActionPerformed
        setupWorld();           //Creating the grid and calling render method within
        repaintScreen();        //Method to remove the previously built tiles (reset UI)
    }//GEN-LAST:event_jb_SetupButtonActionPerformed

    private void jsl_animalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsl_animalStateChanged
        //Reading the three main inputs from the user   
        tlb_animal.setText(Integer.toString(jsl_animal.getValue()));
        setupWorld();           //Creating the grid and calling render method within
        repaintScreen();        //Method to remove the previously built tiles (reset UI)
    }//GEN-LAST:event_jsl_animalStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        origin += 10;
        repaintScreen();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for (int i = 0; i < 10; i++) {
            origin += 10;
            repaintScreen();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void setupWorld() {
        try {
            jsl_animal.setMaximum(100);
            numWorkers = jsl_animal.getValue();
            this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);   //to make it full screen
        } catch (Exception e) {                                         //Display the error if it failed to create the simulation
            JOptionPane.showMessageDialog(null, "Failed to Create the simulation!\nError: " + e);
        }
    }
    
    private void repaintScreen() {
        jp_worldPanel.revalidate();
        this.repaint();
    }

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_agnet;
    private javax.swing.JLabel guid_beeScout;
    private javax.swing.JLabel guid_beeWorker;
    private javax.swing.JLabel guid_food;
    private javax.swing.JLabel guid_hive;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_SetupButton;
    private javax.swing.JPanel jp_SetupPanel;
    private javax.swing.JPanel jp_guide;
    private javax.swing.JPanel jp_infoPanel;
    private javax.swing.JPanel jp_worldPanel;
    private javax.swing.JSlider jsl_animal;
    private javax.swing.JLabel tlb_animal;
    private animalsimulation.view.WorldPanel worldPanel1;
    // End of variables declaration//GEN-END:variables
}
