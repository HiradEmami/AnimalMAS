/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation;

/**
 *
 * @author Hirad Gorgoroth
 */
public class AnimalSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       mainFrame mf = new mainFrame();
       mf.setLocationRelativeTo(null);
       mf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       mf.frameSetup();
       mf.setVisible(true);
    }
    
}
