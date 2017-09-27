/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import animalsimulation.model.base.Agent;
import animalsimulation.model.knowledge.AgentKnowledge;

/**
 * Abstract class for describing properties specific to bee typed agents.
 * A BeeAgent is an Agent, meaning it has all the properties contained
 * in the Agent class.
 * 
 * @author jeroen
 */
public abstract class BeeAgent extends Agent {
    private BeeHive hive;

    public BeeAgent(BeeHive hive) {
        this(hive.getCoordinates()[0], hive.getCoordinates()[1], hive);
    }
    
    public BeeAgent(double x, double y, BeeHive hive) {
        super(x, y);
        initKnowledge(hive);
        
        hive.addBee(this);
        this.hive = hive;
    }
    
    public void initKnowledge(BeeHive hive){
        this.knowledge = new AgentKnowledge(hive.getCoordinates());
    }
    
    public BeeHive getHive() {
        return hive;
    }
}
