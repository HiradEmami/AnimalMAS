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
    private static SimulationController[] simulationControllers;
    
    
    public static void main(String[] args) {  
        //ChartExamples testchart =new ChartExamples(args);
        initializeWorld();
        initializeUI();
        for(SimulationController simulationController : simulationControllers) {
            simulationController.runForever();
        }
    }
    
    public static SimulationController[] getSimulationController() {
        return simulationControllers;
    }
    
    public static SimulationSettings getSettings() {
        return settings;
    }
    
    private static void initializeWorld() {
        simulationControllers = new SimulationController[4];
        
        settings = createSettings();
        settings.setNumberOfBioScoutBees(10);
        settings.setNumberOfBioWorkerBees(10);
        settings.getMap().createWorld(settings);
        simulationControllers[0] = new SimulationController(settings);
        
        settings = createSettings();
        settings.setNumberOfKnowScoutBees(10);
        settings.setNumberOfKnowWorkerBees(10);
        settings.getMap().createWorld(settings);
        simulationControllers[1] = new SimulationController(settings);
        
        settings = createSettings();
        settings.setNumberOfMoveScoutBees(10);
        settings.setNumberOfMoveWorkerBees(10);
        settings.getMap().createWorld(settings);
        simulationControllers[2] = new SimulationController(settings);
        
        settings = createSettings();
        settings.setNumberOfSnScoutBees(10);
        settings.setNumberOfSnWorkerBees(10);
        settings.getMap().createWorld(settings);
        simulationControllers[3] = new SimulationController(settings);
    }
    
    private static SimulationSettings createSettings() {
        settings = new SimulationSettings();
        settings.setMap(new SingleHiveMap());
        settings.setNumberOfFoodSources(30);
        settings.setRecordingInterval(100);
        settings.setSimulationSteps(100000);
        return settings;
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
