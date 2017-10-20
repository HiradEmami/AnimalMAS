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
    private static SimulationSettings[] settings;
    private static SimulationController[] simulationControllers;
    
    
    public static void main(String[] args) {  
        initializeWorld();
        initializeUI();
        for(SimulationController simulationController : simulationControllers) {
            simulationController.runForever();
        }
    }
    
    public static SimulationController[] getSimulationController() {
        return simulationControllers;
    }
    
    public static SimulationSettings[] getSettings() {
        return settings;
    }
    
    private static void initializeWorld() {
        simulationControllers = new SimulationController[4];
        settings = new SimulationSettings[4];
        SimulationSettings setting;
        
        setting = createSettings();
        setting.setNumberOfBioScoutBees(10);
        setting.setNumberOfBioWorkerBees(10);
        setting.getMap().createWorld(setting);
        simulationControllers[0] = new SimulationController(setting);
        settings[0] = setting;
        
        setting = createSettings();
        setting.setNumberOfKnowScoutBees(10);
        setting.setNumberOfKnowWorkerBees(10);
        setting.getMap().createWorld(setting);
        simulationControllers[1] = new SimulationController(setting);
        settings[1] = setting;
        
        setting = createSettings();
        setting.setNumberOfMoveScoutBees(10);
        setting.setNumberOfMoveWorkerBees(10);
        setting.getMap().createWorld(setting);
        simulationControllers[2] = new SimulationController(setting);
        settings[2] = setting;
        
        setting = createSettings();
        setting.setNumberOfSnScoutBees(10);
        setting.setNumberOfSnWorkerBees(10);
        setting.getMap().createWorld(setting);
        simulationControllers[3] = new SimulationController(setting);
        settings[3] = setting;
    }
    
    private static SimulationSettings createSettings() {
        SimulationSettings setting = new SimulationSettings();
        setting.setMap(new SingleHiveMap());
        setting.setNumberOfFoodSources(30);
        setting.setRecordingInterval(100);
        setting.setSimulationSteps(100000);
        return setting;
    }
    
    private static void initializeUI() {
        mainFrame = new MainFrame();                                            //creating the main frame (the UI)
        mainFrame.setLocationRelativeTo(null);                                  //centering the frame to center
        mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        mainFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        //mainFrame.setResizable(true);
        mainFrame.setVisible(true);                                             //displaying the frame
    }
}
