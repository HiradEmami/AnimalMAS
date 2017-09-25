/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jeroen
 */
public abstract class WorldObject {
    protected int x, y, width, height;
    protected Color color;
    protected Shape shape;
    
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
    
    public int getWidth() {
        if(width < 3) {
            return 3;
        }
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        if(height < 3) {
            return 3;
        }
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
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
    
    public Shape getShape() {
        if(shape == null) {
            return Shape.OVAL;
        }
        return shape;
    }
    
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    
    public void drawObject(Graphics g, float scale) {
        g.setColor(getColor());
        int[] dimensions = {
            Math.round((x - getWidth() / 2) * scale),    // Center x
            Math.round((y - getHeight() / 2) * scale),   // Center y
            Math.round(getWidth() * scale),            // Width
            Math.round(getHeight() * scale)            // Height
        };
        
        switch(getShape()) {
            case CIRCLE:
                g.fillArc(dimensions[0], dimensions[1], dimensions[2], dimensions[3], 0, 360);
                break;
            case OVAL:
                g.fillOval(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
                break;
            case RECTANGLE:
                g.fillRect(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
                break;
        }
    }
    
    public enum Shape {
        CIRCLE, OVAL, RECTANGLE 
    }
}
