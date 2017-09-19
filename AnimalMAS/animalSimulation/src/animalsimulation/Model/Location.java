/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.Model;

import java.util.ArrayList;

/**
 *
 * @author jeroen
 */
public class Location {
    private final int x, y;
    private int pheromoneLevel;
    private final ArrayList<WorldObject> objects;
    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        pheromoneLevel = 0;
        objects = new ArrayList<>(); 
    }
    
    public int[] getCoordinates() {
        return new int[] {x, y};
    }
    
    public int getPheromoneLevel() {
        return pheromoneLevel;
    }
    
    public void increasePheromoneLevelBy(int value) {
        pheromoneLevel += value;
    }
    
    public void setPheromoneLevel(int pheromoneLevel) {
        this.pheromoneLevel = pheromoneLevel;
    }
    
    public WorldObject[] getObjects() {
        WorldObject[] type = new WorldObject[objects.size()];
        return objects.toArray(type);
    }
    
    public void addObject(WorldObject object) {
        object.getLocation().remove_object(object);
        object.setLocation(this);
        
        objects.add(object);
    }
    
    public void remove_object(WorldObject object) {
        objects.remove(object);
    }
}
