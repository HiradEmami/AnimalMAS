/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation;

import java.util.Random;

/**
 *
 * @author Hirad Gorgoroth
 */
public class animalAgents {

    public int energy; //total available energy
    
    public int groupNumber; //the group identifier (2: group 1, 3: group 2, etc...) 
    /*
    ***NOTE*** since the desing has value 0 assigned to empty tile and 
    value 1 for the food , the value of each group equals to the number of group
    plus one. Thus the group value for group n will be equal to n+1
    */
    public int id; //unique id for the agent
    public int currentHeight;
    public int currentWidth;
    
    
    public animalAgents(int argID, int argGroup){
        this.id=argID;
        this.groupNumber=argGroup;
        
    }
    public animalAgents(){
        this.groupNumber=getRandom(2, 6); //just a temporarily group id static for all\
        
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCoordination(int argHeight, int argWidth){
        this.currentHeight=argHeight;
        this.currentWidth=argWidth;
    }
      private static int getRandom(int min, int max) { //method to get random 

	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
}
}
