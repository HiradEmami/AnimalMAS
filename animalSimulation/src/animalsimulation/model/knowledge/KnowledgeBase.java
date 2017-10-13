/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.knowledge;

import animalsimulation.model.base.WorldObject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jeroen
 */
public class KnowledgeBase {
    // For each object there is a list of factual knowledge about the objects
    // There is only one knowledge instance of each type.
    private HashMap<WorldObject, HashMap<Class<? extends Knowledge>, Knowledge>> objectKnowledge;
    // The object map allows for retrieving a list of objects by object type.
    private HashMap<Class<? extends WorldObject>, ArrayList<WorldObject>> objectMap;
    
    public KnowledgeBase() {
        objectKnowledge = new HashMap<>();
        objectMap = new HashMap<>();
    }
    
    /** Updates the knowledge on a specific object. **/
    public void updateKnowledge(WorldObject object, Knowledge knowledge) {
        if(!objectKnowledge.containsKey(object)) {
            objectKnowledge.put(object, new HashMap<>());
        }
        objectKnowledge.get(object).put(knowledge.getClass(), knowledge);
        addObjectToObjectSets(object, object.getClass());
    }
    
    /** Updates the knowledge on a specific object. **/
    public void updateKnowledge(WorldObject object, Knowledge[] knowledge) {
        for(int i = 0; i < knowledge.length; i++) {
            updateKnowledge(object, knowledge[i]);
        }
    }
    
    /** Returns the set of all known world objects. **/
    public WorldObject[] getKnownWorldObjects() {
        ArrayList<WorldObject> objects = new ArrayList<>();
        for(Class<? extends WorldObject> key : objectMap.keySet()) {
            for(WorldObject object : objectMap.get(key)) {
                if(!objects.contains(object)) {
                    objects.add(object);
                }
            }
        }
        WorldObject[] type = new WorldObject[objects.size()];
        return objects.toArray(type);
    }
    
    /** 
     * Returns a set of known object of a specific class.
     * The list is ordered by updates, whith the latest updated object
     **/
    public <T extends WorldObject> T[] getKnownWorldObjectsByClass(Class<T> c) {
        ArrayList<WorldObject> worldObjects = objectMap.get(c);
        if(worldObjects == null) { return (T[]) Array.newInstance(c, 0); }
        T[] type = (T[]) Array.newInstance(c, worldObjects.size());
        return worldObjects.toArray(type);
    }
    
    /** Returns the all knowledge about a specific world object. **/
    public Knowledge[] getObjectKnowledge(WorldObject object) {
        ArrayList<Knowledge> knowledge = new ArrayList<>();
        if(objectKnowledge.get(object) == null) { return new Knowledge[]{}; }
        
        for(Class<? extends Knowledge> key : objectKnowledge.get(object).keySet()) {
            knowledge.add(objectKnowledge.get(object).get(key));
        }
        
        Knowledge[] type = new Knowledge[knowledge.size()];
        return knowledge.toArray(type);
    }
    
    /** Get only a specific type of knowledge about a world object. **/
    public <T extends Knowledge> T getObjectKnowledgeByKnowledgeClass(WorldObject object, Class<T> c) {
        if(objectKnowledge.get(object) == null) { return null; }
        return (T) objectKnowledge.get(object).get(c);
    }
    
    // PRIVATE METHODS
    
    private void addObjectToObjectSets(WorldObject object, Class<? extends WorldObject> c) {
        if(!objectMap.containsKey(c)) {
            objectMap.put(c, new ArrayList<>());
        }
        objectMap.get(c).remove(object); // Ensure that the list is ordered by latest updates.
        objectMap.get(c).add(object);        
        if(c != WorldObject.class) {
            addObjectToObjectSets(object, (Class<? extends WorldObject>) c.getSuperclass());
        }
    }
}
