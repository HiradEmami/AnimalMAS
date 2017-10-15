/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.AIScoutBeeBehavior;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class AIBeeScout extends BeeAgent{
    public AIBeeScout(BeeHive hive) {
        super(hive);
        color = Color.ORANGE;
        shape = Shape.CIRCLE;
        width = 10;
        height = 10;
        stateMachine = new AIScoutBeeBehavior(this);
    }
}
