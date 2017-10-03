package animalsimulation.model.bee;

import animalsimulation.behavior.ScoutBeeBehavior;
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
        speed = 2;
        width = 10;
        height = 10;
        stateMachine = new ScoutBeeBehavior(this);
        newDriftVector();
    }

}
