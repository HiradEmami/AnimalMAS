package animalsimulation.model.bee;

import java.awt.Color;

/**
 *
 * @author Ebombo2
 */

public class BeeScout extends BeeAgent {

    public BeeScout(BeeHive hive) {
        super(hive);
        color = Color.BLUE;
        shape = Shape.CIRCLE;
        width = 10;
        height = 10;
    }

    @Override
    public void act() {
        // Add behavior here!
    }
}
