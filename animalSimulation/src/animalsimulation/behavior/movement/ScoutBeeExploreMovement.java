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
import animalsimulation.model.bee.BioBeeScout;
import animalsimulation.model.bee.BioBeeWorker;
import animalsimulation.model.bee.KnowBeeScout;
import animalsimulation.model.bee.KnowBeeWorker;
import animalsimulation.model.bee.MoveBeeScout;
import animalsimulation.model.bee.MoveBeeWorker;
import animalsimulation.model.bee.SnBeeScout;
import animalsimulation.model.bee.SnBeeWorker;
import animalsimulation.model.knowledge.FoodKnowledge;
import animalsimulation.model.knowledge.Knowledge;
import animalsimulation.model.knowledge.LocationKnowledge;

/**
 *
 * @author Ebombo2
 */
public class ScoutBeeExploreMovement extends BaseMovement{
    
    @Override
    public void initialize(Agent agent, State state) {
        if(agent instanceof BeeAgent)
            ((BeeAgent) agent).newDriftVector();
    }
    
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
        BeeFood[] foodSources = null;
        
        if(agent instanceof BioBeeScout)
        {
            foodSources = AnimalSimulation.getSettings()[0].getMap().getWorld().getWorldObjectsByClass(BeeFood.class);  
        }
        if(agent instanceof KnowBeeScout)
        {
            foodSources = AnimalSimulation.getSettings()[1].getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        }
        if(agent instanceof MoveBeeScout)
        {
            foodSources = AnimalSimulation.getSettings()[2].getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        }
        if(agent instanceof SnBeeScout)
        {
            foodSources = AnimalSimulation.getSettings()[3].getMap().getWorld().getWorldObjectsByClass(BeeFood.class);
        }
        
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
    
    private void checkOutsideWorld(BeeAgent bee) {
        World world = null;
        
        if(bee instanceof BioBeeScout)
        {
            world = AnimalSimulation.getSettings()[0].getMap().getWorld();    
        }
        if(bee instanceof KnowBeeScout)
        {
            world = AnimalSimulation.getSettings()[1].getMap().getWorld();    
        }
        if(bee instanceof MoveBeeScout)
        {
            world = AnimalSimulation.getSettings()[2].getMap().getWorld();    
        }
        if(bee instanceof SnBeeScout)
        {
            world = AnimalSimulation.getSettings()[3].getMap().getWorld();    
        }
        
        if(bee.getCoordinates()[0] < 0 || bee.getCoordinates()[1] < 0 ||
                bee.getCoordinates()[0] > world.getWidth() || bee.getCoordinates()[1] > world.getHeight()) {
            bee.setCoordinates(bee.getHive().getCoordinates()[0], bee.getHive().getCoordinates()[1]);
        }
    }
}