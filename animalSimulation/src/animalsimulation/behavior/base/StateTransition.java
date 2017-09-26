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
    private Event transitionEvent;
    private State targetState;
    
    public StateTransition(Event transitionEvent, State targetState) {
        this.transitionEvent = transitionEvent;
        this.targetState = targetState;
    }
    
    public Event getTransitionEvent() {
        return transitionEvent;
    }
    
    public void setTransitionEvent(Event transitionEvent) {
        this.transitionEvent = transitionEvent;
    }
    
    public boolean requires(Event event) {
        return event.equals(transitionEvent);
    }
    
    public State getTargetState() {
        return targetState;
    }
    
    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }
}
