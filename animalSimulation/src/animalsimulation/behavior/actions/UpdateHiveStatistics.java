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
 * @author jeroen
 */
public class UpdateHiveStatistics extends Action {
    
    @Override
    public void initialize(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        if(state.getStateName().equals("Idle")) {
            bee.getHive().decrementActiveBees();
        } else {
            bee.getHive().incrementActiveBees();
        }
    }
    
    @Override
    public void execute(Agent agent, State state) {}
    
}
