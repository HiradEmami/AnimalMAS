/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.map;

import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.bee.BeeScout;
import animalsimulation.model.bee.BeeWorker;

/**
 *
 * @author jeroen
 */
public abstract class Map {
    protected static final int WORKER_BEE = 0;
    protected static final int SCOUT_BEE = 1;
    
    protected World world;
    
    public World getWorld() {
        return world;
    }
    
    protected BeeAgent[] createBees(int type, int amount, BeeHive hive) {
        BeeAgent[] bees = new BeeAgent[amount];
        for(int i = 0; i < amount; i++) {
            BeeAgent bee = null;
            switch(type) {
                case WORKER_BEE:
                    bee = new BeeWorker(hive);
                    break;
                case SCOUT_BEE:
                    bee = new BeeScout(hive);
                    break;
            }
            bees[i] = bee;
        }
        return bees;
    }
    
    // Abstract methods
    
    public abstract World createWorld(SimulationSettings settings);
}
