/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.movement.BeeMovement;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public class BeeBehavior extends StateMachine {

    public BeeBehavior(Agent agent) {
        super(agent);
        // Add state and associated transitions here..
        // General structure:
        // - Create a state and define the action an agent needs to execute while in said state.
        // - Create a state transition definining the target state and which event type triggers the transition
        // - Add the transition to the list of transitions. This links a source state to a transition.

        State exploration = new State("Exploring", new BeeMovement());
        State returnToHive = new State("Returning", new BeeMovement());
        
        addStateTransition(exploration, returnToHive, DestinationReachedEvent.class);
        addStateTransition(returnToHive, exploration, DestinationReachedEvent.class);

        setCurrentState(exploration); //TODO NEEDS TO CHANGE ACCORDING TO STATE??
    }
}
