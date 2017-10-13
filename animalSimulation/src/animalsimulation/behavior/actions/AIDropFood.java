/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.AIBeeWorker;

/**
 *
 * @author Ebombo2
 */
public class AIDropFood  extends Action {
    
    @Override
    public void initialize(Agent agent, State state) {
        setTimeOut(100);
        
        AIBeeWorker bee = (AIBeeWorker) agent;
        int gatheredFood = bee.getGatheredFood();
        bee.setGatheredFood(0);
        bee.getHive().addGatheredFood(gatheredFood);
    }
    
    @Override
    public void execute(Agent agent, State state) {
        checkTimeOut(agent, state.getTick());
    }
    
}
