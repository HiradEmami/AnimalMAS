/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author jeroen
 */
public class BeeMovement extends BaseMovement {

    public void initialize(Agent agent, State state) {
        if (state.getStateName().equals("Returning")) {
            BeeAgent bee = (BeeAgent) agent;
            double[] coordinates = bee.getHive().getCoordinates();

            targetX = coordinates[0];
            targetY = coordinates[1];
        } else {
            targetX = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getWidth());
            targetY = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getHeight());
        }
    }

    public void execute(Agent agent, State state) {
        double[] coordinates = agent.getCoordinates();
        double distance = agent.distanceToLocation(targetX, targetY);
        
        if(distance < agent.getSpeed()) {
            agent.setCoordinates(targetX, targetY);
        } else {
            double[] movement = {
                (targetX - coordinates[0]) / distance * agent.getSpeed(),
                (targetY - coordinates[1]) / distance * agent.getSpeed()
            };
            agent.setCoordinates(coordinates[0] + movement[0], coordinates[1] + movement[1]);
        }
        
        checkDestinationReached(agent, 1d);
    }
}
