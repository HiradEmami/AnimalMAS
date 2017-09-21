
package animalsimulation.Model.Knowledge;

/*to add new obsticle knowledge to the agent, use addnewObstacleKnowledge and to 
add new food knowledge to the agent, use addnewFoodKnowledge.
These two methods, would either add the new information and return True or they
would return false if the knowledge already exists, Use only single knowledge 
instance to pass 

in case of sharing knowledge , you can use the update methods that automatically
adds the information that are not already known to the agent (pass arraylist of 
knowledge) for example, use the gitFoodknowledge of an agent to pass to another 
agent and updete the knowledge 
*/

import animalsimulation.Model.*;
import java.util.ArrayList;

public class AgentKnowledge {
private Location hiveLocation;
private ArrayList<FoodKnowledge> foodKnowledge;
private ArrayList<ObstacleKnowledge> obstacleKnowledge;

    public AgentKnowledge(Location argHiveLocation) {
        this.hiveLocation=argHiveLocation;
        this.obstacleKnowledge= new ArrayList<>();
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
    public boolean addnewFoodknowledge(FoodKnowledge argnew){
        int x = argnew.getTargetLocation().getCoordinates()[0];
        int y = argnew.getTargetLocation().getCoordinates()[1];
        
         for(int i=0;i<=foodKnowledge.size()-1;i++){
            if(foodKnowledge.get(i).getTargetLocation().getCoordinates()[0]==x &&
                foodKnowledge.get(i).getTargetLocation().getCoordinates()[1]==y){
                return false; //the data already exists 
                //means this knowledge already exists (thus) nothing was added
            }
        }
        foodKnowledge.add(argnew);
        return true; 
    }
      public boolean addnewObstacleKnowledge(ObstacleKnowledge argnew){
        int x = argnew.getTargetLocation().getCoordinates()[0];
        int y = argnew.getTargetLocation().getCoordinates()[1];
        
         for(int i=0;i<=obstacleKnowledge.size()-1;i++){
            if(obstacleKnowledge.get(i).getTargetLocation().getCoordinates()[0]==x &&
                obstacleKnowledge.get(i).getTargetLocation().getCoordinates()[1]==y){
                return false; //the data already exists 
                //means this knowledge already exists (thus) nothing was added
            }
        }
        obstacleKnowledge.add(argnew);
        return true; 
    }
        public void updateObsticleKnowledge(ArrayList<ObstacleKnowledge> argNewData){
        for(int i=0;i<=argNewData.size()-1;i++){
            if(checkNewObstacleKnowledge(argNewData.get(i).getTargetLocation().getCoordinates()[0], 
               argNewData.get(i).getTargetLocation().getCoordinates()[1]))
            {
              obstacleKnowledge.add(argNewData.get(i));
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
        for(int i=0;i<=obstacleKnowledge.size()-1;i++){
            if(obstacleKnowledge.get(i).getTargetLocation().getCoordinates()[0]==x &&
                obstacleKnowledge.get(i).getTargetLocation().getCoordinates()[1]==y){
                return false; //the data already exists
            }
        }
        return true;
    }


}