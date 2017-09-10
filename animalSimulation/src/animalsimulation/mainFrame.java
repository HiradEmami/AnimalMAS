/*animal Simulator*/

/**
 *
 * @author Hirad Gorgoroth
 * This class is basically the main frame and UI 
 */



package animalsimulation;

//required imports 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.*;
import java.util.*;

public class mainFrame extends javax.swing.JFrame {
    
    private String imagePath; //the path to the folder which contains the images
    private int gridHeight; //height of the main grid(will be collected by user input)
    private int gridWidth; //width if the grid (will be collected by user input)
    private int numAgents; // total number of imput images (will be collected by user input)
    private ArrayList<JLabel> tiles; //list of Jlabels that are used to display images
    private ArrayList<ImageIcon> icons; //list of imported images for rendering
    private ArrayList<animalAgents> agents; //List of all created agents
    private int [][] grid; // 2D matrix that represents the world in format of [height] [width]
    
    public mainFrame() {
      System.out.println("Initializing Components:"); 
      initComponents(); //creating and managing the main components
      System.out.println("Initializing Components Completed");
      System.out.println("Initializing Variables:"); 
      this.imagePath=System.getProperty("user.dir")+"\\images"; //setting the path to image folder
      System.out.println("path:"+imagePath);
      frameSetup(); //handeling other (non-static) parameters 
    }

    public void frameSetup(){ //This method will rebuild all the parameters and can be used to reset them
     
    this.gridHeight=0;
    this.gridWidth=0;
    this.numAgents=0;
    this.tiles =new ArrayList<>();
    this.icons =new ArrayList<>();
    this.agents=new ArrayList<>();
    readIcons(); //calling the method to read all the images
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_worldPanel = new javax.swing.JPanel();
        jp_SetupPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_height = new javax.swing.JTextField();
        jtf_width = new javax.swing.JTextField();
        jb_SetupButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtf_animal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_worldPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));

        javax.swing.GroupLayout jp_worldPanelLayout = new javax.swing.GroupLayout(jp_worldPanel);
        jp_worldPanel.setLayout(jp_worldPanelLayout);
        jp_worldPanelLayout.setHorizontalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_worldPanelLayout.setVerticalGroup(
            jp_worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jp_SetupPanelLayout = new javax.swing.GroupLayout(jp_SetupPanel);
        jp_SetupPanel.setLayout(jp_SetupPanelLayout);
        jp_SetupPanelLayout.setHorizontalGroup(
            jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(jLabel1)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_animal)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_SetupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_SetupButton)
                .addGap(27, 27, 27))
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
                .addGap(30, 30, 30)
                .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_animal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_SetupButton)
                .addGap(37, 37, 37))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));

        jLabel5.setText("World Information:");

        jLabel6.setText("Food:");

        jLabel7.setText("Agents:");

        jLabel8.setText("Groups:");

        jLabel9.setText("World Size:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(205, 205, 205)
                .addComponent(jLabel7)
                .addGap(173, 173, 173)
                .addComponent(jLabel8)
                .addGap(132, 132, 132)
                .addComponent(jLabel9)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_worldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_SetupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_SetupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_worldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readIcons(){ //method to read images and add them to 
        icons.add(new ImageIcon(imagePath+"\\EmptyTile.jpg"));  //Position 0 is the empty tile
        icons.add(new ImageIcon(imagePath+"\\Food.jpg"));  //Position 1 is the Food
        icons.add(new ImageIcon(imagePath+"\\horse_group1.jpg"));  //Position 2 is the hourse_group1
        icons.add(new ImageIcon(imagePath+"\\horse_group2.jpg"));  //Position 3 is the hourse_group2
        icons.add(new ImageIcon(imagePath+"\\horse_group3.jpg"));  //Position 4 is the hourse_group3
        icons.add(new ImageIcon(imagePath+"\\horse_group4.jpg"));  //Position 5 is the hourse_group4
        icons.add(new ImageIcon(imagePath+"\\horse_group5.jpg"));  //Position 6 is the hourse_group5 
    }
    private void jb_SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SetupButtonActionPerformed
       //Action Event for the setup button that runs the simulation
        removeTiles(); //Method to remove the previously built tiles (reset UI)
        setupWorld(); //Creating the grid and calling render method within
       
    }//GEN-LAST:event_jb_SetupButtonActionPerformed

    
   private void setupWorld(){
       try {
          JOptionPane.showMessageDialog(null,"Rendering Images from:"+ imagePath);
        //Reading the three main inputs from the user   
        gridHeight=Integer.parseInt(jtf_height.getText());
        gridWidth=Integer.parseInt(jtf_width.getText());
        numAgents=Integer.parseInt(jtf_animal.getText());
        //setup the labels and organize them according to width and height
        jp_worldPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for(int i=0;i<=gridHeight-1;i++){
            for(int j=0; j<=gridWidth-1;j++){
              c.fill=GridBagConstraints.HORIZONTAL;
              c.gridx =j;
              c.gridy=i;
              JLabel newTile = new JLabel();
              newTile.setText("SETUP");
              tiles.add(newTile);
              
              jp_worldPanel.add(tiles.get(tiles.size()-1),c);
            }
        }
       generateGridSetup();//create the 2d Grid representing the world
       render(); //render the labels with the designed texture images accoording to grid 
      
       
         this.pack(); //pack the window to look organized 
         
       } catch (Exception e) {//Display the error if it failed to create the simulation
           
           JOptionPane.showMessageDialog(null, "Failed to Create the simulation!\nError: "+e);
       }
   } 
   
   private void generateGridSetup(){
       //place all empty tiles at the beginning in the grid 
       //at the end of this loop the 2d grid matrix will be all zeros (empty tiles)
        grid = new int[gridHeight][gridWidth];//creading the array (2d Matrix)
        for(int i=0;i<=gridHeight-1;i++){
            for(int j=0; j<=gridWidth-1;j++){
                grid[i][j]= 0; 
            }
        }  
        
        //place animals
        for(int i=0;i<=numAgents-1;i++){ //for the number of agents assign a random position in the grid
            boolean counter= false;
            while(!counter){
              int argHeight= getRandom(0, gridHeight-1); //getting random height 
              int argWidth=  getRandom(0, gridWidth-1);  //getting a random width
              /*the following method (acceptableTile) returns boolean 
              based on the current state of the grid,
              if the coordination in the grid is zero (empty) the animal can occupy it 
              if the grid is already occupied then it returns false which will 
              result in going through the loop again until it finds an acceptable spot
              */
              if(acceptableTile(argHeight, argWidth)){ 
                  grid[argHeight][argWidth]=2;
                  counter=true;
              }
              else{
                  counter=false;
              }
            }   
        }
        //place food 
        //this section follows the exact same logic as placing the animals 
         for(int i=0;i<=1-1;i++){
            boolean counter= false;
            while(!counter){
              int argHeight= getRandom(0, gridHeight-1);
              int argWidth=  getRandom(0, gridWidth-1); 
              if(acceptableTile(argHeight, argWidth)){
                  grid[argHeight][argWidth]=1;
                  counter=true;
              }
              else{
                  counter=false;
              }
            }   
        }
   }
   private boolean acceptableTile(int x , int y){ 
       //method that checks if the random coordination in the grid is
       //empty (available) or occupied
       if(grid[x][y]==0){ //if the spot was empty
               return true; //return true (available)
            }else{ //if not 
                return false; //return false (occupied)
            }
   }
   private void createAgents(){
        //recreate the array list
        agents.retainAll(agents);
        agents=new ArrayList<>();
        System.out.println(agents.size());
        
        for(int i=0;i<=numAgents-1;i++){
            int randomId;
            boolean counter=false;
            while(!counter){
                randomId= getRandom(100, 999);
                if(acceptableID(randomId)){
                    
                }
            }
            
        }
   }
   private boolean acceptableID(int argId){
       for(int j=0;j<=agents.size()-1;j++){
                    if(argId == agents.get(j).id){
                        return false;
                    }
                }
       return true;
   }
   private void render(){ //rendering method to display images
       int counter =0;
        for(int i=0;i<=gridHeight-1;i++){
            for(int j=0; j<=gridWidth-1;j++){
                switch(grid[i][j]){ //checking the value of the grid cells 
                    /* in this swich every value represents specific thing based on
                    the values defined for the images, Look at the animal agents'
                    group value comment for more information
                    */
                    
                    case 0: //empty tile 
                    {
                       tiles.get(counter).setIcon(icons.get(0)); //display the image 
                       tiles.get(counter).setText(""); //remove the testing text 
                       break;
                    }
                    case 1://Food tile 
                    {
                       tiles.get(counter).setIcon(icons.get(1));
                       tiles.get(counter).setText("");  
                       break;
                    }
                    case 2:
                    {
                       tiles.get(counter).setIcon(icons.get(2));
                       tiles.get(counter).setText(""); 
                       break;
                    }
                    case 3:
                    {
                      tiles.get(counter).setIcon(icons.get(3));
                       tiles.get(counter).setText("");
                       break;
                    }
                    case 4:
                    {
                       tiles.get(counter).setIcon(icons.get(4));
                       tiles.get(counter).setText("");
                       break;
                    }
                    case 5:
                    {
                      tiles.get(counter).setIcon(icons.get(5));
                       tiles.get(counter).setText("");  
                       break;
                    }
                    case 6:
                    {
                       tiles.get(counter).setIcon(icons.get(6));
                       tiles.get(counter).setText("");
                       break;
                    }
                    default:
                    {
                      tiles.get(counter).setIcon(icons.get(0));
                       tiles.get(counter).setText("ERROR"); //add ERROR message to the tile to easily identify the issue 
                       break;
                    }
                   
                }
                counter++;
            }
        }   
   }
   
   private void removeTiles(){
        for(int i=0;i<=tiles.size()-1;i++){
            jp_worldPanel.remove(tiles.get(i));
        }
        jp_worldPanel.revalidate();
        jp_worldPanel.repaint();
        tiles.retainAll(tiles);
        tiles=new ArrayList<>();
        System.out.println(tiles.size());
   }
   
   private static int getRandom(int min, int max) { //method to get random 

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_SetupButton;
    private javax.swing.JPanel jp_SetupPanel;
    private javax.swing.JPanel jp_worldPanel;
    private javax.swing.JTextField jtf_animal;
    private javax.swing.JTextField jtf_height;
    private javax.swing.JTextField jtf_width;
    // End of variables declaration//GEN-END:variables
}
