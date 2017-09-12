/*animal Simulator*/
/**
 *
 * @author Hirad Gorgoroth
 * This class is basically the main frame and UI
 */
package animalsimulation;

//required imports 
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import javax.swing.UIManager;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class mainFrame extends javax.swing.JFrame {

    private String imagePath;               //the path to the folder which contains the images
    private int gridHeight;                 //height of the main grid(will be collected by user input)
    private int gridWidth;                  //width if the grid (will be collected by user input)
    private int numAgents;                  //total number of imput images (will be collected by user input)
    private ArrayList<JLabel> tiles;        //list of Jlabels that are used to display images
    private ArrayList<ImageIcon> icons;     //list of imported images for rendering
    private ArrayList<animalAgents> agents; //List of all created agents
    private int[][] grid;                   // 2D matrix that represents the world in format of [height] [width]
    private  DefaultTableModel table1;
    public mainFrame() {
        System.out.println("Initializing Components:");
        initComponents();                   //creating and managing the main components
        System.out.println("Initializing Components Completed");
        System.out.println("Initializing Variables:");
        this.imagePath = System.getProperty("user.dir") + "\\images";
        //setting the path to image folder
        System.out.println("path:" + imagePath);
        frameSetup();                       //handeling other (non-static) parameters 
        table1= (DefaultTableModel) jTable1.getModel();
    }

    //This method will rebuild all the parameters and can be used to reset them
    public void frameSetup() {
        this.gridHeight = 0;
        this.gridWidth = 0;
        this.numAgents = 0;
        this.tiles = new ArrayList<>();
        this.icons = new ArrayList<>();
        this.agents = new ArrayList<>();
        readIcons();                        //calling the method to read all the images

        //set the guide icons
        guid_empty.setIcon(icons.get(0));
        guid_food.setIcon(icons.get(1));
        guid_individual.setIcon(icons.get(2));
        guid_group1.setIcon(icons.get(3));
        guid_group2.setIcon(icons.get(4));
        guid_group3.setIcon(icons.get(5));
        guid_group4.setIcon(icons.get(6));
        this.pack();

    }
   private void setupTable(){
        for(int i=0;i<=agents.size()-1;i++)
           {String cord=agents.get(i).currentHeight+" x "+agents.get(i).currentWidth;
                table1.addRow(new Object[]{(i+1),agents.get(i).id,agents.get(i).groupNumber,cord});
           }
        
   }
   private void refreshTable(){
         table1 = (DefaultTableModel) jTable1.getModel(); 
          int x= table1.getRowCount()-1;
           while(x>=0)
        {
            table1.removeRow(x);
            x--;
        }
            
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
        guid_group3 = new javax.swing.JLabel();
        guid_group2 = new javax.swing.JLabel();
        guid_group4 = new javax.swing.JLabel();
        guid_group1 = new javax.swing.JLabel();
        guid_individual = new javax.swing.JLabel();
        guid_empty = new javax.swing.JLabel();
        guid_food = new javax.swing.JLabel();
        jb_githubButton = new javax.swing.JButton();
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

        javax.swing.GroupLayout jp_worldPanelLayout = new javax.swing.GroupLayout(jp_worldPanel);
        jp_worldPanel.setLayout(jp_worldPanelLayout);
        jp_worldPanelLayout.setHorizontalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_worldPanelLayout.setVerticalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jp_infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        jp_infoPanel.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Simulate next stage:");

        jButton2.setText("Next");

        jLabel7.setText("Simulate the Entire round:");

        jButton3.setText("Simulate");

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

        guid_group3.setText("Group 3");

        guid_group2.setText("Group2");

        guid_group4.setText("Group 4");

        guid_group1.setText("Group 1");

        guid_individual.setText("Individual");

        guid_empty.setText("Empty Tile");

        guid_food.setText("Food");

        jb_githubButton.setText("Github");
        jb_githubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_githubButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_guideLayout = new javax.swing.GroupLayout(jp_guide);
        jp_guide.setLayout(jp_guideLayout);
        jp_guideLayout.setHorizontalGroup(
            jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_guideLayout.createSequentialGroup()
                .addGroup(jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_guideLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(jb_githubButton))
                    .addGroup(jp_guideLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(guid_food)
                        .addGap(66, 66, 66)
                        .addComponent(guid_individual)
                        .addGap(62, 62, 62)
                        .addComponent(guid_group1)
                        .addGap(70, 70, 70)
                        .addComponent(guid_group2)
                        .addGap(69, 69, 69)
                        .addComponent(guid_group3)
                        .addGap(60, 60, 60)
                        .addComponent(guid_group4)
                        .addGap(63, 63, 63)
                        .addComponent(guid_empty)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_guideLayout.setVerticalGroup(
            jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_guideLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jb_githubButton))
                .addGap(35, 35, 35)
                .addGroup(jp_guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guid_group4)
                    .addComponent(guid_individual)
                    .addComponent(guid_food)
                    .addComponent(guid_group1)
                    .addComponent(guid_group2)
                    .addComponent(guid_group3)
                    .addComponent(guid_empty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jtf_height.setText("10");

        jtf_width.setText("10");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        icons.add(new ImageIcon(imagePath + "\\EmptyTile.jpg"));            //Position 0 is the empty tile
        icons.add(new ImageIcon(imagePath + "\\Food.jpg"));                 //Position 1 is the Food
        icons.add(new ImageIcon(imagePath + "\\horse_individual.jpg"));     //Position 6 is the horse_individual
        icons.add(new ImageIcon(imagePath + "\\horse_group1.jpg"));         //Position 2 is the horse_group1
        icons.add(new ImageIcon(imagePath + "\\horse_group2.jpg"));         //Position 3 is the horse_group2
        icons.add(new ImageIcon(imagePath + "\\horse_group3.jpg"));         //Position 4 is the horse_group3
        icons.add(new ImageIcon(imagePath + "\\horse_group4.jpg"));         //Position 5 is the horse_group4
    }

    //Action Event for the setup button that runs the simulation
    private void jb_SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SetupButtonActionPerformed
        //Reading the three main inputs from the user   
           int inputHeight = Integer.parseInt(jtf_height.getText());
            int inputWidth = Integer.parseInt(jtf_width.getText());
            jsl_animal.setMaximum((inputHeight*inputWidth)-1);
            jsl_animal.setMinimum((0));
        
        if(inputHeight>10 || inputHeight>10){
          JOptionPane.showMessageDialog(null, "The Grid size is too big , maximum 10 x 10 ");
        }else{
            removeTiles();      //Method to remove the previously built tiles (reset UI)
            setupWorld();       //Creating the grid and calling render method within
        }

    }//GEN-LAST:event_jb_SetupButtonActionPerformed

    private void jb_setPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_setPanelButtonActionPerformed
        topPanelManager(combo_Control.getSelectedIndex());
    }//GEN-LAST:event_jb_setPanelButtonActionPerformed

    private void jb_githubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_githubButtonActionPerformed
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://github.com/HiradEmami/AnimalMAS");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jb_githubButtonActionPerformed

    private void jsl_animalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsl_animalStateChanged
        tlb_animal.setText(Integer.toString(jsl_animal.getValue()));
        removeTiles();      //Method to remove the previously built tiles (reset UI)
        setupWorld();
    }//GEN-LAST:event_jsl_animalStateChanged

    private void setupWorld() {
        try {
            //JOptionPane.showMessageDialog(null, "Rendering Images from:" + imagePath);
            gridHeight = Integer.parseInt(jtf_height.getText());
            gridWidth = Integer.parseInt(jtf_width.getText());
            numAgents = jsl_animal.getValue();
            
            //Setup the labels and organize them according to width and height
            jp_worldPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            for (int i = 0; i <= gridHeight - 1; i++) {
                for (int j = 0; j <= gridWidth - 1; j++) {
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.gridx = j;
                    c.gridy = i;
                    JLabel newTile = new JLabel();
                    newTile.setText("SETUP");
                    tiles.add(newTile);

                    jp_worldPanel.add(tiles.get(tiles.size() - 1), c);
                }
            }
            generateGridSetup();                                        //create the 2d Grid representing the world
            render();                                                   //render the labels with the designed texture images accoording to grid 

            // this.pack();                                             //pack the window to look organized 
            this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);   //to make it full screen

        } catch (Exception e) {                                         //Display the error if it failed to create the simulation
            JOptionPane.showMessageDialog(null, "Failed to Create the simulation!\nError: " + e);
        }
    }

    //place all empty tiles at the beginning in the grid 
    //at the end of this loop the 2d grid matrix will be all zeros (empty tiles)
    private void generateGridSetup() {
        grid = new int[gridHeight][gridWidth];                          //creading the array (2d Matrix)
        for (int i = 0; i <= gridHeight - 1; i++) {
            for (int j = 0; j <= gridWidth - 1; j++) {
                grid[i][j] = 0;
            }
        }

        //place animals
        createAgents();
        //for the number of agents assign a random position in the grid
        for (int i = 0; i <= numAgents - 1; i++) {
            boolean counter = false;
            while (!counter) {
                int argHeight = getRandom(0, gridHeight - 1);           //getting random height 
                int argWidth = getRandom(0, gridWidth - 1);             //getting a random width
                /*the following method (acceptableTile) returns boolean 
                              based on the current state of the grid,
                              if the coordination in the grid is zero (empty) the animal can occupy it 
                              if the grid is already occupied then it returns false which will 
                              result in going through the loop again until it finds an acceptable spot
                 */
                if (acceptableTile(argHeight, argWidth)) {
                    grid[argHeight][argWidth] = agents.get(i).id;
                    agents.get(i).setCoordination(argHeight, argWidth);
                    counter = true;
                } else {
                    counter = false;
                }
            }
        }
        refreshTable();
        setupTable();
        
        //place food 
        //this section follows the exact same logic as placing the animals 
        for (int i = 0; i <= 1 - 1; i++) {
            boolean counter = false;
            while (!counter) {
                int argHeight = getRandom(0, gridHeight - 1);
                int argWidth = getRandom(0, gridWidth - 1);
                if (acceptableTile(argHeight, argWidth)) {
                    grid[argHeight][argWidth] = 1;
                    counter = true;
                } else {
                    counter = false;
                }
            }
        }
    }

    private boolean acceptableTile(int x, int y) {
        //method that checks if the random coordination in the grid is
        //empty (available) or occupied
        if (grid[x][y] == 0) { //if the spot was empty
            return true; //return true (available)
        } else { //if not 
            return false; //return false (occupied)
        }
    }

    private void createAgents() {
        //recreate the array list
        agents.retainAll(agents);
        agents = new ArrayList<>();
        System.out.println(agents.size());

        for (int i = 0; i <= numAgents - 1; i++) {
            animalAgents argAgent = new animalAgents();
            int randomId;
            boolean counter = false;
            while (!counter) {
                randomId = getRandom(100, 999);
                if (acceptableID(randomId)) {
                    argAgent.setId(randomId);
                    counter = true;
                }
            }
            agents.add(argAgent);
            System.out.println("Agent created with id: " + argAgent.id);
        }
    }

    private boolean acceptableID(int argId) {
        for (int j = 0; j <= agents.size() - 1; j++) {
            if (argId == agents.get(j).id) {
                return false;
            }
        }
        return true;
    }

    //rendering method to display images
    private void render() {
        int counter = 0;
        for (int i = 0; i <= gridHeight - 1; i++) {
            for (int j = 0; j <= gridWidth - 1; j++) {
                //checking the value of the grid cells 
                switch (grid[i][j]) {
                    /* in this swich every value represents specific thing based on
                    the values defined for the images, Look at the animal agents'
                    group value comment for more information
                     */

                    case 0: //Empty tile 
                    {
                        tiles.get(counter).setIcon(icons.get(0)); //display the image 
                        tiles.get(counter).setText(""); //remove the testing text 
                        tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                        tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                        break;
                    }
                    case 1: //Food tile 
                    {
                        tiles.get(counter).setIcon(icons.get(1));
                        tiles.get(counter).setText("");
                        tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                        tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                        break;
                    }

                    default: {
                        switch (getAgentGroup(grid[i][j])) {
                            case 2: { //Individual
                                tiles.get(counter).setIcon(icons.get(2));
                                tiles.get(counter).setText("");
                                tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                                tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                                break;
                            }
                            case 3: { //Group 1
                                tiles.get(counter).setIcon(icons.get(3));
                                tiles.get(counter).setText("");
                                tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                                tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                                break;
                            }
                            case 4: { //Group 2
                                tiles.get(counter).setIcon(icons.get(4));
                                tiles.get(counter).setText("");
                                tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                                tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                                break;
                            }
                            case 5: { //Group 3
                                tiles.get(counter).setIcon(icons.get(5));
                                tiles.get(counter).setText("");
                                tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                                tiles.get(counter).setVerticalTextPosition(JLabel.BOTTOM);
                                break;
                            }
                            case 6: { //Group 4
                                tiles.get(counter).setIcon(icons.get(6));
                                tiles.get(counter).setText("");
                                tiles.get(counter).setHorizontalTextPosition(JLabel.CENTER);
                                tiles.get(counter).setVerticalTextPosition(JLabel.TOP);
                                break;
                            }
                        }
                        break;
                    }
                }
                counter++;
                
            }
        }
    }

    private int getAgentGroup(int argID) {
        int agentPosition = 0;
        for (int i = 0; i <= agents.size() - 1; i++) {
            if (argID == agents.get(i).id) {
                agentPosition = agents.get(i).groupNumber;
                return agentPosition;
            }
        }
        return agentPosition;
    }

    private void removeTiles() {
        for (int i = 0; i <= tiles.size() - 1; i++) {
            jp_worldPanel.remove(tiles.get(i));
        }
        jp_worldPanel.revalidate();
        jp_worldPanel.repaint();
        tiles.retainAll(tiles);
        tiles = new ArrayList<>();
        System.out.println(tiles.size());
    }

    //method to get random 
    private static int getRandom(int min, int max) { 

        if (min >= max) {
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Control;
    private javax.swing.JComboBox<String> combo_agnet;
    private javax.swing.JLabel guid_empty;
    private javax.swing.JLabel guid_food;
    private javax.swing.JLabel guid_group1;
    private javax.swing.JLabel guid_group2;
    private javax.swing.JLabel guid_group3;
    private javax.swing.JLabel guid_group4;
    private javax.swing.JLabel guid_individual;
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
    private javax.swing.JButton jb_githubButton;
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
    // End of variables declaration//GEN-END:variables
}
