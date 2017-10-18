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
    private int numberOfBioWorkerBees;
    private int numberOfBioScoutBees;
    private int numberOfKnowWorkerBees;
    private int numberOfKnowScoutBees;
    private int numberOfMoveWorkerBees;
    private int numberOfMoveScoutBees;
    private int numberOfSnWorkerBees;
    private int numberOfSnScoutBees;
    private int numberOfFoodSources;
    private int recordingInterval;
    private int simulationSteps;
    
    public SimulationSettings() {
        recordingInterval = 1;
    }
    
    public Map getMap() {
        return map;
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public int getNumberOfBioWorkerBees() {
        return numberOfBioWorkerBees;
    }
    
    public void setNumberOfBioWorkerBees(int numberOfBioWorkerBees) {
        this.numberOfBioWorkerBees = numberOfBioWorkerBees;
    }
    
    public int getNumberOfBioScoutBees() {
        return numberOfBioScoutBees;
    }
    
    public void setNumberOfBioScoutBees(int numberOfBioScoutBees) {
        this.numberOfBioScoutBees = numberOfBioScoutBees;
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
    
    public int getSimulationSteps() {
        return simulationSteps;
    }
    
    public void setSimulationSteps(int simulationSteps) {
        this.simulationSteps = simulationSteps;
    }

    public int getNumberOfKnowWorkerBees() {
        return numberOfKnowWorkerBees;
    }

    public void setNumberOfKnowWorkerBees(int numberOfKnowWorkerBees) {
        this.numberOfKnowWorkerBees = numberOfKnowWorkerBees;
    }

    public int getNumberOfKnowScoutBees() {
        return numberOfKnowScoutBees;
    }

    public void setNumberOfKnowScoutBees(int numberOfKnowScoutBees) {
        this.numberOfKnowScoutBees = numberOfKnowScoutBees;
    }

    public int getNumberOfMoveWorkerBees() {
        return numberOfMoveWorkerBees;
    }

    public void setNumberOfMoveWorkerBees(int numberOfMoveWorkerBees) {
        this.numberOfMoveWorkerBees = numberOfMoveWorkerBees;
    }

    public int getNumberOfMoveScoutBees() {
        return numberOfMoveScoutBees;
    }

    public void setNumberOfMoveScoutBees(int numberOfMoveScoutBees) {
        this.numberOfMoveScoutBees = numberOfMoveScoutBees;
    }

    public int getNumberOfSnWorkerBees() {
        return numberOfSnWorkerBees;
    }

    public void setNumberOfSnWorkerBees(int numberOfSnWorkerBees) {
        this.numberOfSnWorkerBees = numberOfSnWorkerBees;
    }

    public int getNumberOfSnScoutBees() {
        return numberOfSnScoutBees;
    }

    public void setNumberOfSnScoutBees(int numberOfSnScoutBees) {
        this.numberOfSnScoutBees = numberOfSnScoutBees;
    }
}
