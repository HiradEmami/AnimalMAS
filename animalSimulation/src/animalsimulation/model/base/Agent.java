/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import animalsimulation.behavior.base.StateMachine;
import animalsimulation.model.knowledge.AgentKnowledge;

/**
 * Abstract class for describing properties shared by all types of agents.
 * An agent is a WorldObject, meaning it has all the properties contained
 * in the WorldObject class.
 *  
 * @author jeroen
 */
public abstract class Agent extends WorldObject {
    private static final Group individuals = new Group("Individuals");
    
    private Group group;
    protected int speed;
    protected AgentKnowledge knowledge;
    protected StateMachine stateMachine;
    //private int energy;          // total available energy

    public Agent(double x, double y) {
        this(x, y, null);
    }
    
    public Agent(double x, double y, Group group) {
        super(x, y);
        setGroup(group);
        speed = 1;
    }
    
    public AgentKnowledge getKnowledge() {
        return knowledge;
    }
    
    public void initKnowledge() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void act() {
        if(stateMachine != null)
        {
            stateMachine.tick();
            stateMachine.getCurrentState().act(this);
        }
    }

    // Group methods.
    
    public Group getGroup() {
        return group;
    }
    
    // An agent may only be a member of one group at any given time.
    // If the group parameter is null, the agent is added to the
    // Individuals group.
    public void setGroup(Group group) {
        if(group == null) {
            setGroup(individuals);
        }
        else {
            this.group = group;
            group.addMember(this);

            if(this.group != null) {
                this.group.removeMember(this);
            }
        }
    }
    
    public StateMachine getStateMachine() {
        return stateMachine;
    }
    
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
