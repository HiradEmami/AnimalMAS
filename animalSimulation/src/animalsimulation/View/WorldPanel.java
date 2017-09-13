package animalsimulation.View;

import animalsimulation.AnimalAgent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 *
 * @author Ebombo2
 */
public class WorldPanel extends javax.swing.JPanel{
    private int amount;
    private int origin;
    private ArrayList<AnimalAgent> agents;
    private AnimalAgent agent;
    
    //DIRTY CODE IN VIEW
    public void upDate(int amount, int origin, ArrayList<AnimalAgent> agents)
    {
        this.amount = amount;
        this.origin = origin;
        this.agents = agents;
    }
    //
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.red);
        g.fillOval(20-10,20-10,20,20);
        
        for(int i=0;i<=agents.size();i++)
        {
            agent = agents.get(i);
            switch(agent.groupNumber)
            {
                case 1:
                {
                    g.setColor(Color.red);
                    g.fillOval(agents.get(i).currentWidth - 10,agents.get(i).currentWidth - 10,20,20);
                    break;
                }
                default:
                {
                    g.setColor(Color.black);
                    g.fillOval(agents.get(i).currentWidth - 5,agents.get(i).currentWidth - 5,10,10);
                }
            }
        }       
    }
}
