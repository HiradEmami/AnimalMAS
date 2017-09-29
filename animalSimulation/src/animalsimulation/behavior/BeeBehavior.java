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
        State returnhive = new State("Returning", new BeeMovement());
        StateTransition returntransition = new StateTransition(returnhive, DestinationReachedEvent.class);
        StateTransition exploretransition = new StateTransition(exploration, DestinationReachedEvent.class);
        addStateTransition(exploration, returntransition);
        addStateTransition(returnhive, exploretransition);

        setCurrentState(exploration); //TODO NEEDS TO CHANGE ACCORDING TO STATE??
    }
}
