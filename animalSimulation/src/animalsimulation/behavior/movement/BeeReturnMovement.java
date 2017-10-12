/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.event.HiveReachedEvent;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author jeroen
 */
public class BeeReturnMovement extends BaseMovement {

    @Override
    public void initialize(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        double[] coordinates = bee.getHive().getCoordinates();

        targetX = coordinates[0];
        targetY = coordinates[1];
    }

    @Override
    public void execute(Agent agent, State state) {
        double[] coordinates = agent.getCoordinates();
        double[] movement = new double[2];
        int scale = 3;      
        
        if(Math.abs(coordinates[0] - targetX)<3 && Math.abs(coordinates[1] - targetY)<3)
                agent.setCoordinates(targetX, targetY);
        else{
            double cons = -0.3/Math.sqrt(Math.pow((coordinates[0] - targetX),2) + Math.pow((coordinates[1] - targetY),2));
            movement[0] = cons*scale*(coordinates[0] - targetX);
            movement[1] = cons*scale*(coordinates[1] - targetY);

            agent.setCoordinates(coordinates[0] + movement[0], coordinates[1] + movement[1]);
        }
        checkDestinationReached(agent, 1d);
    }
}
