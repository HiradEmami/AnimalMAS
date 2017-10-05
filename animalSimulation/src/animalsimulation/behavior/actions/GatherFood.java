/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

/**
 *
 * @author Hirad Gorgoroth
 */
import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.bee.BeeWorker;

public class GatherFood extends Action {
    private BeeFood foodSource;
    
    @Override
    public void initialize(Agent agent, State state) {
        setTimeOut(100);
        
        World world = AnimalSimulation.getSettings().getMap().getWorld();
        for(BeeFood foodSource : world.getWorldObjectsByClass(BeeFood.class)) {
            if(agent.distanceToObject(foodSource) <= foodSource.getHeight()) {
                this.foodSource = foodSource;
                break;
            }
        }
        
        BeeWorker bee = (BeeWorker) agent;
        bee.setGatheredFood(foodSource.getQualityFoodYield());
    }
    
    @Override
    public void execute(Agent agent, State state) {
        checkTimeOut(agent, state.getTick());
    }
    
}
