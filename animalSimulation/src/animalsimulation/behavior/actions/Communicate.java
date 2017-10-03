/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.actions;

import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;

/**
 *
 * @author Hirad Gorgoroth
 */
public class Communicate extends Action{

    @Override
    public void execute(Agent agent, State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
