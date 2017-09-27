package animalsimulation.view;

import animalsimulation.controller.AnimalSimulation;
import animalsimulation.controller.BaseController;
import animalsimulation.model.base.BaseModel;
import animalsimulation.model.base.World;
import animalsimulation.model.base.WorldObject;
import java.awt.Graphics;

/**
 *
 * @author Ebombo2
 */
public class WorldPanel extends javax.swing.JPanel implements BaseView {
    private final BaseController controller;
    private World world;
    
    public WorldPanel() {
        controller = AnimalSimulation.getSimulationController();
        controller.addView(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(world != null) {
            float scaleX = (float) this.getSize().width / world.getWidth();
            float scaleY = (float) this.getSize().height / world.getHeight();
            float scale = Math.min(scaleX, scaleY);
                        
            for(WorldObject object : world.getWorldObjects()) {
                object.drawObject(g, scale);
            }
        }
    }

    @Override
    public void updateView(BaseModel model) {
        world = (World) model;
        repaint();
    }
}
