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

public class ScoutBeeBehavior extends StateMachine{
    
    public ScoutBeeBehavior(Agent agent) {
        super(agent);
        
        State exploration = new State("Exploring", new ScoutBeeExploreMovement());
        State returnToHive = new State("Returning", new BeeReturnMovement());
        State waggleDance = new State("Waggling", new Communicate());
        
        setCurrentState(exploration); //TODO NEEDS TO CHANGE ACCORDING TO STATE??
        
        addStateTransition(exploration, returnToHive, FoodSourceFoundEvent.class);
        addStateTransition(returnToHive, waggleDance, HiveReachedEvent.class);
        addStateTransition(waggleDance, exploration, KnowledgeUpdatedEvent.class);
        
    }
    
}
