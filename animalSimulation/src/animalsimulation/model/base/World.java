/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jeroen
 */
public class World implements BaseModel {
    private final int width, height;
    private final HashMap<Class<? extends WorldObject>, ArrayList<WorldObject>> classMap;
            
    public World(int width, int height) {
        this.width = width;
        this.height = height;
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
        addObjectToObjectSets(object, object.getClass());
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
    
    private void addObjectToObjectSets(WorldObject object, Class<? extends WorldObject> c) {
        if(!classMap.containsKey(c)) {
            classMap.put(c, new ArrayList<>());
        }
        classMap.get(c).add(object);
        if(c != WorldObject.class) {
            addObjectToObjectSets(object, (Class<? extends WorldObject>) c.getSuperclass());
        }
    }
    
    /**
     * Usefull for drawing all the worldly objects.
     * @return worldObjects
     */
    public WorldObject[] getWorldObjects() {
        return getWorldObjectsByClass(WorldObject.class);
    }
    
    /**
     * Usefull for running the simulation. Obtain all world objects of a specific
     * class (e.g. BeeWorker.class). Returns an array of the same type as the c
     * paramater.
     * @param <T>
     * @param c
     * @return worldObjects
     */
    public <T extends WorldObject> T[] getWorldObjectsByClass(Class<T> c) {
        ArrayList<WorldObject> worldObjects = classMap.get(c);
        if(worldObjects == null) { return (T[]) Array.newInstance(c, 0); }
        T[] type = (T[]) Array.newInstance(c, worldObjects.size());
        return worldObjects.toArray(type);
    }
}
