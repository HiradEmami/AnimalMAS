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
import animalsimulation.model.knowledge.FoodKnowledge;
import animalsimulation.model.knowledge.Knowledge;
import animalsimulation.model.knowledge.LocationKnowledge;

/**
 *
 * @author Ebombo2
 */
public class AIScoutBeeExploreMovement extends BaseMovement{
    @Override
    public void initialize(Agent agent, State state) {
        double tempx = (Math.random()-0.5);
        double tempy = (Math.random()-0.5);
        double multiplier = (1/Math.sqrt(Math.pow(tempx,2)+Math.pow(tempy,2)));
        targetX = tempx*multiplier*agent.getSpeed();
        targetY = tempy*multiplier*agent.getSpeed();
    }
    
    @Override
    public void execute(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        double[] coordinates = bee.getCoordinates();
        
        agent.setCoordinates(coordinates[0] + targetX, coordinates[1] + targetY);
        
        checkFoodSourceReached(bee);
        checkOutsideWorld(bee, state);
    }
    
    private void checkFoodSourceReached(Agent agent) { 
        BeeFood[] foodSources = AnimalSimulation.getSettings().getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        double[] a = {500,500};
        double[] b = {700,700};
        for (BeeFood foodSource : foodSources) {
            if(agent.distanceToObject(foodSource) <= foodSource.getHeight()) {
                agent.getKnowledge().updateKnowledge(foodSource,
                        new Knowledge[] {
                            new LocationKnowledge(foodSource.getCoordinates()),
                            new FoodKnowledge(-1)
                        });
                agent.getStateMachine().updateState(new FoodSourceFoundEvent(this));
            }
        }
    }
    
    private void checkOutsideWorld(BeeAgent bee, State state) {
        World world = AnimalSimulation.getSettings().getMap().getWorld();
        
        if(bee.getCoordinates()[0] < 0 || bee.getCoordinates()[1] < 0 ||
                bee.getCoordinates()[0] > world.getWidth() || bee.getCoordinates()[1] > world.getHeight()) {
            initialize(bee, state);
            bee.setCoordinates(bee.getHive().getCoordinates()[0], bee.getHive().getCoordinates()[1]);
        }
    }
}
