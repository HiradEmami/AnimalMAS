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
public class FoodKnowledge implements Knowledge {
    private final int foodStorage;
    
    public FoodKnowledge(int foodStorage) {
        this.foodStorage= foodStorage;   
    }

    public int getFoodStorage() {
        return foodStorage;
    }
}
