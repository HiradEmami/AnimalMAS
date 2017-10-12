/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author Ebombo2
 */
public class WorkerBeeExploidMovement extends BaseMovement{
    
    @Override
    public void initialize(Agent agent, State state)
    {
        if(agent instanceof BeeAgent)
        {
            double[] coordinates = ((BeeAgent) agent).newTargetFactor(agent);
            //double[] coordinates = ((BeeAgent)agent).getKnowledge().getFoodKnowledge().get(0).getTargetCoordinates();
            targetX = coordinates[0];
            targetY = coordinates[1];
        }
    }
    
    @Override
    public void execute(Agent agent, State state) {
        BeeAgent bee = (BeeAgent) agent;
        double[] coordinates = bee.getCoordinates();
        
        double b = bee.getD();
        if(b < 0)
            move2(bee, coordinates);
        else
            move(bee, coordinates);
                
        checkDestinationReached(agent, 3d);
    }
    
    private void move(BeeAgent bee, double[] coordinates) {        
        double theta = bee.getTheta() + bee.getTsigma()*(Math.random() - 0.5);
        double dx = bee.getV()*Math.cos(theta);
        double dy = bee.getV()*Math.sin(theta);
        
        bee.setCoordinates(coordinates[0]+dx, coordinates[1]+dy);
    }
    
    private void move2(BeeAgent bee, double[] coordinates) {        
        double dx = 3*(Math.random() - 0.5);
        double dy = 3*(Math.random() - 0.5);
        
        bee.setCoordinates(coordinates[0]+dx, coordinates[1]+dy);
    }
}
