/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.model.base.Agent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jeroen
 */
public abstract class StateMachine {
    protected State currentState;
    protected Agent agent;
    protected HashMap<State, ArrayList<StateTransition>> stateMap;
    
    public StateMachine(Agent agent) {
        stateMap = new HashMap<>();
        this.agent = agent;
    }
    
    public void addStateTransition(State sourceState, State targetState, Class<? extends Event> event) {
        StateTransition transition = new StateTransition(targetState, event);
        if(!stateMap.containsKey(sourceState)) {
            stateMap.put(sourceState, new ArrayList<>());
        }
        stateMap.get(sourceState).add(transition);
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
            currentState.getAction().reset(agent, state);
        }
        currentState = state;
        currentState.getAction().initialize(agent, state);
    }

    /**
     * @return the agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    public void tick() {
        currentState.tick();
    }
}
