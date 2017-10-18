/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.WorkerBeeBehaviorBiological;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BioBeeWorker extends BeeAgent {
    
    public BioBeeWorker(BeeHive hive) {
        super(hive);
        color = new Color(100,100,100);
        stateMachine = new WorkerBeeBehaviorBiological(this);
        theta = 0;
        v = 1;
    }
    
}
