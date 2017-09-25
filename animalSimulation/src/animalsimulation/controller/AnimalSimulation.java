package animalsimulation.controller;

import animalsimulation.view.MainFrame;

/**
 *
 * @author Hirad Gorgoroth main Class that is used to setup the frame and it's
 * initial characteristics Later it will be used to manage other parameters
 * (init)
 */
public class AnimalSimulation {

    public static void main(String[] args) {       
        new AnimalSimulation();
    }
    
    public AnimalSimulation() {
        initializeWorld();
        initializeUI();
    }
    
    private void initializeUI() {
        MainFrame mf = new MainFrame();                                  //creating the main frame (the UI)
        mf.setLocationRelativeTo(null);                                  //centering the frame to center
        mf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        mf.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        mf.setVisible(true);                                             //displaying the frame
    }
    
    private void initializeWorld() {
        // Setup world here!
        
        // Create world..
        // Create groups and agents..
        // Create static objects (e.g. food sources)
    }
}
