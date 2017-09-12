/**
 *
 * @author Hirad Gorgoroth
 */
package animalsimulation;

import java.util.Random;

public class animalAgents {

    public int energy;          //total available energy
    public int groupNumber;     //the group identifier (0:empty 1:food 2:individual, 3:group 1, etc...) 
    public int id;              //unique id for the agent
    public int currentHeight;
    public int currentWidth;

    public animalAgents(int argID, int argGroup) {
        this.id = argID;
        this.groupNumber = argGroup;
    }

    public animalAgents() {
        this.groupNumber = getRandom(2, 6); //just a temporarily group id static for all

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordination(int argHeight, int argWidth) {
        this.currentHeight = argHeight;
        this.currentWidth = argWidth;
    }

    //method to get random
    private static int getRandom(int min, int max) { 
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
