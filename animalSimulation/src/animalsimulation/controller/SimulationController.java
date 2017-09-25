/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;

import animalsimulation.model.base.Agent;
import animalsimulation.model.base.World;
import animalsimulation.view.WorldPanel;

/**
 * Controller class for linking the World model to the WorldPanel view.
 * The controller enables starting and stoping a simulation thread. 
 * @author jeroen
 */
public class SimulationController implements Runnable {
    private WorldPanel view;
    private World world;
    private Thread thread;
    
    public SimulationController(World world) {
        this.world = world;
    }
    
    // Executes one simulation step.
    public void step() {
        Agent[] agents = world.getAgents();
        // view.whipe();
        
        for (Agent agent : agents) {
            agent.act();
            // view.draw(agent);
        }
    }
    
    public void runForever() {
        thread = new Thread(this);
        thread.start();
    }
    
    public void stopSimulation() {
        thread = null;
    }
    
    @Override
    public void run() {
        while(thread != null) {
            // Continuously run the step method.
        }
    }
}
