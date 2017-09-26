/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.model.base.BaseModel;

/**
 *
 * @author jeroen
 */
public class State {
    private String stateName;
    private Action action;
    private int tick; // signifies how many steps the state machine is in this state.
    
    public State(String stateName, Action action) {
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
    
    public void act(BaseModel model) {
        if(action != null) {
            action.execute(model);
        }
    }
    
    // Override the tick method to auto generate an event after N simulation steps.
    public void tick() {
        tick++;
    }
    
    public void resetTick() {
        tick = 0;
    }
}
