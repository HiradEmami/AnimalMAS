/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.map;

import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;
import animalsimulation.model.base.WorldObject;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.bee.BeeHive;

/**
 *
 * @author jeroen
 */
public class SingleHiveMap extends Map {    
    @Override
    public World createWorld(SimulationSettings settings) {
        world = new World(1000, 1000);
        
        // Adds bee hive
        BeeHive hive = new BeeHive(world.getWidth()/2, world.getHeight()/2);
        world.addObject(hive);
        
        // Adds worker bees to hive
        BeeAgent[] workerBees = createBees(Map.WORKER_BEE, settings.getNumberOfWorkerBees(), hive);
        world.addObjects((WorldObject[]) workerBees);
        
        // Adds scout bees to hive
        BeeAgent[] scoutBees = createBees(Map.SCOUT_BEE, settings.getNumberOfScoutBees(), hive);
        world.addObjects((WorldObject[]) scoutBees);
        
        // Adds food sources in a circle around the hive
        int radius = 400;
        for(int i = 0; i < settings.getNumberOfFoodSources(); i++) {
            try{
                BeeFood food = new BeeFood(
                Math.round((float) (hive.getCoordinates()[0] + radius * Math.cos(2 * Math.PI / settings.getNumberOfFoodSources() * i))),
                Math.round((float) (hive.getCoordinates()[1] + radius * Math.sin(2 * Math.PI / settings.getNumberOfFoodSources() * i)))
            );
            world.addObject(food);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return world;
    }
}
