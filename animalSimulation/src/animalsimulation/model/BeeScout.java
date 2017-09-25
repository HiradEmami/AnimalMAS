package animalsimulation.model;

/**
 *
 * @author Ebombo2
 */
import animalsimulation.model.knowledge.AgentKnowledge;
import java.util.Random;
public class BeeScout {

    //public int energy;          //total available energy
    public int groupNumber;     //the group identifier (1:food 2:individual, 3:group 1, etc...) 
    public int id;              //unique id for the agent
    public int currentHeight;
    public int currentWidth;
    public AgentKnowledge knowledge;

    public BeeScout() {
        //this.groupNumber = 1;
        //this.groupNumber = getRandom(2, 6); //just a temporarily group id static for all GROUP ONLY
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordination(int argHeight, int argWidth) {
        this.currentHeight = argHeight;
        this.currentWidth = argWidth;
    }

    public void initKnowledge(Location argHive){
        this.knowledge =new AgentKnowledge(argHive);
    }
    //method to get random ///NOT USED
//    private static int getRandom(int min, int max) {
//        if (min >= max) {
//            throw new IllegalArgumentException("max must be greater than min");
//        }
//        Random r = new Random();
//        return r.nextInt((max - min) + 1) + min;
//    }
}
