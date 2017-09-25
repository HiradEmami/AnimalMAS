/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model;

import java.util.ArrayList;

/**
 *
 * @author jeroen
 */
public class World {
    private int width, height;
    private ArrayList<WorldObject> objects;
    private ArrayList<Agent> agents;
    
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        objects = new ArrayList<>();
    }
    
    public void addObject(WorldObject object) {
        objects.add(object);
        
        // For performance keep track of all agents.
        if(object instanceof Agent) {
            agents.add((Agent) object);
        }
    }
    
    // Usefull for running the simulation.
    public Agent[] getAgents() {
        Agent[] type = new Agent[agents.size()];
        return agents.toArray(type);
    }
    
    // Usefull for drawing all the worldly objects.
    public WorldObject[] getWorldObjects() {
        WorldObject[] type = new WorldObject[objects.size()];
        return objects.toArray(type);
    }
}
