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
    private int numberOfAIWorkerBees;
    private int numberOfAIScoutBees;
    private int numberOfFoodSources;
    private int recordingInterval;
    private int simulationSteps;
    private int AIpercentage;

    public int getAIpercentage() {
        return AIpercentage;
    }

    public void setAIpercentage(int AIpercentage) {
        this.AIpercentage = AIpercentage;
    }
    
    public SimulationSettings() {
        recordingInterval = 1;
    }
    
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
        this.numberOfWorkerBees = numberOfWorkerBees;
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
    
    public int getRecordingInterval() {
        return recordingInterval;
    }
    
    public void setRecordingInterval(int recordingInterval) {
        this.recordingInterval = recordingInterval;
        if(recordingInterval < 1) {
            this.recordingInterval = 1;
        }
    }

    public int getNumberOfAIWorkerBees() {
        return numberOfAIWorkerBees;
    }

    public void setNumberOfAIWorkerBees(int numberOfAIWorkerBees) {
        this.numberOfAIWorkerBees = numberOfAIWorkerBees;
    }

    public int getNumberOfAIScoutBees() {
        return numberOfAIScoutBees;
    }

    public void setNumberOfAIScoutBees(int numberOfAIScoutBees) {
        this.numberOfAIScoutBees = numberOfAIScoutBees;
    }
    
    public int getSimulationSteps() {
        return simulationSteps;
    }
    
    public void setSimulationSteps(int simulationSteps) {
        this.simulationSteps = simulationSteps;
    }
}
