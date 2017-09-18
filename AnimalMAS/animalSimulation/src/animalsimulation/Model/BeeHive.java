package animalsimulation.Model;

import java.util.ArrayList;

/**
 *
 * @author Ebombo2
 */
public class BeeHive {

    public int id;              //unique id for the agent
    public int currentHeight;
    public int currentWidth;
    public ArrayList<BeeScout> scoutBees;
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCoordination(int argHeight, int argWidth) {
        this.currentHeight = argHeight;
        this.currentWidth = argWidth;
    }
}
