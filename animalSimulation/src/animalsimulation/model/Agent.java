/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model;

import animalsimulation.model.knowledge.AgentKnowledge;

/**
 * Abstract class for describing properties shared by all types of agents.
 * An agent is a WorldObject, meaning it has all the properties contained
 * in the WorldObject class.
 *  
 * @author jeroen
 */
public abstract class Agent extends WorldObject {
    private Group group;
    protected AgentKnowledge knowledge;
    //private int energy;          // total available energy
        
    public abstract void initKnowledge(Location hiveLocation);
    public abstract void act();
}
