/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public class BeeMovement extends BaseMovement {

    public BeeMovement()
    {
        initialize();
    }
    
    public BeeMovement(double x, double y)
    {
        targetX = x;
        targetY = y;
    }
    
    public void initialize() {
        targetX = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getWidth());
        targetY = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getHeight());
    }
    
    public void execute(Agent agent, State state) {
        double[] coordinates = agent.getCoordinates();
        
        double distance = Math.sqrt(Math.pow((targetX - coordinates[0]),2) + Math.pow((targetY - coordinates[1]),2));
        double[] movement =
        {
            (targetX - coordinates[0])/distance * agent.getSpeed(),
            (targetY - coordinates[1])/distance * agent.getSpeed()
        };
        
        agent.setCoordinates(coordinates[0] + movement[0], coordinates[1] + movement[1]);
        super.execute(agent, state);
    }
    
    public void reset() {
        initialize();
    }
    
}
