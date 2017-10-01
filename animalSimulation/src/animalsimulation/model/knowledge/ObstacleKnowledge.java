package animalsimulation.model.knowledge;

public class ObstacleKnowledge extends LocationKnowledge{
    
    private String type ="obstacleKnowledge";
    public ObstacleKnowledge(int[] argHiveLocation, int[] argTargetLocation) {
        super(argHiveLocation, argTargetLocation);
    }

    public String getType() {
        return type;
    }
    
}
