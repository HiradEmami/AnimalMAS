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
import animalsimulation.model.knowledge.AIFoodKnowledge;

/**
 *
 * @author Ebombo2
 */
public class AIScoutBeeExploreMovement extends BaseMovement{
    @Override
    public void initialize(Agent agent, State state) {
        targetX = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getWidth());
        targetY = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getHeight());
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
        
        checkDestinationReached(agent, 1d); //TEMPORARY
        checkFoodSourceReached(bee);
        checkOutsideWorld(bee);
    }
    
    private void checkFoodSourceReached(Agent agent) { 
        BeeFood[] foodSources = AnimalSimulation.getSettings().getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        for (BeeFood foodSource : foodSources) {
            if(agent.distanceToObject(foodSource) <= foodSource.getHeight()) {
                agent.getAIKnowledge().addnewFoodknowledge(
                    new AIFoodKnowledge(
                            ((BeeAgent)agent).getHive().getCoordinates(),
                            foodSource.getCoordinates(),
                            -1
                    )
                );
                
                agent.getStateMachine().updateState(new FoodSourceFoundEvent(this));
            }
        }
    }
    
    private void checkOutsideWorld(BeeAgent bee) {
        World world = AnimalSimulation.getSettings().getMap().getWorld();
        
        if(bee.getCoordinates()[0] < 0 || bee.getCoordinates()[1] < 0 ||
                bee.getCoordinates()[0] > world.getWidth() || bee.getCoordinates()[1] > world.getHeight()) {
            bee.setCoordinates(bee.getHive().getCoordinates()[0], bee.getHive().getCoordinates()[1]);
        }
    }
}
