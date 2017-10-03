/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.event.FoodSourceFoundEvent;
import animalsimulation.behavior.movement.BeeMovement;
import animalsimulation.behavior.movement.BiologicalBeeMovement;
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
        // - Create a state transition definining the source and target states 
        //   and which event type triggers the transition

        State exploration = new State("Exploring", new BiologicalBeeMovement());
        State returnToHive = new State("Returning", new BeeMovement());
        
        addStateTransition(exploration, returnToHive, FoodSourceFoundEvent.class);
        addStateTransition(returnToHive, exploration, DestinationReachedEvent.class);

        setCurrentState(exploration); //TODO NEEDS TO CHANGE ACCORDING TO STATE??
    }
}
