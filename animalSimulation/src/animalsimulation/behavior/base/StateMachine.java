/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jeroen
 */
public abstract class StateMachine {
    protected State currentState;
    protected HashMap<State, ArrayList<StateTransition>> stateMap;
    
    public StateMachine() {
        stateMap = new HashMap<>();
    }
    
    public void addStateTransition(State state, StateTransition transition) {
        if(!stateMap.containsKey(state)) {
            stateMap.put(state, new ArrayList<>());
        }
        stateMap.get(state).add(transition);
    }
    
    public void updateState(Event event) {
        for(StateTransition transition : stateMap.get(currentState)) {
            if(transition.requires(event)) {
                event.beforeStateChange();
                setCurrentState(transition.getTargetState());
                event.afterStateChange();
                break;
            }
        }
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public void setCurrentState(State state) {
        if(currentState != null) {
            currentState.reset();
            if(currentState.getStateName() == "Exploring")
                currentState.getAction().reset();
        }
        currentState = state;
        //currentState.getAction().initialize();
        currentState.getAction();
    }
    
    public void tick() {
        currentState.tick();
    }
}
