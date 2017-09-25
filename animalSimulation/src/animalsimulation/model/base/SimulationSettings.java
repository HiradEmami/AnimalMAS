/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import animalsimulation.map.Map;

/**
 *
 * @author jeroen
 */
public class SimulationSettings {
    private Map map;
    private int numberOfWorkerBees;
    private int numberOfScoutBees;
    private int numberOfFoodSources;
    
    public Map getMap() {
        return map;
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public int getNumberOfWorkerBees() {
        return numberOfWorkerBees;
    }
    
    public void setNumberOfWorkerBees(int numberOfWorkerBees) {
        this.numberOfScoutBees = numberOfWorkerBees;
    }
    
    public int getNumberOfScoutBees() {
        return numberOfScoutBees;
    }
    
    public void setNumberOfScoutBees(int numberOfScoutBees) {
        this.numberOfScoutBees = numberOfScoutBees;
    }
    
    public int getNumberOfFoodSources() {
        return numberOfFoodSources;
    }
    
    public void setNumberOfFoodSources(int numberOfFoodSources) {
        this.numberOfFoodSources = numberOfFoodSources;
    }
}
