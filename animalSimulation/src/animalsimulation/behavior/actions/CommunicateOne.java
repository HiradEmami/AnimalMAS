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
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.knowledge.Knowledge;

/**
 *
 * @author Ebombo2
 */
public class CommunicateOne extends Action {
    private BeeAgent workerBee;
    
    public void initialize(Agent agent, State state) {
        setTimeOut(50); // Finish after fifty simulation steps.
        
        BeeAgent bee = (BeeAgent) agent;
        WorldObject[] memberBees = bee.getHive().getAffiliatedBees();
                
        for(WorldObject memberBee : memberBees) {
            // Single out an idle worker bee and update its knowledge.
            if(memberBee instanceof BeeAgent) {
                workerBee = (BeeAgent) memberBee;
                if(workerBee.getStateMachine().getCurrentState().getStateName().equals("Idle")) {
                    workerBee.getStateMachine().updateState(new MeetingAgentEvent(this));
                    communicateFood((BeeAgent) agent, workerBee);
                    return;
                }
            }
        }
        
        // If no idle worker bees exist, return to exploration.
        agent.getStateMachine().updateState(new ActionCompletedEvent(this));
    }
    
    @Override
    public void execute(Agent agent, State state) {
        // The worker bee is along for the ride.
        // The state of the worker bee is not updated until the scout decides this action is done.
        if(checkTimeOut(agent, state.getTick())) {
            workerBee.getStateMachine().updateState(new KnowledgeUpdatedEvent(this));
        }
    }
    
    private void communicateFood (BeeAgent argFirst, BeeAgent argSecond){
        BeeFood[] foodSources = argFirst.getKnowledge().getKnownWorldObjectsByClass(BeeFood.class);
        for(WorldObject foodScource : foodSources) {
            Knowledge[] knowledge = argFirst.getKnowledge().getObjectKnowledge(foodScource);
            argSecond.getKnowledge().updateKnowledge(foodScource, knowledge);
        }
    }
}