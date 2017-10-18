/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.bee;

import Jama.Matrix;
import animalsimulation.model.base.Agent;
import animalsimulation.model.knowledge.LocationKnowledge;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

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
    private int gatheredFood;

    public BeeAgent(BeeHive hive) {
        this(hive.getCoordinates()[0], hive.getCoordinates()[1], hive);
    }
    
    public BeeAgent(double x, double y, BeeHive hive) {
        super(x, y);
        
        hive.addBee(this);
        this.hive = hive;
        this.tsigma = 3;
        this.v = 1.5;
        
        // All bees are aware of their hive's location.
        knowledge.updateKnowledge(hive, new LocationKnowledge(hive.getCoordinates()));
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
    
    public double[] newTargetFactor(Agent agent)
    {
        BeeFood[] foodSources = knowledge.getKnownWorldObjectsByClass(BeeFood.class);
        double[] normal = {0,1};
        
        int index = (int) Math.round(Math.random()*foodSources.length);
        if(index<=0) { index = 1; }
        
        LocationKnowledge location = knowledge.getObjectKnowledgeByKnowledgeClass(
                foodSources[index - 1], LocationKnowledge.class);
        
        Vector2D agentC = new Vector2D(agent.getCoordinates());
        Vector2D targetC = new Vector2D(location.getCoordinates());
        double[] target = targetC.toArray();
        Vector2D u = targetC.subtract(agentC);
        double[] w = u.toArray();
        
        for(int j = 0; j < w.length; j++) {
                normal[j] = w[j]/u.getNorm();
            }
        theta = (Math.acos(normal[0])*toSigned(normal[1]));
        
        return target;
    }
    
    public double getD(Agent agent, double[] targetCoordinates)
    {
        BeeAgent bee = (BeeAgent) agent;
        
        Vector2D recruitedSpot = new Vector2D(targetCoordinates);
        Vector2D agentSpot = new Vector2D(bee.getCoordinates());
        Vector2D hiveSpot = new Vector2D(bee.getHive().getCoordinates());

        Vector2D a = recruitedSpot.subtract(hiveSpot);
        Vector2D b = agentSpot.subtract(hiveSpot);
        
        Vector2D c = a.subtract(b);
        
        return(c.getNorm());
    }
    
    public int getGatheredFood() {
        return gatheredFood;
    }
    
    public void setGatheredFood(int gatheredFood) {
        this.gatheredFood = gatheredFood;
    }
}
