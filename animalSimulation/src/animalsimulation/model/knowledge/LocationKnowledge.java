package animalsimulation.model.knowledge;
  
public class LocationKnowledge {
    private double[] targetLocation;
    private float direction;
    private double[] hiveLocation;
    private double distance;

    public LocationKnowledge(double[] argTargetLocation) {
        this.targetLocation=argTargetLocation;
    }
    
    public double[] getTargetCoordinates() {
        return targetLocation;
    }
}
