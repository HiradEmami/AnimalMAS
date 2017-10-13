/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.knowledge;

/**
 *
 * @author Ebombo2
 */
public class AIFoodKnowledge extends LocationKnowledge{
    private int foodStorage;
    
    public AIFoodKnowledge(double[] argHiveLocation, double[] argTargetLocation, int argFoodStorage) {
        super(argHiveLocation, argTargetLocation);
        this.foodStorage=argFoodStorage;   
    }

    public int getFoodStorage() {
        return foodStorage;
    }
}
