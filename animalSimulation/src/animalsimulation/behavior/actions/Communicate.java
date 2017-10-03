/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.event.KnowledgeUpdatedEvent;
import animalsimulation.behavior.event.MeetingAgentEvent;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;
import animalsimulation.model.bee.BeeWorker;

/**
 *
 * @author Hirad Gorgoroth
 */
public class Communicate extends Action{

    @Override
    public void execute(Agent agent, State state) {
        BeeWorker[] workers = AnimalSimulation.getSettings().getMap().getWorld().getWorldObjectsByClass(BeeWorker.class);
        for(BeeWorker worker : workers)
        {
            MeetingAgentEvent meetingAgentEvent = new MeetingAgentEvent(this);
            worker.getStateMachine().updateState(meetingAgentEvent);
            communicateFood((BeeAgent)agent, worker);
            KnowledgeUpdatedEvent knowledgeUpdatedEvent = new KnowledgeUpdatedEvent(this);
            worker.getStateMachine().updateState(knowledgeUpdatedEvent);
        }
        KnowledgeUpdatedEvent knowledgeUpdatedEvent = new KnowledgeUpdatedEvent(this);
        agent.getStateMachine().updateState(knowledgeUpdatedEvent);
    }
    
      private void communicateFood (BeeAgent argFirst, BeeAgent argSecond){
        argFirst.getKnowledge().updateFoodKnowledge(argSecond.getKnowledge().getFoodKnowledge());
        argSecond.getKnowledge().updateFoodKnowledge(argFirst.getKnowledge().getFoodKnowledge());
    }
    private void communicateObstacle (BeeAgent argFirst, BeeAgent argSecond){
        argFirst.getKnowledge().updateObstacleKnowledge(argSecond.getKnowledge().getObstacleKnowledge());
        argSecond.getKnowledge().updateObstacleKnowledge(argFirst.getKnowledge().getObstacleKnowledge());
    }
}
