/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.behavior.movement;

import animalsimulation.behavior.base.State;
import animalsimulation.controller.AnimalSimulation;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.BeeAgent;
import java.util.Random;
import Jama.Matrix;

/**
 *
 * @author Ebombo2
 */
public class BiologicalBeeMovement extends BaseMovement{
    
    public void initialize(Agent agent, State state) {
        if (state.getStateName() == "Returning") {
            BeeAgent bAgent = (BeeAgent) agent;
            double[] coordinates = bAgent.getHive().getCoordinates();

            targetX = coordinates[0];
            targetY = coordinates[1];
        } else {
            targetX = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getWidth());
            targetY = (double) Math.round(Math.random() * AnimalSimulation.getSettings().getMap().getWorld().getHeight());
        }
    }

    public void execute(Agent agent, State state) {
        double[] coordinates = agent.getCoordinates();
        
        double[][] df = {{(Math.random()-0.5)},{(Math.random()-0.5)}};
        Matrix a = new Matrix(df);
        
        double[][] normal = new double[2][1];
        for(int i = 0; i < df.length; i++)
        {
            for(int j = 0; j < df[i].length; j++) {
                normal[i][j] = toSigned(df[i][j]/a.normF());
            }
        }
        
        agent.setCoordinates(coordinates[0], coordinates[1]);
        super.execute(agent, state);
    }
    
    private double toSigned(double unsigned) {
        if(unsigned < 0) {
            return -1d;
        } else if(unsigned == 0) {
            return 0d;
        } else {
            return 1d;
        }
    }

    public void reset(Agent agent, State state) {
        initialize(agent, state);
    }
}