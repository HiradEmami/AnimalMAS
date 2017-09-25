/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import java.util.ArrayList;

/**
 *
 * @author jeroen
 */
public class Group {
    private String groupName;
    private final ArrayList<WorldObject> members;
    
    public Group(String groupName) {
        this.groupName = groupName;
        members = new ArrayList<>();
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public boolean isMember(WorldObject object) {
        return members.indexOf(object) > -1;
    }
    
    public WorldObject[] getMembers() {
        WorldObject[] type = new WorldObject[members.size()];
        return members.toArray(type);
    }
    
    public void addMember(WorldObject object) {
        members.add(object);
    }
    
    public void removeMember(WorldObject object) {
        members.remove(object);
    }
    
    public int getGroupSize() {
        return members.size();
    }
    
}
