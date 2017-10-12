package animalsimulation.model.bee;

import animalsimulation.model.base.Group;
import animalsimulation.model.base.WorldObject;
import java.awt.Color;

/**
 *
 * @author Ebombo2
 */
public class BeeHive extends WorldObject {
    private String hiveType;
    private Group group;
    private int gatheredFood;
    private int idleBees;
    private int activeBees;
    
    public BeeHive(String hiveType, double x, double y) {
        this(hiveType, x, y, null);
    }
    
    public BeeHive(String hiveType, double x, double y, Group group) {
        super(x, y);
        this.hiveType = hiveType;
        color = Color.YELLOW;
        shape = Shape.OVAL;
        width = 40;
        height = 80;
        
        this.group = group;
        if(group == null) {
            this.group = new Group(this.toString());
        }
    }
    
    public WorldObject[] getAffiliatedBees() {
        return group.getMembers();
    }
    
    public void addBee(BeeAgent bee) {
        group.addMember(bee);
    }
    
    public void addBees(BeeAgent[] bees) {
        for(BeeAgent bee : bees) {
            group.addMember(bee);
        }
    }
    
    public int hiveSize() {
        return group.getGroupSize();
    }
    
    public int getGatheredFood() {
        return gatheredFood;
    }
    
    public synchronized void addGatheredFood(int gatheredFood) {
        this.gatheredFood += gatheredFood;
    }
    
    public synchronized void incrementActiveBees() {
        if(idleBees > 0) {
            activeBees++;
            idleBees--;
        }
    }
    
    public synchronized void decrementActiveBees() {
        if(activeBees > 0) {
            activeBees--;
            idleBees++;
        }
    }
}
