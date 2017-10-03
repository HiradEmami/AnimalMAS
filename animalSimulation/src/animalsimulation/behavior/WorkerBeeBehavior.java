/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

/**
 *
 * @author Hirad Gorgoroth
 */
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.*;
import animalsimulation.behavior.movement.BeeReturnMovement;
import animalsimulation.behavior.movement.ScoutBeeExploreMovement;
import animalsimulation.model.base.Agent;
import animalsimulation.behavior.actions.*;
import animalsimulation.behavior.movement.WorkerBeeExploidMovement;

public class WorkerBeeBehavior  extends StateMachine {
    
    public WorkerBeeBehavior(Agent agent) {
        super(agent);
        
        
        State idle = new State("Idle", new Idle());
        State gatherFood = new State("GatheringFood", new GatherFood());
        State dropFood = new State("DroppingFood", new DropFood());
        State returnToHive = new State("Returning", new BeeReturnMovement());
        State moveToFoodSource = new State("TravellingToFood", new ScoutBeeExploreMovement());
        State communicate = new State("communicate", new Communicate());
        
        addStateTransition(idle, communicate, MeetingAgentEvent.class);
        addStateTransition(communicate, moveToFoodSource, KnowledgeUpdatedEvent.class);
        addStateTransition(moveToFoodSource, gatherFood, FoodSourceFoundEvent.class);
        addStateTransition(gatherFood, returnToHive, GatheredFoodEvent.class);
        addStateTransition(returnToHive, dropFood, DestinationReachedEvent.class);
        addStateTransition(dropFood, moveToFoodSource, DroppedFoodEvent.class);
        
        setCurrentState(idle); //TODO NEEDS TO CHANGE ACCORDING TO STATE??
    }
    
}
