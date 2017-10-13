/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.behavior.AIWorkerBeeBehavior;
import animalsimulation.model.base.WorldObject;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class AIBeeWorker extends BeeAgent{
    private int gatheredFood;
    
    public AIBeeWorker(BeeHive hive) {
        super(hive);
        color = Color.RED;
        shape = WorldObject.Shape.CIRCLE;
        width = 10;
        height = 10;
        stateMachine = new AIWorkerBeeBehavior(this);
    }
        
    public int getGatheredFood() {
        return gatheredFood;
    }
    
    public void setGatheredFood(int gatheredFood) {
        this.gatheredFood = gatheredFood;
    }
}
