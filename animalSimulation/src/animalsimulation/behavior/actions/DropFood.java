/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author Ebombo2
 */
public class DropFood extends Action {
    
    @Override
    public void initialize(Agent agent, State state) {
        setTimeOut(100);
        
        BeeAgent bee = (BeeAgent) agent;
        int gatheredFood = bee.getGatheredFood();
        bee.setGatheredFood(0);
        bee.getHive().addGatheredFood(gatheredFood);
    }
    
    @Override
    public void execute(Agent agent, State state) {
        checkTimeOut(agent, state.getTick());
    }
    
}
