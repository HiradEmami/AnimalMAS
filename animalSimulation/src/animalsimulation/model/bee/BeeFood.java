package animalsimulation.model.bee;

import animalsimulation.model.base.WorldObject;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BeeFood extends WorldObject {
    private double quality;
    private int foodYield;

    public BeeFood(double x, double y) {
        super(x, y);
        color = Color.GREEN;
        shape = Shape.CIRCLE;
        width = 20;
        height = 20;
        
        foodYield = 3;
        quality = Math.random();
    }
    
    public double getQuality() {
        return quality;
    }
    
    public void setQuality(double quality) {
        this.quality = quality;
    }
    
    public int getFoodYield() {
        return foodYield;
    }
    
    public void setFoodYield(int foodYield) {
        this.foodYield = foodYield;
    }
    
    public int getQualityFoodYield() {
        return (int) Math.ceil(this.foodYield * this.quality);
    }
}
