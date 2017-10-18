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
        BeeHive hive = new BeeHive("Natural Hive", world.getWidth()/2, world.getHeight()/2);
        world.addObject(hive);
        
        //Adds Knowbee hive
        BeeHive knowHive = new BeeHive("Knowledge Hive", world.getWidth()/2, world.getHeight()/2);
        world.addObject(knowHive);
        
        //Adds Movebee hive
        BeeHive moveHive = new BeeHive("Move Hive", world.getWidth()/2, world.getHeight()/2);
        world.addObject(moveHive);
        
        //Adds Snbee hive
        BeeHive snHive = new BeeHive("Supernatural Hive", world.getWidth()/2, world.getHeight()/2);
        world.addObject(snHive);
                
        // Adds food sources in a circle around the hive
        int radius = 300;
        for(int i = 0; i < settings.getNumberOfFoodSources(); i++) {
            BeeFood food = new BeeFood(
                Math.round((float) (hive.getCoordinates()[0] + radius * Math.cos(2 * Math.PI / settings.getNumberOfFoodSources() * i))),
                Math.round((float) (hive.getCoordinates()[1] + radius * Math.sin(2 * Math.PI / settings.getNumberOfFoodSources() * i)))
            );
            world.addObject(food);
        }
        
        // Adds worker bees to hive
        BeeAgent[] workerBees = createBees(Map.WORKER_BEE, settings.getNumberOfBioWorkerBees(), hive);
        world.addObjects((WorldObject[]) workerBees);
        
        // Adds scout bees to hive
        BeeAgent[] scoutBees = createBees(Map.SCOUT_BEE, settings.getNumberOfBioScoutBees(), hive);
        world.addObjects((WorldObject[]) scoutBees);
        
        // Adds AIworker bees to hive
        BeeAgent[] knowWorkerBees = createBees(Map.KNOWWORKER_BEE, settings.getNumberOfKnowWorkerBees(), knowHive);
        world.addObjects((WorldObject[]) knowWorkerBees);
        
        // Adds AIscout bees to hive
        BeeAgent[] knowScoutBees = createBees(Map.KNOWSCOUT_BEE, settings.getNumberOfKnowScoutBees(), knowHive);
        world.addObjects((WorldObject[]) knowScoutBees);
        
        // Adds AIworker bees to hive
        BeeAgent[] moveWorkerBees = createBees(Map.MOVEWORKER_BEE, settings.getNumberOfMoveWorkerBees(), moveHive);
        world.addObjects((WorldObject[]) moveWorkerBees);
        
        // Adds AIscout bees to hive
        BeeAgent[] moveScoutBees = createBees(Map.MOVESCOUT_BEE, settings.getNumberOfMoveScoutBees(), moveHive);
        world.addObjects((WorldObject[]) moveScoutBees);
        
        // Adds AIworker bees to hive
        BeeAgent[] snWorkerBees = createBees(Map.SNWORKER_BEE, settings.getNumberOfSnWorkerBees(), snHive);
        world.addObjects((WorldObject[]) snWorkerBees);
        
        // Adds AIscout bees to hive
        BeeAgent[] snScoutBees = createBees(Map.SNSCOUT_BEE, settings.getNumberOfSnScoutBees(), snHive);
        world.addObjects((WorldObject[]) snScoutBees);
        
        // Register data sources for data collection
        recorder.addDataSource(hive);
        recorder.addDataSource(knowHive);
        recorder.addDataSource(moveHive);
        recorder.addDataSource(snHive);
        
        return world;
    }
}
