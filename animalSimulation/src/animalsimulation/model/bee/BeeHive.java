package animalsimulation.model.bee;

import animalsimulation.model.base.Group;
import animalsimulation.model.base.WorldObject;

/**
 *
 * @author Ebombo2
 */
public class BeeHive extends WorldObject {
    private Group group;
    
    public BeeHive(int x, int y) {
        this(x, y, null);
    }
    
    public BeeHive(int x, int y, Group group) {
        super(x, y);
        
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
}
