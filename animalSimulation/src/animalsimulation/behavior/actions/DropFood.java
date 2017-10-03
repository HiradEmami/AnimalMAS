/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

/**
 *
 * @author Hirad Gorgoroth
 */
import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;

public class DropFood  extends Action {
    
    @Override
    public void initialize(Agent agent, State state) {
        setTimeOut(3);
    }
    
    @Override
    public void execute(Agent agent, State state) {
        checkTimeOut(agent, state.getTick());
    }
    
}