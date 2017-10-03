/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.behavior.event.FoodSourceFoundEvent;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.knowledge.LocationKnowledge;

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
            int[] coordinates = ((BeeAgent)agent).getKnowledge().getFoodKnowledge().get(0).getTargetCoordinates();
            targetX = coordinates[0];
            targetY = coordinates[1];
        }
    }
    
//    @Override
//    public void execute(Agent agent, State state) {
//        BeeAgent bee = (BeeAgent) agent;
//        
//        double[] coordinates = bee.getCoordinates();
//        move(bee, coordinates);
//        
//        checkFoodSourceReached(bee);
//    }
    
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
        checkFoodSourceReached(agent);
    }
    
    private void move(BeeAgent bee, double[] coordinates) {        
        double theta = bee.getTheta() + bee.getTsigma()*(Math.random() - 0.5);
        double dx = bee.getV()*Math.cos(theta);
        double dy = bee.getV()*Math.sin(theta);
        
        bee.setCoordinates(coordinates[0]+dx, coordinates[1]+dy);
    }
    
    private void checkFoodSourceReached(Agent agent) { 
        BeeFood[] foodSources = AnimalSimulation.getSettings().getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        for (BeeFood foodSource : foodSources) {
            if(agent.distanceToObject(foodSource) <= foodSource.getHeight()) {
                FoodSourceFoundEvent foodSourceFoundEvent = new FoodSourceFoundEvent(this);
                agent.getStateMachine().updateState(foodSourceFoundEvent);
            }
        }
    }
}
