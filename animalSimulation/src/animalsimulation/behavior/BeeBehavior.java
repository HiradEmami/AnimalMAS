/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.base.StateTransition;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.movement.BeeMovement;

/**
 *
 * @author jeroen
 */
public class BeeBehavior extends StateMachine {
    
    public BeeBehavior() {
        // Add state and associated transitions here..
        // General structure:
        // - Create a state and define the action an agent needs to execute while in said state.
        // - Create a state transition definining the target state and which event type triggers the transition
        // - Add the transition to the list of transitions. This links a source state to a transition.
        
        State exploration = new State("Exploring", new BeeMovement());
        StateTransition transition = new StateTransition(exploration, DestinationReachedEvent.class);
        addStateTransition(exploration, transition);
        
        currentState = exploration;
    }
    
}
