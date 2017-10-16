/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;

import animalsimulation.model.base.Agent;
import animalsimulation.model.base.DataRecorder;
import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;
import java.io.IOException;

/**
 * Controller class for linking the World model to the WorldPanel view.
 * The controller enables starting and stoping a simulation thread. 
 * @author jeroen
 */
public class SimulationController extends BaseController implements Runnable {
    private final SimulationSettings settings;
    private final DataRecorder recorder;
    private Thread thread;
    private int step;
    
    public SimulationController(SimulationSettings settings) {
        this.settings = settings;
        model = settings.getMap().getWorld();
        recorder = settings.getMap().getDataRecorder();
    }
    
    // Executes one simulation step.
    public void step() throws IOException {
        World world = (World) model;
        Agent[] agents = world.getWorldObjectsByClass(Agent.class);
        
        for (Agent agent : agents) {
            agent.act();
        }
        
        updateViews();
        
        step++;
        if(step % settings.getRecordingInterval() == 0 || step == 1) {
            recorder.persistData(step);
        }
    }
    
    public synchronized void runForever() {
        thread = new Thread(this);
        thread.start();
    }
    
    public void stopSimulation() {
        thread = null;
    }
    
    // Reset the state of the simulation using the information
    // contained within the SimulationSettings instance.
    public void resetSimulation() {
        stopSimulation();
        model = settings.getMap().createWorld(settings);
        updateViews();
        runForever();
    }
    
    @Override
    public void run() {
        while(thread != null) {
            synchronized(this) {
                try {
                    step();
                    Thread.sleep(20);
                }
                catch (InterruptedException ex) {}
                catch (IOException ioe) {
                    ioe.printStackTrace();
                    System.exit(1);
                }
                
                if(step == settings.getSimulationSteps()) {
                    stopSimulation();
                }
            }
        }
    }
}