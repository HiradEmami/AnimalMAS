/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BeeWorker extends BeeAgent {

    public BeeWorker(BeeHive hive) {
        super(hive);
        color = Color.BLACK;
        shape = Shape.CIRCLE;
        width = 10;
        height = 10;
    }
}
