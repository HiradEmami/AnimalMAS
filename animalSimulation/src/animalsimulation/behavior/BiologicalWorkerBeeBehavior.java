/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.actions.*;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.*;
import animalsimulation.behavior.movement.BeeReturnMovement;
import animalsimulation.behavior.movement.WaggleWorkerBeeExploitMovement;
import animalsimulation.model.base.Agent;

/**
 *
 * @author Ebombo2
 */
public class BiologicalWorkerBeeBehavior  extends StateMachine {
    
    public BiologicalWorkerBeeBehavior(Agent agent) {
        super(agent);
        
        State idle = new State("Idle",  new UpdateHiveStatistics());
        State communicate = new State("Communicate",  new UpdateHiveStatistics());
        State moveToFoodSource = new State("TravellingToFood", new WaggleWorkerBeeExploitMovement());
        State gatherFood = new State("GatheringFood", new GatherFood());
        State returnToHive = new State("Returning", new BeeReturnMovement());
        State dropFood = new State("DroppingFood", new DropFood());
        
        addStateTransition(idle, communicate, MeetingAgentEvent.class);
        addStateTransition(communicate, moveToFoodSource, KnowledgeUpdatedEvent.class);
        addStateTransition(moveToFoodSource, gatherFood, DestinationReachedEvent.class);
        addStateTransition(gatherFood, returnToHive, ActionCompletedEvent.class);
        addStateTransition(returnToHive, dropFood, DestinationReachedEvent.class);
        
        /** 
         * !!! Transition probabilities do not add up to 100% !!!
         * probabailities are evaluated individually. E.g.:
         * 
         * the dropFood => moveToFoodSource state transition has a 60% chance of happening
         * if the transition doesn't happen then
         * the dropFood => idle state transition should always fire (i.e. 100% chance)
         */
        addStateTransition(dropFood, moveToFoodSource, ActionCompletedEvent.class, 0.6d);
        addStateTransition(dropFood, idle, ActionCompletedEvent.class, 1d);
        
        setCurrentState(idle);
    }
    
}
