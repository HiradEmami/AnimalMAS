/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public class State {
    private String stateName;
    private Action action;
    private int tick; // signifies how many steps the state machine is in this state.
    
    public State(String stateName, Action action) {
        this.stateName = stateName;
        this.action = action;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public Action getAction() {
        return action;
    }
    
    public void setAction(Action action) {
        this.action = action;
    }
    
    public void act(Agent agent) {
        if(action != null) {
            action.execute(agent, this);
        }
    }
     
    public int getTick() {
        return tick;
    }
    
    public void tick() {
        tick++;
    }
    
    public void initialize(Agent agent) {
        if(action != null) {
            action.initialize(agent, this);
        }
    }
    
    public void reset(Agent agent) {
        tick = 0;
        if(action != null) {
            action.reset(agent, this);
        }
    }
}
