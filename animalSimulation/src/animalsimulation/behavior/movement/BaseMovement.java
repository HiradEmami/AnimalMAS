/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public abstract class BaseMovement implements Action {
    protected int targetX, targetY;
    
    public int[] getTargetCoordinates() {
        return new int[] {targetX, targetY};
    }
    
    public void setTargetCoordinates(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }
    
    public void execute(Agent agent, State state) {
        if(agent.getCoordinates()[0] == targetX && agent.getCoordinates()[1] == targetY) {
            DestinationReachedEvent destinationReachedEvent = new DestinationReachedEvent(this);
            agent.getStateMachine().updateState(destinationReachedEvent);
        }
    }
}
