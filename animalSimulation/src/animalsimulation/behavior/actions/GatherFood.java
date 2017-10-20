/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BioBeeWorker;
import animalsimulation.model.bee.KnowBeeWorker;
import animalsimulation.model.bee.MoveBeeWorker;
import animalsimulation.model.bee.SnBeeWorker;

/**
 *
 * @author Ebombo2
 */
public class GatherFood extends Action {
    private BeeFood foodSource;
    
    @Override
    public void initialize(Agent agent, State state) {
        setTimeOut(100);
        World world = null;
        
        if(agent instanceof BioBeeWorker)
        {
            world = AnimalSimulation.getSettings()[0].getMap().getWorld();    
        }
        if(agent instanceof KnowBeeWorker)
        {
            world = AnimalSimulation.getSettings()[1].getMap().getWorld();    
        }
        if(agent instanceof MoveBeeWorker)
        {
            world = AnimalSimulation.getSettings()[2].getMap().getWorld();    
        }
        if(agent instanceof SnBeeWorker)
        {
            world = AnimalSimulation.getSettings()[3].getMap().getWorld();    
        }
        
        for(BeeFood foodSource : world.getWorldObjectsByClass(BeeFood.class)) {
            if(agent.distanceToObject(foodSource) <= foodSource.getHeight()) {
                this.foodSource = foodSource;
                break;
            }
        }
        
        BeeAgent bee = (BeeAgent) agent;
        bee.setGatheredFood(foodSource.getQualityFoodYield());
    }
    
    @Override
    public void execute(Agent agent, State state) {
        checkTimeOut(agent, state.getTick());
    }
    
}
