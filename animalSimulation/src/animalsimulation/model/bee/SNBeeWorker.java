/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.SNWorkerBeeBehavior;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class SNBeeWorker extends BeeAgent{
    public SNBeeWorker(BeeHive hive) {
        super(hive);
        color = Color.RED;
        shape = Shape.CIRCLE;
        width = 10;
        height = 10;
        stateMachine = new SNWorkerBeeBehavior(this);
    }
}
