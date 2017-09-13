package animalsimulation.Model;

/**
 *
 * @author Ebombo2
 */
public class BeeFood {

    //public int amount;          //total amount food LATER
    public int id;              //unique id for the agent
    public int currentHeight;
    public int currentWidth;

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordination(int argHeight, int argWidth) {
        this.currentHeight = argHeight;
        this.currentWidth = argWidth;
    }
}
