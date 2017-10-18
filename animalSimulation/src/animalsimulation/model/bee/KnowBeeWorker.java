/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.WorkerBeeBehaviorKnow;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class KnowBeeWorker extends BeeAgent{
    
    public KnowBeeWorker(BeeHive hive) {
        super(hive);
        color = new Color(255,153,153);
        stateMachine = new WorkerBeeBehaviorKnow(this);
    }
    
}
