/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.knowledge;

import java.util.ArrayList;

/**
 *
 * @author Ebombo2
 */
public class AIAgentKnowledge {
    private double[] hiveLocation;
    private ArrayList<AIFoodKnowledge> foodKnowledge;
    private ArrayList<ObstacleKnowledge> obstacleKnowledge;

    public AIAgentKnowledge(double[] argHiveLocation) {
        this.hiveLocation=argHiveLocation;
        this.obstacleKnowledge= new ArrayList<>();
        this.foodKnowledge=new ArrayList<>();
    }
        
    public void updateFoodKnowledge(ArrayList<AIFoodKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewFoodKnowledge(argNewData.get(i).getTargetCoordinates()[0], 
               argNewData.get(i).getTargetCoordinates()[1]))
            {
              foodKnowledge.add(argNewData.get(i));
            }
        }
    }
    
    public boolean addnewFoodknowledge(AIFoodKnowledge argnew){
        double x = argnew.getTargetCoordinates()[0];
        double y = argnew.getTargetCoordinates()[1];
        
         for(int i=0;i<=foodKnowledge.size()-1;i++){
            if(foodKnowledge.get(i).getTargetCoordinates()[0]==x &&
                foodKnowledge.get(i).getTargetCoordinates()[1]==y){
                return false; //the data already exists 
                //means this knowledge already exists (thus) nothing was added
            }
        }
        foodKnowledge.add(argnew);
        return true; 
    }
    
    public boolean addnewObstacleKnowledge(ObstacleKnowledge argnew){
        double x = argnew.getTargetCoordinates()[0];
        double y = argnew.getTargetCoordinates()[1];
        
         for(int i=0;i<=obstacleKnowledge.size()-1;i++){
            if(obstacleKnowledge.get(i).getTargetCoordinates()[0]==x &&
                obstacleKnowledge.get(i).getTargetCoordinates()[1]==y){
                return false; //the data already exists 
                //means this knowledge already exists (thus) nothing was added
            }
        }
        obstacleKnowledge.add(argnew);
        return true; 
    }

    public void updateObstacleKnowledge(ArrayList<ObstacleKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewObstacleKnowledge(argNewData.get(i).getTargetCoordinates()[0], 
               argNewData.get(i).getTargetCoordinates()[1]))
            {
              obstacleKnowledge.add(argNewData.get(i));
            }
            
        }
    }
        
    private boolean checkNewFoodKnowledge(double x, double y){
        for(int i=0;i<=foodKnowledge.size()-1;i++){
            if(foodKnowledge.get(i).getTargetCoordinates()[0]==x &&
                foodKnowledge.get(i).getTargetCoordinates()[1]==y){
                return false; //the data already exists
            }
        }
        return true;
    }

    private boolean checkNewObstacleKnowledge(double x, double y){
        for(int i=0;i<=obstacleKnowledge.size()-1;i++){
            if(obstacleKnowledge.get(i).getTargetCoordinates()[0]==x &&
                obstacleKnowledge.get(i).getTargetCoordinates()[1]==y){
                return false; //the data already exists
            }
        }
        return true;
    }

    public ArrayList<AIFoodKnowledge> getAIFoodKnowledge() {
        return foodKnowledge;
    }

    public ArrayList<ObstacleKnowledge> getObstacleKnowledge() {
        return obstacleKnowledge;
    }
}
