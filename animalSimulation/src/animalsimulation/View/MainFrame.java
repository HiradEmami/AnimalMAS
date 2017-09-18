/**
 *
 * @author Ebombo2
 * This class is basically the main frame and UI
 */
package animalsimulation.View;

//required imports 
import animalsimulation.Model.*;
import animalsimulation.View.*;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;

public class MainFrame extends javax.swing.JFrame {

    private String imagePath;                                   //The path to the folder which contains the images
    private int spread, gridHeight, gridWidth, numWorkers, origin = 0;      //Height of the main grid(will be collected by user input), Width if the grid (will be collected by user input)
    private double amountScouts;

    private ArrayList<ImageIcon> icons = new ArrayList<>();     //List of imported images for rendering
    private ArrayList<BeeScout> scouts = new ArrayList<>();     //List of all created scouts
    private ArrayList<BeeHive> hives = new ArrayList<>();       //List of all created hives
    private ArrayList<BeeFood> foods = new ArrayList<>();       //List of all created foods
    private ArrayList<BeeWorker> workers = new ArrayList<>();   //List of all created workers

    public MainFrame() {
        System.out.println("Initializing Components:");
        initComponents();                                       //Creating and managing the main components
        System.out.println("Initializing Components Completed");
        System.out.println("Initializing Variables:");
        this.imagePath = System.getProperty("user.dir") + "\\images";
        frameSetup();                                           //Handeling other (non-static) parameters 
    }

    //This method will rebuild all the parameters and can be used to reset them
    public void frameSetup() {
        jtf_height.setText("300");
        jtf_width.setText("400");
        readIcons();                                            //Calling the method to read all the images

        //set the guide icons
        guid_hive.setIcon(icons.get(0));
        guid_food.setIcon(icons.get(1));
        guid_beeScout.setIcon(icons.get(2));
        guid_beeWorker.setIcon(icons.get(3));
        this.pack();
    }

    private void topPanelManager(int argPanel) {
        //Simulation Control =0
        //World Information =1
        //Agent Information =2
        //Individual Agent =3
        //Guide = 4

        switch (argPanel) {
            case 0: {
                jp_Agents.setVisible(false);
                jp_individualAgent.setVisible(false);
                jp_world.setVisible(false);
                jp_guide.setVisible(false);
                jp_simulationControl.setVisible(true);
                break;
            }
            case 1: {
                jp_Agents.setVisible(false);
                jp_individualAgent.setVisible(false);
                jp_guide.setVisible(false);
                jp_simulationControl.setVisible(false);
                jp_world.setVisible(true);
                break;
            }
            case 2: {
                jp_individualAgent.setVisible(false);
                jp_world.setVisible(false);
                jp_guide.setVisible(false);
                jp_simulationControl.setVisible(false);
                jp_Agents.setVisible(true);
                break;
            }
            case 3: {
                jp_Agents.setVisible(false);
                jp_world.setVisible(false);
                jp_guide.setVisible(false);
                jp_simulationControl.setVisible(false);
                jp_individualAgent.setVisible(true);
                break;
            }
            case 4: {
                jp_Agents.setVisible(false);
                jp_individualAgent.setVisible(false);
                jp_world.setVisible(false);
                jp_simulationControl.setVisible(false);
                jp_guide.setVisible(true);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_worldPanel = new javax.swing.JPanel();
        worldPanel1 = new animalsimulation.View.WorldPanel();
        jp_infoPanel = new javax.swing.JPanel();
        jp_simulationControl = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jp_individualAgent = new javax.swing.JPanel();
        combo_agnet = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jp_Agents = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jp_guide = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        guid_food = new javax.swing.JLabel();
        guid_hive = new javax.swing.JLabel();
        guid_beeScout = new javax.swing.JLabel();
        guid_beeWorker = new javax.swing.JLabel();
        jp_world = new javax.swing.JPanel();
        jp_SetupPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_height = new javax.swing.JTextField();
        jtf_width = new javax.swing.JTextField();
        jb_SetupButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combo_Control = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jb_setPanelButton = new javax.swing.JButton();
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

        jp_infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        jp_infoPanel.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Simulate next stage:");

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Simulate the Entire round:");

        jButton3.setText("Simulate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_simulationControlLayout = new javax.swing.GroupLayout(jp_simulationControl);
        jp_simulationControl.setLayout(jp_simulationControlLayout);
        jp_simulationControlLayout.setHorizontalGroup(
            jp_simulationControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_simulationControlLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_simulationControlLayout.setVerticalGroup(
            jp_simulationControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_simulationControlLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jp_simulationControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_infoPanel.add(jp_simulationControl, "card6");

        jLabel8.setText("Select the agent:");

        jButton4.setText("Select");

        jLabel9.setText("Id:");

        jLabel10.setText("Energy:");

        jLabel11.setText("Current Location:");

        jLabel12.setText("Group Number:");

        javax.swing.GroupLayout jp_individualAgentLayout = new javax.swing.GroupLayout(jp_individualAgent);
        jp_individualAgent.setLayout(jp_individualAgentLayout);
        jp_individualAgentLayout.setHorizontalGroup(
            jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_individualAgentLayout.createSequentialGroup()
                .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_individualAgentLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_agnet, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_individualAgentLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel8))))
                    .addGroup(jp_individualAgentLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton4)))
                .addGap(92, 92, 92)
                .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_individualAgentLayout.setVerticalGroup(
            jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_individualAgentLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_agnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_individualAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_infoPanel.add(jp_individualAgent, "card5");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "ID", "Group", "Cord"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jp_AgentsLayout = new javax.swing.GroupLayout(jp_Agents);
        jp_Agents.setLayout(jp_AgentsLayout);
        jp_AgentsLayout.setHorizontalGroup(
            jp_AgentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_AgentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jp_AgentsLayout.setVerticalGroup(
            jp_AgentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AgentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jp_infoPanel.add(jp_Agents, "card4");

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

        javax.swing.GroupLayout jp_worldLayout = new javax.swing.GroupLayout(jp_world);
        jp_world.setLayout(jp_worldLayout);
        jp_worldLayout.setHorizontalGroup(
            jp_worldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_worldLayout.setVerticalGroup(
            jp_worldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jp_infoPanel.add(jp_world, "card2");

        jp_SetupPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel1.setText("World Setup: ");

        jLabel2.setText("Width:");

        jLabel3.setText("Height:");

        jb_SetupButton.setText("Setup");
        jb_SetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_SetupButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Animal:");

        combo_Control.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simulation Control", "World Information", "Agent Information", "Individual Agent", "Guide" }));

        jLabel5.setText("Information Panel");

        jb_setPanelButton.setText("Set");
        jb_setPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_setPanelButtonActionPerformed(evt);
            }
        });

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
                            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jtf_width))
                            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_height))
                            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tlb_animal)
                                            .addComponent(jsl_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_SetupButton)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_Control, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_setPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jp_SetupPanelLayout.setVerticalGroup(
            jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jsl_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tlb_animal)
                .addGap(28, 28, 28)
                .addComponent(jb_SetupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jb_setPanelButton)
                .addGap(26, 26, 26))
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

    private void readIcons() {                                              //method to read images and add them to 
        icons.add(new ImageIcon(imagePath + "\\hive.jpg"));                 //Position 0 is the hive
        icons.add(new ImageIcon(imagePath + "\\food.jpg"));                 //Position 1 is the food
        icons.add(new ImageIcon(imagePath + "\\bee_scout.jpg"));            //Position 2 is the bee_scout
        icons.add(new ImageIcon(imagePath + "\\bee_worker.jpg"));           //Position 3 is the bee_worker
    }

    //Action Event for the setup button that runs the simulation
    private void jb_SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SetupButtonActionPerformed
        int inputHeight = Integer.parseInt(jtf_height.getText());
        int inputWidth = Integer.parseInt(jtf_width.getText());

        if (inputHeight > 1000 || inputWidth > 1000) {
            JOptionPane.showMessageDialog(null, "The Grid size is too big , maximum 300 x 400 ");
        } else {
            setupWorld();           //Creating the grid and calling render method within
            repaintScreen();        //Method to remove the previously built tiles (reset UI)
        }
    }//GEN-LAST:event_jb_SetupButtonActionPerformed

    private void jb_setPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_setPanelButtonActionPerformed
        topPanelManager(combo_Control.getSelectedIndex());
    }//GEN-LAST:event_jb_setPanelButtonActionPerformed

    private void jsl_animalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsl_animalStateChanged
        //Reading the three main inputs from the user   
        int inputHeight = Integer.parseInt(jtf_height.getText());
        int inputWidth = Integer.parseInt(jtf_width.getText());
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
            // gridHeight = Integer.parseInt(jtf_height.getText());
            gridHeight = jp_worldPanel.getHeight() - 20;
            //gridWidth = Integer.parseInt(jtf_width.getText());
            gridWidth = jp_worldPanel.getWidth() - 20;
            jsl_animal.setMaximum(100);
            numWorkers = jsl_animal.getValue();
            spread = 100;
            createHive(50, 50);
            createFoods();
            createWorkers();
            createScouts();
            this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);   //to make it full screen
        } catch (Exception e) {                                         //Display the error if it failed to create the simulation
            JOptionPane.showMessageDialog(null, "Failed to Create the simulation!\nError: " + e);
        }
    }

    private void createHive(double percentX, double percentY) {
        hives.retainAll(hives);
        hives = new ArrayList<>();
        BeeHive b = new BeeHive();
        b.currentHeight = (int) Math.round((percentY / 100) * gridHeight);
        b.currentWidth = (int) Math.round((percentX / 100) * gridWidth);
        hives.add(b);
    }

    private void createFood(double percentX, double percentY) {
        BeeFood argFood = new BeeFood();
        argFood.currentHeight = (int) Math.round((percentY / 100) * gridHeight);
        argFood.currentWidth = (int) Math.round((percentX / 100) * gridWidth);
        foods.add(argFood);
    }

    private void createScout() {
        BeeScout argScout = new BeeScout();
        int randomId, argHeight, argWidth;
        boolean counter = false;
        while (!counter) {
            randomId = getRandom(100, 999);
            if (acceptableID(randomId)) {
                argScout.setId(randomId);
                counter = true;
            }
        }
        if (hives.size() > 0) {
            int i = getRandom(0, hives.size() - 1);
            argHeight = getRandom(hives.get(i).currentHeight - spread, hives.get(i).currentHeight + spread);      //getting random height 
            argWidth = getRandom(hives.get(i).currentWidth - spread, hives.get(i).currentWidth + spread);        //getting a random width
        } else {
            argHeight = getRandom(20, gridHeight - 1);      //getting random height 
            argWidth = getRandom(20, gridWidth - 1);        //getting a random width
        }
        argScout.setCoordination(argHeight, argWidth);
        scouts.add(argScout);
    }

    private void createWorker() {
        BeeWorker argWorker = new BeeWorker();
        int randomId, argHeight, argWidth;
        boolean counter = false;
        while (!counter) {
            randomId = getRandom(100, 999);
            if (acceptableID(randomId)) {
                argWorker.setId(randomId);
                counter = true;
            }
        }
        if (hives.size() > 0) {
            int i = getRandom(0, hives.size() - 1);
            argHeight = getRandom(hives.get(i).currentHeight - spread, hives.get(i).currentHeight + spread);      //getting random height 
            argWidth = getRandom(hives.get(i).currentWidth - spread, hives.get(i).currentWidth + spread);        //getting a random width
        } else {
            argHeight = getRandom(20, gridHeight - 1);      //getting random height 
            argWidth = getRandom(20, gridWidth - 1);        //getting a random width
        }
        argWorker.setCoordination(argHeight, argWidth);
        workers.add(argWorker);
    }
    
    private void createFoods() {
        foods.retainAll(foods);
        foods = new ArrayList<>();
        for (int i = 0; i < 3; i += 2) {
            createFood(25 + 25 * i, 25 + 25 * i);           //25-25 75-25
            createFood(75 - 25 * i, 25 + 25 * i);               //75-25 25-75
        }
    }
    
    private void createScouts() {
        scouts.retainAll(scouts);
        scouts = new ArrayList<>();
        for (int i = 0; i<amountScouts; i++) {
            createScout();
        }
    }

    private void createWorkers() {
        amountScouts = (int)Math.round((numWorkers)/3);
        workers.retainAll(workers);
        workers = new ArrayList<>();
        for (int i = 0; i < numWorkers-amountScouts; i++) {
            createWorker();
        }
    }

    private boolean acceptableID(int argId) {
        for (int j = 0; j <= scouts.size() - 1; j++) {
            if (argId == scouts.get(j).id) {
                return false;
            }
        }
        return true;
    }

//    private int getAgentGroup(int argID) {
//        int agentPosition = 0;
//        for (int i = 0; i <= scouts.size() - 1; i++) {
//            if (argID == scouts.get(i).id) {
//                agentPosition = scouts.get(i).groupNumber;
//                return agentPosition;
//            }
//        }
//        return agentPosition;
//    }
    private void repaintScreen() {
        jp_worldPanel.revalidate();
        worldPanel1.upDate(numWorkers, origin, scouts, hives, foods, workers);
        this.repaint();
    }

    //method to get random 
    private static int getRandom(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
    private javax.swing.JComboBox<String> combo_Control;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_SetupButton;
    private javax.swing.JButton jb_setPanelButton;
    private javax.swing.JPanel jp_Agents;
    private javax.swing.JPanel jp_SetupPanel;
    private javax.swing.JPanel jp_guide;
    private javax.swing.JPanel jp_individualAgent;
    private javax.swing.JPanel jp_infoPanel;
    private javax.swing.JPanel jp_simulationControl;
    private javax.swing.JPanel jp_world;
    private javax.swing.JPanel jp_worldPanel;
    private javax.swing.JSlider jsl_animal;
    private javax.swing.JTextField jtf_height;
    private javax.swing.JTextField jtf_width;
    private javax.swing.JLabel tlb_animal;
    private animalsimulation.View.WorldPanel worldPanel1;
    // End of variables declaration//GEN-END:variables
}
