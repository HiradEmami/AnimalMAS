/*animal Simulator*/

package animalsimulation;

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
    private String imagePath;
    private int gridHeight;
    private int gridWidth;
    private int numAgents;
    private ArrayList<JLabel> tiles;
    private ArrayList<ImageIcon> icons;
    
    private int [][] grid;
    
    public mainFrame() {
      System.out.println("Initializing Components:"); 
      initComponents();
      System.out.println("Initializing Components Completed");
      System.out.println("Initializing Variables:"); 
      this.imagePath=System.getProperty("user.dir")+"\\src\\images";
      System.out.println("path:"+imagePath);
    }

    public void frameSetup(){
    this.gridHeight=0;
    this.gridWidth=0;
    this.numAgents=0;
    this.tiles =new ArrayList<>();
    this.icons =new ArrayList<>();
    readIcons();
    
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
        jButton1 = new javax.swing.JButton();
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

        jButton1.setText("Setup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(jp_SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtf_height)))
                    .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jp_SetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_animal)))
                .addContainerGap())
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
                .addComponent(jButton1)
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

    private void readIcons(){
        icons.add(new ImageIcon(imagePath+"\\EmptyTile.jpg"));  //Position 0 is the empty tile
        icons.add(new ImageIcon(imagePath+"\\Food.jpg"));  //Position 1 is the Food
        icons.add(new ImageIcon(imagePath+"\\horse_group1.jpg"));  //Position 2 is the hourse_group1
        icons.add(new ImageIcon(imagePath+"\\horse_group2.jpg"));  //Position 3 is the hourse_group2
        icons.add(new ImageIcon(imagePath+"\\horse_group3.jpg"));  //Position 4 is the hourse_group3
        icons.add(new ImageIcon(imagePath+"\\horse_group4.jpg"));  //Position 5 is the hourse_group4
        icons.add(new ImageIcon(imagePath+"\\horse_group5.jpg"));  //Position 6 is the hourse_group5 
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       removeTiles();
       setupWorld();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
   private void setupWorld(){
        gridHeight=Integer.parseInt(jtf_height.getText());
        gridWidth=Integer.parseInt(jtf_width.getText());
        numAgents=Integer.parseInt(jtf_animal.getText());
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
       generateGridSetup();
       render();
      
       
         this.pack();
   } 
   
   private void generateGridSetup(){
       //place all empty tiles
        grid = new int[gridHeight][gridWidth];
        for(int i=0;i<=gridHeight-1;i++){
            for(int j=0; j<=gridWidth-1;j++){
                grid[i][j]= 0; 
            }
        }  
        
        //place animals
        for(int i=0;i<=numAgents-1;i++){
            boolean counter= false;
            while(!counter){
              int argHeight= getRandom(0, gridHeight-1);
              int argWidth=  getRandom(0, gridWidth-1); 
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
       if(grid[x][y]==0){
               return true;
            }else{
                return false;
            }
   }
   private void render(){
       int counter =0;
        for(int i=0;i<=gridHeight-1;i++){
            for(int j=0; j<=gridWidth-1;j++){
                switch(grid[i][j]){
                    case 0:
                    {
                       tiles.get(counter).setIcon(icons.get(0));
                       tiles.get(counter).setText(""); 
                       break;
                    }
                    case 1:
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
                       tiles.get(counter).setText("ERROR");
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
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jp_SetupPanel;
    private javax.swing.JPanel jp_worldPanel;
    private javax.swing.JTextField jtf_animal;
    private javax.swing.JTextField jtf_height;
    private javax.swing.JTextField jtf_width;
    // End of variables declaration//GEN-END:variables
}
