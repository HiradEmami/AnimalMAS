package animalsimulation.controller;

import animalsimulation.map.SingleHiveMap;
import animalsimulation.model.base.SimulationSettings;
import animalsimulation.view.MainFrame;


/**
 *
 * @author Hirad Gorgoroth main Class that is used to setup the frame and it's
 * initial characteristics Later it will be used to manage other parameters
 * (init)
 */
public class AnimalSimulation {
    private static MainFrame mainFrame;
    private static SimulationSettings settings;
    private static SimulationController simulationController;
    
    
    public static void main(String[] args) {  
        ChartExamples testchart =new ChartExamples(args);
        
        initializeWorld();
        initializeUI();
        simulationController.runForever();
    }
    
    public static SimulationController getSimulationController() {
        return simulationController;
    }
    
    public static SimulationSettings getSettings() {
        return settings;
    }
    
    private static void initializeWorld() {
        settings = new SimulationSettings();
        settings.setMap(new SingleHiveMap());
        settings.setNumberOfFoodSources(10);
        settings.setNumberOfScoutBees(10);
        settings.setNumberOfWorkerBees(20);
        settings.getMap().createWorld(settings);
        
        simulationController = new SimulationController(settings);
    }
    
    private static void initializeUI() {
        mainFrame = new MainFrame();                                            //creating the main frame (the UI)
        mainFrame.setLocationRelativeTo(null);                                  //centering the frame to center
        mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        mainFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);                                             //displaying the frame
    }
}
