/**
 *
 * @author Ebombo2
 * This class is basically the main frame and UI
 */
package animalsimulation.view;

//required imports 
import animalsimulation.controller.SimulationController;
import animalsimulation.model.base.SimulationSettings;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {
    private String imagePath;
    private SimulationSettings settings = animalsimulation.controller.AnimalSimulation.getSettings();
    private SimulationController[] simControllers = animalsimulation.controller.AnimalSimulation.getSimulationController();    

    public MainFrame() {
        initComponents();                                                   //Creating and managing the main components
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jp_worldPanel = new javax.swing.JPanel();
        jp_SetupPanel = new javax.swing.JPanel();
        worldPanel1 = new animalsimulation.view.WorldPanel(simControllers[0]);
        worldPanel2 = new animalsimulation.view.WorldPanel(simControllers[1]);
        worldPanel3 = new animalsimulation.view.WorldPanel(simControllers[2]);
        worldPanel4 = new animalsimulation.view.WorldPanel(simControllers[3]);
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tlb_animal = new javax.swing.JLabel();
        jb_SetupButton = new javax.swing.JButton();
        jsl_animal = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jp_worldPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));

        javax.swing.GroupLayout worldPanel1Layout = new javax.swing.GroupLayout(worldPanel1);
        worldPanel1.setLayout(worldPanel1Layout);
        worldPanel1Layout.setHorizontalGroup(
            worldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        worldPanel1Layout.setVerticalGroup(
            worldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
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
	
        jp_worldPanel.add(worldPanel1);

        javax.swing.GroupLayout worldPanel2Layout = new javax.swing.GroupLayout(worldPanel2);
        worldPanel2.setLayout(worldPanel2Layout);
        worldPanel2Layout.setHorizontalGroup(
            worldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        worldPanel2Layout.setVerticalGroup(
            worldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jp_worldPanel.add(worldPanel2);

        javax.swing.GroupLayout worldPanel3Layout = new javax.swing.GroupLayout(worldPanel3);
        worldPanel3.setLayout(worldPanel3Layout);
        worldPanel3Layout.setHorizontalGroup(
            worldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        worldPanel3Layout.setVerticalGroup(
            worldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jp_worldPanel.add(worldPanel3);

        javax.swing.GroupLayout worldPanel4Layout = new javax.swing.GroupLayout(worldPanel4);
        worldPanel4.setLayout(worldPanel4Layout);
        worldPanel4Layout.setHorizontalGroup(
            worldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        worldPanel4Layout.setVerticalGroup(
            worldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jp_worldPanel.add(worldPanel4);

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
        );
        jp_SetupPanelLayout.setVerticalGroup(
            jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jsl_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jb_SetupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tlb_animal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jsl_animal.getAccessibleContext().setAccessibleName("");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_SetupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_worldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_SetupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_worldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    //Action Event for the setup button that runs the simulation
    private void jb_SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        setupWorld();           //Creating the grid and calling render method within
        repaintScreen();        //Method to remove the previously built tiles (reset UI)
    }                                              

    private void jsl_animalStateChanged(javax.swing.event.ChangeEvent evt) {                                        
        tlb_animal.setText(Integer.toString(jsl_animal.getValue()));
        setupWorld();           //Creating the grid and calling render method within
        repaintScreen();        //Method to remove the previously built tiles (reset UI)
    }                                       

    private void setupWorld() {
        try {
            jsl_animal.setMaximum(100);
            settings.setNumberOfBioScoutBees(jsl_animal.getValue());
            settings.setNumberOfBioWorkerBees(jsl_animal.getValue());
            settings.setNumberOfKnowScoutBees(jsl_animal.getValue());
            settings.setNumberOfKnowWorkerBees(jsl_animal.getValue());
            settings.setNumberOfMoveScoutBees(jsl_animal.getValue());
            settings.setNumberOfMoveWorkerBees(jsl_animal.getValue());
            settings.setNumberOfSnScoutBees(jsl_animal.getValue());
            settings.setNumberOfSnWorkerBees(jsl_animal.getValue());
            this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);   //to make it full screen
        } catch (Exception e) {                                         //Display the error if it failed to create the simulation
            JOptionPane.showMessageDialog(null, "Failed to Create the simulation!\nError: " + e);
        }
    }
    
    private void repaintScreen() {
        for(SimulationController simController : simControllers) {
            simController.resetSimulation();
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jb_SetupButton;
    private javax.swing.JPanel jp_SetupPanel;
    private javax.swing.JPanel jp_worldPanel;
    private javax.swing.JSlider jsl_animal;
    private javax.swing.JLabel tlb_animal;
    private animalsimulation.view.WorldPanel worldPanel1;
    private animalsimulation.view.WorldPanel worldPanel2;
    private animalsimulation.view.WorldPanel worldPanel3;
    private animalsimulation.view.WorldPanel worldPanel4;
    // End of variables declaration                   
}