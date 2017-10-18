/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.ScoutBeeBehaviorOne;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class KnowBeeScout extends BeeAgent{
    
    public KnowBeeScout(BeeHive hive) {
        super(hive);
        color = new Color(180,0,0);
        stateMachine = new ScoutBeeBehaviorOne(this);
        newDriftVector();
    }
    
}
