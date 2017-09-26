/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

/**
 *
 * @author jeroen
 */
public abstract class Event {
    protected Object source;
    
    public Event(Object source) {
        this.source = source;
    }
    
    public void beforeStateChange() {}
    public void afterStateChange() {}
}
