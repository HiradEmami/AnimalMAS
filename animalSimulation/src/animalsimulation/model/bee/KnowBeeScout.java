/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.SNScoutBeeBehavior;
import animalsimulation.model.base.WorldObject;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class KnowBeeScout extends BeeAgent{
        public KnowBeeScout(BeeHive hive) {
        super(hive);
        color = Color.ORANGE;
        shape = WorldObject.Shape.CIRCLE;
        width = 10;
        height = 10;
        stateMachine = new SNScoutBeeBehavior(this);
    }
}
