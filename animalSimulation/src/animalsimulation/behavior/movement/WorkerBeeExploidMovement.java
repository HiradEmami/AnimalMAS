/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author Ebombo2
 */
public class WorkerBeeExploidMovement extends BaseMovement{
    
    @Override
    public void initialize(Agent agent, State state)
    {
        if(agent instanceof BeeAgent)
        {
            double[] coordinates = ((BeeAgent)agent).getKnowledge().getFoodKnowledge().get(0).getTargetCoordinates();
            targetX = coordinates[0];
            targetY = coordinates[1];
        }
    }
    
    @Override
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
