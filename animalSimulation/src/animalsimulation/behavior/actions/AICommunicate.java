/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.event.ActionCompletedEvent;
import animalsimulation.behavior.event.KnowledgeUpdatedEvent;
import animalsimulation.behavior.event.MeetingAgentEvent;
import animalsimulation.model.base.Agent;
import animalsimulation.model.base.WorldObject;
import animalsimulation.model.bee.AIBeeWorker;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.knowledge.Knowledge;
import animalsimulation.model.knowledge.KnowledgeBase;

/**
 *
 * @author Ebombo2
 */
public class AICommunicate extends Action{
    public void initialize(Agent agent, State state) {
        setTimeOut(50); // Finish after fifty simulation steps.
        
        BeeAgent bee = (BeeAgent) agent;
        communicateFood((BeeAgent) agent);
        
        boolean idleBeesFound = false;
        WorldObject[] memberBees = bee.getHive().getAffiliatedBees();
        
        for(WorldObject memberBee : memberBees) {
            if(memberBee instanceof AIBeeWorker) {
                AIBeeWorker workerBee = (AIBeeWorker) memberBee;
                if(workerBee.getStateMachine().getCurrentState().getStateName().equals("Idle")) {
                    workerBee.getStateMachine().updateState(new MeetingAgentEvent(this));
                    idleBeesFound = true;
                }
            }
        }
        
        // If no idle worker bees exist, return to exploration.
        if(!idleBeesFound) {
            agent.getStateMachine().updateState(new ActionCompletedEvent(this));
        }
    }
    
    @Override
    public void execute(Agent agent, State state) {
        // The worker bee is along for the ride.
        // The state of the worker bee is not updated until the scout decides this action is done.
        if(checkTimeOut(agent, state.getTick())) {
            BeeAgent bee = (BeeAgent) agent;
            WorldObject[] memberBees = bee.getHive().getAffiliatedBees();
            
            for(WorldObject memberBee : memberBees) {
                if(memberBee instanceof AIBeeWorker) {
                    AIBeeWorker workerBee = (AIBeeWorker) memberBee;
                    workerBee.getStateMachine().updateState(new KnowledgeUpdatedEvent(this));
                }
            }
        }
    }
    
    private void communicateFood (BeeAgent sender){
        BeeFood[] foodSources = sender.getKnowledge().getKnownWorldObjectsByClass(BeeFood.class);
        for(WorldObject foodScource : foodSources) {
            Knowledge[] knowledge = sender.getKnowledge().getObjectKnowledge(foodScource);
            sender.getHive().getKnowledge().updateKnowledge(foodScource, knowledge);
        }
    }
}
