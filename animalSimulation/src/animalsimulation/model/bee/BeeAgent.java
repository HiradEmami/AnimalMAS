/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import Jama.Matrix;
import animalsimulation.model.base.Agent;
import animalsimulation.model.knowledge.AgentKnowledge;

/**
 * Abstract class for describing properties specific to bee typed agents.
 * A BeeAgent is an Agent, meaning it has all the properties contained
 * in the Agent class.
 * 
 * @author jeroen
 */
public abstract class BeeAgent extends Agent {
    protected BeeHive hive;
    protected double theta;
    protected double tsigma;
    protected double v;

    public BeeAgent(BeeHive hive) {
        this(hive.getCoordinates()[0], hive.getCoordinates()[1], hive);
    }
    
    public BeeAgent(double x, double y, BeeHive hive) {
        super(x, y);
        initKnowledge(hive);
        
        hive.addBee(this);
        this.hive = hive;
    }
    
    public void initKnowledge(BeeHive hive){
        this.knowledge = new AgentKnowledge(hive.getCoordinates());
    }
    
    public BeeHive getHive() {
        return hive;
    }
    
    public double getTheta() {
        return theta;
    }
    
    public double getTsigma() {
        return tsigma;
    }
    
    public double getV() {
        return v;
    }
    
    public void newDriftVector()
    {
        double[][] df = {{(Math.random()-0.5)},{(Math.random()-0.5)}};
        Matrix a = new Matrix(df);
        
        double[][] normal = new double[2][1];
        for(int i = 0; i < df.length; i++)
        {
            for(int j = 0; j < df[i].length; j++) {
                normal[i][j] = df[i][j]/a.normF();
            }
        }
        theta = Math.acos(normal[0][0])*toSigned(normal[1][0]);
        tsigma = 3;
        v = 1.5;
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
}
