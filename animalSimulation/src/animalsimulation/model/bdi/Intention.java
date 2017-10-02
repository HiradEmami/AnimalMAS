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
    AgentKnowledge knowledge;
    public Intention(String argdecision,AgentKnowledge argknowledge) {
        this.decision=argdecision;
        this.knowledge=argknowledge;
    }

    public String getDecision() {
        return decision;
    }
    
}
