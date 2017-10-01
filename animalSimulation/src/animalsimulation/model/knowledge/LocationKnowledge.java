package animalsimulation.model.knowledge;
  
public class LocationKnowledge {
    private int[] targetLocation;
    private float direction;
    private int[] hiveLocation;
    private double distance;

    public LocationKnowledge(int[] argHiveLocation, int[] argTargetLocation) {
        this.targetLocation=argTargetLocation;
        this.hiveLocation=argHiveLocation;
        setDirection();
        setDistance();
    }

    public float getDirection() {
        return direction;
    }

    public int[] getTargetCoordinates() {
        return targetLocation;
    }
    
    private void setDirection(){ 
        this.direction= (float) Math.toDegrees(Math.atan2((targetLocation[1]-hiveLocation[1]),
               (targetLocation[0]-hiveLocation[0])));
        if (direction<0){
            direction +=360;
        }
    }
    
    private void setDistance(){
        this.distance = Math.hypot((targetLocation[0]-hiveLocation[0]), 
                (targetLocation[1]-hiveLocation[1]));
    }
    
    public double getDistance() {
        return distance;
    }
    
}
