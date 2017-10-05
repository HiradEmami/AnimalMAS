/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.model.base.Agent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author jeroen
 */
public abstract class StateMachine {
    protected State currentState;
    protected Agent agent;
    protected HashMap<State, ArrayList<StateTransition>> stateMap;
    private final Random random;
    
    public StateMachine(Agent agent) {
        this.agent = agent;
        stateMap = new HashMap<>();
        random = new Random();
    }
    
    public void addStateTransition(State sourceState, State targetState, Class<? extends Event> event) {
        addStateTransition(sourceState, targetState, event, 1d);
    }
    
    public void addStateTransition(State sourceState, State targetState, Class<? extends Event> event,
        double transitionProbability) {
        
        StateTransition transition = new StateTransition(targetState, event, transitionProbability);
        if(!stateMap.containsKey(sourceState)) {
            stateMap.put(sourceState, new ArrayList<>());
        }
        stateMap.get(sourceState).add(transition);
    }
    
    public void updateState(Event event) {
        double randomValue = random.nextDouble();
        for(StateTransition transition : stateMap.get(currentState)) {
            if(transition.requires(event) && randomValue <= transition.getTransitionProbability()) {
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
            currentState.reset(agent);
        }
        currentState = state;
        currentState.initialize(agent);
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
