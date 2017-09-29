/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;

import animalsimulation.model.base.Agent;
import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;

/**
 * Controller class for linking the World model to the WorldPanel view.
 * The controller enables starting and stoping a simulation thread. 
 * @author jeroen
 */
public class SimulationController extends BaseController implements Runnable {
    private final SimulationSettings settings;
    private Thread thread;
    
    public SimulationController(SimulationSettings settings) {
        this.settings = settings;
        model = settings.getMap().getWorld();
    }
        
    // Executes one simulation step.
    public void step() {
        World world = (World) model;
        Agent[] agents = world.getWorldObjectsByClass(Agent.class);
        for (Agent agent : agents) {
            agent.act();
        }
        updateViews();
    }
    
    public void runForever() {
        thread = new Thread(this);
        thread.start();
    }
    
    public void stopSimulation() {
        //thread.stop(); WAS NEEDED TO DONT GO FASTER
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
            try {
                step();
                Thread.sleep(20);
            } catch (InterruptedException ex) {}
        }
    }
}