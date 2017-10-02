/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bdi;

/**
 *
 * @author Hirad Gorgoroth
 * 
 * State List:
 * 1) idle = waiting (not doing anything)
 */

import animalsimulation.behavior.base.State;
import animalsimulation.model.knowledge.*;
import animalsimulation.model.bee.*;

public class Decision {
    AgentKnowledge knowledge;
    State previousState;
    Intention intention;
    
    public Decision(String argType, AgentKnowledge argKnowledge, State argPreviousState){
        this.knowledge=argKnowledge;
        this.previousState=argPreviousState;
        if(argType.equals("Scout")){
            decideScout();
        }else{
            decideWorker();
        }
        
    }
    
    private void decideScout(){
        if(knowledge.getFoodKnowledge().size() ==0){
            
             intention = new Intention("explore",knowledge);
        }else{
            switch (previousState.getStateName()){
                case "explore":{
                    break;
                }
            }
        }
        
        
    }
    
    private void decideWorker(){
        if(knowledge.getFoodKnowledge().size() ==0){
            intention = new Intention("idle",knowledge);
        }else{
            switch(previousState.getStateName()){
                case "idle":
                {
                    intention = new Intention("travel", knowledge);
                    break;
                }
                case "travel":
                {
                    intention = new Intention("gatherfood", knowledge);
                    break;
                }
                case "gatherfood":
                {
                    intention= new Intention("returnToHive", knowledge);
                    break;
                }
                case "returnToHive":
                {
                    intention =new Intention("dropFood", knowledge);
                    break;
                }
                default:{
                    intention=new Intention("idle", knowledge);
                    break;
                }
            }
        }
        
    }

    public Intention getIntention() {
        return intention;
    }
    
    
}
