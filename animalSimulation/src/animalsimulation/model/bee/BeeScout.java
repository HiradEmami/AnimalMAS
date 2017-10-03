package animalsimulation.model.bee;

import Jama.Matrix;
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
        newDriftVector();
    }
    
    public void newDriftVector()
    {
        double[][] df = {{(Math.random()-0.5)},{(Math.random()-0.5)}};
        Matrix a = new Matrix(df);
        
        double[][] normal = new double[2][1];
        for(int i = 0; i < df.length; i++)
        {
            for(int j = 0; j < df[i].length; j++) {
                normal[i][j] = df[i][j]/a.normF();
            }
        }
        theta = Math.acos(normal[0][0])*toSigned(normal[1][0]);
        tsigma = 3;
        v = 1.5;
    }

    private double toSigned(double unsigned) {
        if(unsigned < 0) {
            return -1d;
        } else if(unsigned == 0) {
            return 0d;
        } else {
            return 1d;
        }
    }
}
