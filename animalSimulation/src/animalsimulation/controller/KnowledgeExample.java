/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;


import animalsimulation.behavior.base.Action;
import animalsimulation.behavior.base.State;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.bee.*;
import animalsimulation.model.knowledge.FoodKnowledge;
import animalsimulation.model.bdi.*;
public class KnowledgeExample {

    public KnowledgeExample() {
        BeeHive h1 = new BeeHive(10,10);
        BeeWorker     b1 =new BeeWorker(h1);
        BeeWorker b2 = new BeeWorker(h1);
        
        printKnowledge(b1);
        printKnowledge(b2);
        Action a =new Action() {
            @Override
            public void execute(Agent agent, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Decision d1 = new Decision(b1.getType(), b1.getKnowledge(), new State("idle", a));
        System.out.println("decision "+d1.getIntention().getDecision());
        
        double []hivelocation = h1.getCoordinates();
        double []randomlocation1 ={20,20};
        double []randomlocation2 ={30,30};
        
        
        System.out.println("Knowledge Size"+b1.getKnowledge().getFoodKnowledge().size());
        FoodKnowledge f1 = new FoodKnowledge(hivelocation, randomlocation1, 0);
        b1.getKnowledge().addnewFoodknowledge(f1);
        System.out.println("B1 Has new Location");
        printKnowledge(b1);
        
        d1 = new Decision(b1.getType(), b1.getKnowledge(), new State("idle", a));
        System.out.println("decision "+d1.getIntention().getDecision());
        
        FoodKnowledge f2 = new FoodKnowledge(hivelocation, randomlocation2, 0);
        b1.getKnowledge().addnewFoodknowledge(f2);
        System.out.println("B1 Has new Location");
        printKnowledge(b1);
        
        
       
        b1.getKnowledge().addnewFoodknowledge(f1);
        System.out.println("B1 Has rep Location");
        printKnowledge(b1);
        System.out.println("Knowledge Size"+b1.getKnowledge().getFoodKnowledge().size());
        
        
        System.out.println("B2 and B1 Communicating");
        communicateFood(b1, b2);
        System.out.println("B2's Knoweledge is updated");
        printKnowledge(b2);
        
        
        
        
    }
    private void printKnowledge(BeeWorker argb){
        System.out.println("Bee Knowledge:");
        for(int i=0;i<=argb.getKnowledge().getFoodKnowledge().size()-1;i++){
            System.out.println("i="+argb.getKnowledge().getFoodKnowledge().get(i));
        }
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
