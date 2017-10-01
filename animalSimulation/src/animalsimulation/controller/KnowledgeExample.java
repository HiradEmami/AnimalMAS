/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;


import animalsimulation.model.bee.BeeHive;
import animalsimulation.model.bee.*;
import animalsimulation.model.knowledge.FoodKnowledge;
public class KnowledgeExample {

    public KnowledgeExample() {
        BeeHive h1 = new BeeHive(10,10);
        BeeScout b1 =new BeeScout(h1);
        BeeScout b2 = new BeeScout(h1);
        
        printKnowledge(b1);
        printKnowledge(b2);
        
        int []hivelocation = {h1.getHeight(),h1.getWidth()};
        int []randomlocation1 ={20,20};
        int []randomlocation2 ={30,30};
        
        FoodKnowledge f1 = new FoodKnowledge(hivelocation, randomlocation1, 0);
        b1.getKnowledge().addnewFoodknowledge(f1);
        System.out.println("B1 Has new Location");
        printKnowledge(b1);
        
        FoodKnowledge f2 = new FoodKnowledge(hivelocation, randomlocation2, 0);
        b1.getKnowledge().addnewFoodknowledge(f2);
        System.out.println("B1 Has new Location");
        printKnowledge(b1);
        
        
       
        b1.getKnowledge().addnewFoodknowledge(f1);
        System.out.println("B1 Has rep Location");
        printKnowledge(b1);
        
        
        System.out.println("B2 and B1 Communicating");
        b2.getKnowledge().updateFoodKnowledge(b1.getKnowledge().getFoodKnowledge());
        System.out.println("B2's Knoweledge is updated");
        printKnowledge(b2);
        
        
        
        
    }
    private void printKnowledge(BeeScout argb){
        System.out.println("Bee Knowledge:");
        for(int i=0;i<=argb.getKnowledge().getFoodKnowledge().size()-1;i++){
            System.out.println("i="+argb.getKnowledge().getFoodKnowledge().get(i));
        }
    }
    
}
