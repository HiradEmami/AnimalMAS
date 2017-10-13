package animalsimulation.model.knowledge;
  
public class LocationKnowledge implements Knowledge {
    private final double[] coordinates;

    public LocationKnowledge(double[] coordinates) {
        this.coordinates= coordinates;
    }
    
    public double[] getCoordinates() {
        return coordinates;
    }
}
