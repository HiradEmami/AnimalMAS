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
    private ArrayList<FoodKnowledge> aifoodKnowledge;
    private ArrayList<ObstacleKnowledge> obstacleKnowledge;

    public AIAgentKnowledge(double[] argHiveLocation) {
        this.hiveLocation=argHiveLocation;
        this.obstacleKnowledge= new ArrayList<>();
        this.aifoodKnowledge=new ArrayList<>();
    }
        
    public void updateFoodKnowledge(ArrayList<FoodKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewFoodKnowledge(argNewData.get(i).getTargetCoordinates()[0], 
               argNewData.get(i).getTargetCoordinates()[1]))
            {
              aifoodKnowledge.add(argNewData.get(i));
            }
        }
    }
    
    public boolean addnewFoodknowledge(FoodKnowledge argnew){
        double x = argnew.getTargetCoordinates()[0];
        double y = argnew.getTargetCoordinates()[1];
        
         for(int i=0;i<=aifoodKnowledge.size()-1;i++){
            if(aifoodKnowledge.get(i).getTargetCoordinates()[0]==x &&
                aifoodKnowledge.get(i).getTargetCoordinates()[1]==y){
                return false; //the data already exists 
                //means this knowledge already exists (thus) nothing was added
            }
        }
        aifoodKnowledge.add(argnew);
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
        for(int i=0;i<=aifoodKnowledge.size()-1;i++){
            if(aifoodKnowledge.get(i).getTargetCoordinates()[0]==x &&
                aifoodKnowledge.get(i).getTargetCoordinates()[1]==y){
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

    public ArrayList<FoodKnowledge> getAIFoodKnowledge() {
        return aifoodKnowledge;
    }

    public ArrayList<ObstacleKnowledge> getObstacleKnowledge() {
        return obstacleKnowledge;
    }
}
