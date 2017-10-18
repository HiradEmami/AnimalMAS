/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.WorkerBeeBehaviorSN;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class SnBeeWorker extends BeeAgent{
    
    public SnBeeWorker(BeeHive hive) {
        super(hive);
        color = new Color(153,153,255);
        stateMachine = new WorkerBeeBehaviorSN(this);
    }
}
