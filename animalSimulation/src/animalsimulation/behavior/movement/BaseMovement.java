/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.Action;

/**
 *
 * @author jeroen
 */
public abstract class BaseMovement implements Action {
    protected int targetX, targetY;
    
    public int[] getTargetCoordinates() {
        return new int[] {targetX, targetY};
    }
    
    public void setTargetCoordinates(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }
}
