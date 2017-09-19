/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.Model;

import java.awt.Color;

/**
 *
 * @author jeroen
 */
public abstract class WorldObject {
    private Location location;
    private Color color;
    // private Shape shape // Food for thought...
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
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
