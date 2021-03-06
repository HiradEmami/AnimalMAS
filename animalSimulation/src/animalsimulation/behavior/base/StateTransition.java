/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

/**
 *
 * @author jeroen
 */
public class StateTransition {
    private State targetState;
    private Class<? extends Event> transitionEvent;
    
    public StateTransition(State targetState, Class<? extends Event> transitionEvent) {
        this.targetState = targetState;
        this.transitionEvent = transitionEvent;
    }
    
    public State getTargetState() {
        return targetState;
    }
    
    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }
    
    public Class<? extends Event> getTransitionEvent() {
        return transitionEvent;
    }
    
    public void setTransitionEvent(Class<? extends Event> transitionEvent) {
        this.transitionEvent = transitionEvent;
    }
    
    public boolean requires(Event event) {
        return event.getClass().equals(transitionEvent);
    }
}
