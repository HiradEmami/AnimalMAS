/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.base;

import animalsimulation.model.base.Agent;

/**
 *
 * @author jeroen
 */
public abstract class Action {
    public void initialize() {};
    public abstract void execute(Agent agent, State state);
    public void reset() {};
}
