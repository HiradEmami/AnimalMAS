package animalsimulation.View;

import animalsimulation.Model.*;
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
    private ArrayList<BeeAgent> agents = new ArrayList<>();
    private ArrayList<BeeHive> hives = new ArrayList<>();
    private BeeAgent agent;
    private BeeHive hive;
    
    //DIRTY CODE IN VIEW @LOL
    public void upDate(int argAmount, int argOrigin, ArrayList<BeeAgent> argAgents, ArrayList<BeeHive> argHives)
    {
        this.amount = argAmount;
        this.origin = argOrigin;
        this.agents = argAgents;
        this.hives = argHives;
    }
    //
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        //g.setColor(Color.red);
        //g.fillOval(20-10,20-10,20,20);
        
        for(int i=0;i<=agents.size();i++)
        {
            try
            {
                agent = agents.get(i);
                switch(agent.groupNumber)
                {
                    case 1:
                    {
                        g.setColor(Color.red);
                        g.fillOval(agents.get(i).currentWidth - 10,agents.get(i).currentHeight - 10,20,20);
                        break;
                    }
                    default:
                    {
                        g.setColor(Color.black);
                        g.fillOval(agents.get(i).currentWidth - 5,agents.get(i).currentHeight - 5,10,10);
                    }
                }
            }
            catch(Exception e)
            {}
        }
        for(int i=0;i<=hives.size();i++)
        {
            try
            {
                hive = hives.get(i);
                g.setColor(Color.green);
                g.fillOval(hive.currentWidth - 10,hive.currentHeight - 10,20,20);
                break;
            }
            catch(Exception e)
            {}
        }
    }
}
