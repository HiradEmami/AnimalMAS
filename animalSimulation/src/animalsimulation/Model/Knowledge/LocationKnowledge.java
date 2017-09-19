
package animalsimulation.Model.Knowledge;
 
import animalsimulation.Model.Location;

  
public class LocationKnowledge {
private Location targetLocation;
private float direction;
private Location hiveLocation;
private double distance;

    public LocationKnowledge(Location argHiveLocation, Location argTargetLocation) {
        this.targetLocation=argTargetLocation;
        this.hiveLocation=argHiveLocation;
        setDirection();
        setDistance();
    }

    public float getDirection() {
        return direction;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }
    private void setDirection(){ 
        this.direction= (float) Math.toDegrees(Math.atan2((targetLocation.getCoordinates()[1]-hiveLocation.getCoordinates()[1]),
               (targetLocation.getCoordinates()[0]-hiveLocation.getCoordinates()[0])));
        if (direction<0){
            direction +=360;
        }
    }
    private void setDistance(){
        this.distance = Math.hypot((targetLocation.getCoordinates()[0]-hiveLocation.getCoordinates()[0]), 
                (targetLocation.getCoordinates()[1]-hiveLocation.getCoordinates()[1]));
    }
    public double getDistance() {
        return distance;
    }
    
    

}
