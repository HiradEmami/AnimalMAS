/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.actions.AIDropFood;
import animalsimulation.behavior.actions.AIGatherFood;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.ActionCompletedEvent;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.event.KnowledgeUpdatedEvent;
import animalsimulation.behavior.event.MeetingAgentEvent;
import animalsimulation.behavior.movement.AIBeeReturnMovement;
import animalsimulation.behavior.movement.AIWorkerBeeExploidMovement;
import animalsimulation.model.base.Agent;

/**
 *
 * @author Ebombo2
 */
public class AIWorkerBeeBehavior extends StateMachine{
    
    public AIWorkerBeeBehavior(Agent agent) {
        super(agent);
        
        State idle = new State("Idle", null);
        State communicate = new State("Communicate", null);
        State moveToFoodSource = new State("TravellingToFood", new AIWorkerBeeExploidMovement());
        State gatherFood = new State("GatheringFood", new AIGatherFood());
        State returnToHive = new State("Returning", new AIBeeReturnMovement());
        State dropFood = new State("DroppingFood", new AIDropFood());
        
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
