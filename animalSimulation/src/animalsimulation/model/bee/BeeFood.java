package animalsimulation.model.bee;

import animalsimulation.model.base.WorldObject;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BeeFood extends WorldObject {
    //public int amount;          //total amount food LATER

    public BeeFood(int x, int y) {
        super(x, y);
        color = Color.GREEN;
        shape = Shape.CIRCLE;
        width = 20;
        height = 20;
    }
}
