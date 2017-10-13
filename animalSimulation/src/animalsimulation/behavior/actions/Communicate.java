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
import animalsimulation.model.bee.BeeWorker;

/**
 *
 * @author Hirad Gorgoroth
 */
public class Communicate extends Action {
    private BeeWorker workerBee;
    
    public void initialize(Agent agent, State state) {
        setTimeOut(50); // Finish after fifty simulation steps.
        
        BeeAgent bee = (BeeAgent) agent;
        WorldObject[] memberBees = bee.getHive().getAffiliatedBees();
                
        for(WorldObject memberBee : memberBees) {
            // Single out an idle worker bee and update its knowledge.
            if(memberBee instanceof BeeWorker) {
                workerBee = (BeeWorker) memberBee;
                if(workerBee.getStateMachine().getCurrentState().getStateName().equals("Idle")) {
                    workerBee.getStateMachine().updateState(new MeetingAgentEvent(this));

                    communicateFood((BeeAgent) agent, workerBee);
                    communicateObstacle((BeeAgent) agent, workerBee);
                    
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
        argSecond.getKnowledge().updateFoodKnowledge(argFirst.getKnowledge().getFoodKnowledge());
    }
    
    private void communicateObstacle (BeeAgent argFirst, BeeAgent argSecond){
        argSecond.getKnowledge().updateObstacleKnowledge(argFirst.getKnowledge().getObstacleKnowledge());
    }
}
