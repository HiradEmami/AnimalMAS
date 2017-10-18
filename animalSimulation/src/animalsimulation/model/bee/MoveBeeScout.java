/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.SNScoutBeeBehavior;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class MoveBeeScout extends BeeAgent{
    public MoveBeeScout(BeeHive hive) {
        super(hive);
        color = Color.ORANGE;
        shape = Shape.CIRCLE;
        width = 10;
        height = 10;
        stateMachine = new SNScoutBeeBehavior(this);
    }
}
