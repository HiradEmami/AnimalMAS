/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.Model;

/**
 *
 * @author jeroen
 */
public class World {
    private Location[][] world;
    
    public World(int gridWidth, int gridHeight) {
        initializeWorld(gridWidth, gridHeight);
    }
    
    public Object[] getObjectsAt(int x, int y) {
        return new Object[] {};
    }
    
    public void addObjectAt(int x, int y, WorldObject object) {
        getLocationAt(x, y).addObject(object);
    }
    
    public int getPheromoneLevelAt(int x, int y) {
        return getLocationAt(x, y).getPheromoneLevel();
    }
    
    synchronized public void increasePhermoneLevelAt(int x, int y, int value) {
        getLocationAt(x, y).increasePheromoneLevelBy(value);
    }
    
    public Location getLocationAt(int x, int y) {
        return world[x][y];
    }
    
    /* Private functions */
    
    private void initializeWorld(int gridWidth, int gridHeight) {
        world = new Location[gridWidth][gridHeight];
        for(int i = 0; i < gridWidth; i++) {
            for(int j = 0; j < gridHeight; j++) {
                world[i][j] = new Location(i, j);
            }
        }
    }
}
