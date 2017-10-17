/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.map;

import animalsimulation.model.base.DataRecorder;
import animalsimulation.model.base.SimulationSettings;
import animalsimulation.model.base.World;
import animalsimulation.model.bee.AIBeeScout;
import animalsimulation.model.bee.AIBeeWorker;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.bee.BeeScout;
import animalsimulation.model.bee.BeeWorker;
import java.io.IOException;

/**
 *
 * @author jeroen
 */
public abstract class Map {
    protected static final int WORKER_BEE = 0;
    protected static final int SCOUT_BEE = 1;
    protected static final int AIWORKER_BEE = 2;
    protected static final int AISCOUT_BEE = 3;
    
    protected World world;
    protected DataRecorder recorder;
    protected double knowledgePercentage;
    
    public Map(double AIknowledge) {
        try {
            this.knowledgePercentage=AIknowledge;
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
                case AIWORKER_BEE:
                    bee = new AIBeeWorker(hive,knowledgePercentage);
                    hive.setIdleBees(hive.getIdleBees() + 1);
                    break;
                case AISCOUT_BEE:
                    bee = new AIBeeScout(hive);
                    break;
            }
            bees[i] = bee;
        }
        return bees;
    }
    
    // Abstract methods
    
    public void setKnowledgePercentage(double knowledgePercentage) {
        this.knowledgePercentage = knowledgePercentage;
    }

    public double getKnowledgePercentage() {
        return knowledgePercentage;
    }

    public abstract World createWorld(SimulationSettings settings);
}
