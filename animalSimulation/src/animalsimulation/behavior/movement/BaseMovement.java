/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.event.DestinationReachedEvent;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public abstract class BaseMovement extends Action {
    protected double targetX, targetY;
    
    public double[] getTargetCoordinates() {
        return new double[] {targetX, targetY};
    }
    
    public void setTargetCoordinates(double targetX, double targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }
        
    protected void checkDestinationReached(Agent agent) {
        if(agent.getCoordinates()[0] == targetX && agent.getCoordinates()[1] == targetY) {
            DestinationReachedEvent destinationReachedEvent = new DestinationReachedEvent(this);
            agent.getStateMachine().updateState(destinationReachedEvent);
        }
    }
}
