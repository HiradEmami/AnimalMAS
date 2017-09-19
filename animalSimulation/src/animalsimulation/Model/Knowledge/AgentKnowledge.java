
package animalsimulation.Model.Knowledge;

import animalsimulation.Model.*;
import java.util.ArrayList;

public class AgentKnowledge {
private Location hiveLocation;
private ArrayList<FoodKnowledge> foodKnowledge;
private ArrayList<obstacleKnowledge> obsticleKnowledge;

    public AgentKnowledge(Location argHiveLocation) {
        this.hiveLocation=argHiveLocation;
        this.obsticleKnowledge= new ArrayList<>();
        this.foodKnowledge=new ArrayList<>();
        
    }
    
    
    public void updateFoodKnowledge(ArrayList<FoodKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewFoodKnowledge(argNewData.get(i).getTargetLocation().getCoordinates()[0], 
                                      argNewData.get(i).getTargetLocation().getCoordinates()[1]))
            {
              foodKnowledge.add(argNewData.get(i));
            }
            
        }
    }
        public void updateObsticleKnowledge(ArrayList<obstacleKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewObstacleKnowledge(argNewData.get(i).getTargetLocation().getCoordinates()[0], 
                                      argNewData.get(i).getTargetLocation().getCoordinates()[1]))
            {
              obsticleKnowledge.add(argNewData.get(i));
            }
            
        }
    }
    private boolean checkNewFoodKnowledge(int x, int y){
        for(int i=0;i<=foodKnowledge.size()-1;i++){
            if(foodKnowledge.get(i).getTargetLocation().getCoordinates()[0]==x &&
                foodKnowledge.get(i).getTargetLocation().getCoordinates()[1]==y){
                return false; //the data already exists
            }
        }
        return true;
    }

 private boolean checkNewObstacleKnowledge(int x, int y){
        for(int i=0;i<=obsticleKnowledge.size()-1;i++){
            if(obsticleKnowledge.get(i).getTargetLocation().getCoordinates()[0]==x &&
                obsticleKnowledge.get(i).getTargetLocation().getCoordinates()[1]==y){
                return false; //the data already exists
            }
        }
        return true;
    }


}
