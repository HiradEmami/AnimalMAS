/*
WORK IN PROGRESS
 */
package animalsimulation.model.bdi;

/**
 *
 * @author Hirad Gorgoroth (The coolest dude in the team) 
 */

import animalsimulation.behavior.base.State;
import animalsimulation.model.knowledge.*;
public class Intention {
    
    private String decision;
    private AgentKnowledge knowledge;
    private State nextAction;
    public Intention(String argdecision,AgentKnowledge argknowledge) {
        this.decision=argdecision;
        this.knowledge=argknowledge;
    }

    public State getNextAction() {
        return nextAction;
    }

    public void setNextAction() {
        switch(decision){
            case "idle":
            {
             //waiting state
                break;
            }
            case "travel":
            {
              //movementstate
                break;
            }
            case "gatherfood":
            {
                //gathering food state
                break;
            }
            case "returnToHive":
            {
             //returntohivestate   
                break;
            }
            case "dropFood":
            {
                //dropfoodstate
                break;
            }
            case "explore":
            {
                //explore state
                break;
            }
        }
    }
    
    public String getDecision() {
        return decision;
    }
    
}
