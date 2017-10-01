/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.knowledge;

/**
 *
 * @author Hirad Gorgoroth
 */
public class FoodKnowledge extends LocationKnowledge{
   
    private int foodStorage;
    private String type="foodKnowledge";
    
    public FoodKnowledge(int[] argHiveLocation, int[] argTargetLocation, int argFoodStorage) {
        super(argHiveLocation, argTargetLocation);
        this.foodStorage=argFoodStorage;
        
    }

    public int getFoodStorage() {
        return foodStorage;
    }

    public String getType() {
        return type;
    }
    
}
