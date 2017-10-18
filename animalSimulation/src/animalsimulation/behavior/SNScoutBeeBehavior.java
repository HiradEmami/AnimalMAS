/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior;

import animalsimulation.behavior.actions.CommunicateCentral;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.base.StateMachine;
import animalsimulation.behavior.event.ActionCompletedEvent;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.behavior.event.FoodSourceFoundEvent;
import animalsimulation.behavior.movement.BeeReturnMovement;
import animalsimulation.behavior.movement.ScoutBeeExploreMovement;
import animalsimulation.model.base.Agent;

/**
 *
 * @author Ebombo2
 */
public class SNScoutBeeBehavior extends StateMachine{
    
        public SNScoutBeeBehavior(Agent agent) {
        super(agent);
        
        State exploration = new State("Exploring", new ScoutBeeExploreMovement());
        State returnToHive = new State("Returning", new BeeReturnMovement());
        State waggleDance = new State("Waggling", new CommunicateCentral());
                
        addStateTransition(exploration, returnToHive, FoodSourceFoundEvent.class);
        addStateTransition(returnToHive, waggleDance, DestinationReachedEvent.class);
        addStateTransition(waggleDance, exploration, ActionCompletedEvent.class);
     
        setCurrentState(exploration);        
    }
    
}
