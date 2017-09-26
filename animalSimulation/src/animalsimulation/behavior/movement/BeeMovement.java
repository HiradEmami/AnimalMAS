/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public class BeeMovement extends BaseMovement {

    public void execute(Agent agent, State state) {
        // something something cos...
        // something something sin...
        int[] coordinates = agent.getCoordinates();
        agent.setCoordinates(coordinates[0] + 1, coordinates[1] + 1);
        
        super.execute(agent, state);
    }
    
}
