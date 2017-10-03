package animalsimulation.model.knowledge;

public class ObstacleKnowledge extends LocationKnowledge{
    
    private String type ="obstacleKnowledge";
    public ObstacleKnowledge(double[] argHiveLocation, double[] argTargetLocation) {
        super(argHiveLocation, argTargetLocation);
    }

    public String getType() {
        return type;
    }
    
}
