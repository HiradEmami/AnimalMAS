/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jeroen
 */
public class World {
    private final int width, height;
    private final ArrayList<WorldObject> objects;
    private final HashMap<Class<?>, ArrayList<WorldObject>> classMap;
            
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        objects = new ArrayList<>();
        classMap = new HashMap<>();
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    /**
     * Adds an object to the world.
     * @param object 
     */
    public void addObject(WorldObject object) {
        objects.add(object);
        
        // For performance keep track of all specific object classes.
        if(!classMap.containsKey(object.getClass())) {
            classMap.put(object.getClass(), new ArrayList<>());
        }
        classMap.get(object.getClass()).add(object);
    }
    
    /**
     * Adds a set of objects to the world.
     * @param objects 
     */
    public void addObjects(WorldObject[] objects) {
        for(WorldObject object : objects) {
            addObject(object);
        }
    }
    
    /**
     * Usefull for drawing all the worldly objects.
     * @return worldObjects
     */
    public WorldObject[] getWorldObjects() {
        WorldObject[] type = new WorldObject[objects.size()];
        return objects.toArray(type);
    }
    
    /**
     * Usefull for running the simulation. Obtain all world objects of a specific
     * class (e.g. BeeWorker.class). Returns an array of the same type as the c
     * paramater.
     * @param <T>
     * @param c
     * @return worldObjects
     */
    public <T> T[] getWorldObjectsByClass(Class<T> c) {
        ArrayList<WorldObject> worldObjects = classMap.get(c);
        WorldObject[] type = new WorldObject[worldObjects.size()];
        return (T[]) worldObjects.toArray(type);
    }
}
