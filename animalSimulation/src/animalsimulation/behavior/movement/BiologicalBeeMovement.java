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

/**
 *
 * @author Ebombo2
 */
public class BiologicalBeeMovement extends BeeMovement{
        
    @Override
    public void execute(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        
        double[] coordinates = bee.getCoordinates();
        move(bee, coordinates);
        
        checkFoodSourceReached(bee);
        checkOutsideWorld(bee);
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
    
    private void checkOutsideWorld(BeeAgent bee) {
        World world = AnimalSimulation.getSettings().getMap().getWorld();
        
        if(bee.getCoordinates()[0] < 0 || bee.getCoordinates()[1] < 0 ||
                bee.getCoordinates()[0] > world.getWidth() || bee.getCoordinates()[1] > world.getHeight()) {
            bee.setCoordinates(bee.getHive().getCoordinates()[0], bee.getHive().getCoordinates()[1]);
        }
    }
}