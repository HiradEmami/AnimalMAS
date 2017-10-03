package animalsimulation.model.bee;

import animalsimulation.behavior.BeeBehavior;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BeeScout extends BeeAgent {
    public double theta;
    public double tsigma;
    public double v;

    public BeeScout(BeeHive hive) {
        super(hive);
        color = Color.BLUE;
        shape = Shape.CIRCLE;
        speed = 5;
        width = 10;
        height = 10;
        stateMachine = new BeeBehavior(this);
    }
}
