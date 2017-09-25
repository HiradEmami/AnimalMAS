/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model;

import java.awt.Color;

/**
 *
 * @author jeroen
 */
public abstract class WorldObject {
    private int x, y;
    private Color color;
    // private Shape shape // Food for thought...
    
    public WorldObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int[] getCoordinates() {
        return new int[] {x, y};
    }
    
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Color getColor() {
        if(color == null) {
            return Color.GRAY;
        }
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
}
