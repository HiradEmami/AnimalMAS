/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.map;

import animalsimulation.model.base.DataRecorder;
import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.bee.BeeScout;
import animalsimulation.model.bee.BeeWorker;
import animalsimulation.model.bee.KnowBeeScout;
import animalsimulation.model.bee.KnowBeeWorker;
import animalsimulation.model.bee.MoveBeeScout;
import animalsimulation.model.bee.MoveBeeWorker;
import animalsimulation.model.bee.SNBeeScout;
import animalsimulation.model.bee.SNBeeWorker;
import java.io.IOException;

/**
 *
 * @author jeroen
 */
public abstract class Map {
    protected static final int WORKER_BEE = 0;
    protected static final int SCOUT_BEE = 1;
    protected static final int KNOWWORKER_BEE = 2;
    protected static final int KNOWSCOUT_BEE = 3;
    protected static final int MOVEWORKER_BEE = 4;
    protected static final int MOVESCOUT_BEE = 5;
    protected static final int SNWORKER_BEE = 6;
    protected static final int SNSCOUT_BEE = 7;
    
    protected World world;
    protected DataRecorder recorder;
    
    public Map() {
        try {
            recorder = new DataRecorder();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public World getWorld() {
        return world;
    }
    
    public DataRecorder getDataRecorder() {
        return recorder;
    }
    
    protected BeeAgent[] createBees(int type, int amount, BeeHive hive) {
        BeeAgent[] bees = new BeeAgent[amount];
        for(int i = 0; i < amount; i++) {
            BeeAgent bee = null;
            switch(type) {
                case WORKER_BEE:
                    bee = new BeeWorker(hive);
                    hive.setIdleBees(hive.getIdleBees() + 1);
                    break;
                case SCOUT_BEE:
                    bee = new BeeScout(hive);
                    break;
                case KNOWWORKER_BEE:
                    bee = new KnowBeeWorker(hive);
                    hive.setIdleBees(hive.getIdleBees() + 1);
                    break;
                case KNOWSCOUT_BEE:
                    bee = new KnowBeeScout(hive);
                    break;
                case MOVEWORKER_BEE:
                    bee = new MoveBeeWorker(hive);
                    hive.setIdleBees(hive.getIdleBees() + 1);
                    break;
                case MOVESCOUT_BEE:
                    bee = new MoveBeeScout(hive);
                    break;
                case SNWORKER_BEE:
                    bee = new SNBeeWorker(hive);
                    hive.setIdleBees(hive.getIdleBees() + 1);
                    break;
                case SNSCOUT_BEE:
                    bee = new SNBeeScout(hive);
                    break;
            }
            bees[i] = bee;
        }
        return bees;
    }
    
    // Abstract methods
    
    public abstract World createWorld(SimulationSettings settings);
}
