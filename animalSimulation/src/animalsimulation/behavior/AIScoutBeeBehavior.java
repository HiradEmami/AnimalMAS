/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.actions.AICommunicate;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.ActionCompletedEvent;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.event.FoodSourceFoundEvent;
import animalsimulation.behavior.movement.AIBeeReturnMovement;
import animalsimulation.behavior.movement.AIScoutBeeExploreMovement;
import animalsimulation.model.base.Agent;

/**
 *
 * @author Ebombo2
 */
public class AIScoutBeeBehavior extends StateMachine{
    
        public AIScoutBeeBehavior(Agent agent) {
        super(agent);
        
        State exploration = new State("Exploring", new AIScoutBeeExploreMovement());
        State returnToHive = new State("Returning", new AIBeeReturnMovement());
        State waggleDance = new State("Waggling", new AICommunicate());
                
        addStateTransition(exploration, returnToHive, FoodSourceFoundEvent.class);
        addStateTransition(exploration, returnToHive, DestinationReachedEvent.class); //TEMPORARY
        addStateTransition(returnToHive, waggleDance, DestinationReachedEvent.class);
        addStateTransition(waggleDance, exploration, ActionCompletedEvent.class);
     
        setCurrentState(exploration);        
    }
    
}
