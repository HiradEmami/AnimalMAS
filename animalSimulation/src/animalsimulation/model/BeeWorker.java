/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model;

import animalsimulation.model.knowledge.AgentKnowledge;

/**
 *
 * @author Ebombo2
 */
public class BeeWorker {
    //public int energy;          //total available energy
    public int groupNumber;     //the group identifier (1:food 2:individual, 3:group 1, etc...) 
    public int id;              //unique id for the agent
    public int currentHeight;
    public int currentWidth;
    public AgentKnowledge knowledge;
    
    public BeeWorker() {
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
}
