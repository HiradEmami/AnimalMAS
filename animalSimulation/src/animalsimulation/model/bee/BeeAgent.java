/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.model.Agent;
import animalsimulation.model.Location;
import animalsimulation.model.knowledge.AgentKnowledge;

/**
 * Abstract class for describing properties specific to bee typed agents.
 * A BeeAgent is an Agent, meaning it has all the properties contained
 * in the Agent class.
 * 
 * @author jeroen
 */
public abstract class BeeAgent extends Agent {

    public BeeAgent(Location hiveLocation) {
        initKnowledge(hiveLocation);
    }
    
    @Override
    public void initKnowledge(Location hiveLocation){
        this.knowledge = new AgentKnowledge(hiveLocation);
    }
}
