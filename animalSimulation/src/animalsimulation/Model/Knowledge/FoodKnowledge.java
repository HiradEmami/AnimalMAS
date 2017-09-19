/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.Model.Knowledge;

import animalsimulation.Model.Location;

/**
 *
 * @author Hirad Gorgoroth
 */
public class FoodKnowledge extends LocationKnowledge{
   
    private int foodStorage;
    
    public FoodKnowledge(Location argHiveLocation, Location argTargetLocation, int argFoodStorage) {
        super(argHiveLocation, argTargetLocation);
        this.foodStorage=argFoodStorage;
        
    }

    public int getFoodStorage() {
        return foodStorage;
    }
    
    
}
