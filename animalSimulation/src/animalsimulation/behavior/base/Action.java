/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.behavior.event.ActionCompletedEvent;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public abstract class Action {
    int ticks;
    public void initialize(Agent agent, State state) {};
    public abstract void execute(Agent agent, State state);
    public void reset(Agent agent, State state) {};
    public void setTimeOut(int ticks){ this.ticks=ticks;};
    public void checkTimeOut(Agent agent, int ticks){
    if(this.ticks ==ticks){
        agent.getStateMachine().updateState(new ActionCompletedEvent(ticks));
    }
    };
}
