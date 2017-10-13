/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.knowledge.AIFoodKnowledge;

/**
 *
 * @author Ebombo2
 */
public class AIWorkerBeeExploidMovement extends BaseMovement{

    @Override
    public void initialize(Agent agent, State state)
    {
        if(agent instanceof BeeAgent)
        {
            //AIFoodKnowledge test = ((BeeAgent)agent).getAIKnowledge().getAIFoodKnowledge().get(0);
            double[] coordinates = {700,700};
            targetX = coordinates[0];
            targetY = coordinates[1];
        }
    }
    
    @Override
    public void execute(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        double[] coordinates = bee.getCoordinates();
        
        double distance = bee.distanceToLocation(targetX, targetY);
            double[] movement = {
                (targetX - coordinates[0]) / distance * agent.getSpeed(),
                (targetY - coordinates[1]) / distance * agent.getSpeed()
            };
        agent.setCoordinates(coordinates[0] + movement[0], coordinates[1] + movement[1]);
                
        checkDestinationReached(agent, 1d);
    }
}
