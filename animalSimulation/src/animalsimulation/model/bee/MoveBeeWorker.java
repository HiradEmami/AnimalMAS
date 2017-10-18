/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.WorkerBeeBehaviorMove;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class MoveBeeWorker extends BeeAgent{
    
    public MoveBeeWorker(BeeHive hive) {
        super(hive);
        color = new Color(153,255,153);
        stateMachine = new WorkerBeeBehaviorMove(this);
        theta = 0;
        v = 1;
    }
    
}
