/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.map;

import Jama.Matrix;
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
                    newDriftVector((BeeScout) bee);
                    break;
            }
            bees[i] = bee;
        }
        return bees;
    }

    public void newDriftVector(BeeScout bee)
    {
        double[][] df = {{(Math.random()-0.5)},{(Math.random()-0.5)}};
        Matrix a = new Matrix(df);
        
        double[][] normal = new double[2][1];
        for(int i = 0; i < df.length; i++)
        {
            for(int j = 0; j < df[i].length; j++) {
                normal[i][j] = df[i][j]/a.normF();
            }
        }
        bee.theta = Math.acos(normal[0][0])*toSigned(normal[1][0]);
        bee.tsigma = 3;
        bee.v = 1.5;
    }
    
    private double toSigned(double unsigned) {
        if(unsigned < 0) {
            return -1d;
        } else if(unsigned == 0) {
            return 0d;
        } else {
            return 1d;
        }
    }
    
    // Abstract methods
    
    public abstract World createWorld(SimulationSettings settings);
}
