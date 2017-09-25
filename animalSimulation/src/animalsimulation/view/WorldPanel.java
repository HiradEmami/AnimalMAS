package animalsimulation.view;

import animalsimulation.model.bee.BeeFood;
import animalsimulation.model.bee.BeeScout;
import animalsimulation.model.bee.BeeWorker;
import animalsimulation.model.bee.BeeHive;
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
    private ArrayList<BeeScout> scouts = new ArrayList<>();
    private ArrayList<BeeWorker> workers = new ArrayList<>();
    private ArrayList<BeeHive> hives = new ArrayList<>();
    private ArrayList<BeeFood> foods = new ArrayList<>();
    private BeeFood food;
    private BeeHive hive;
    private BeeScout scout;
    private BeeWorker worker;
    
    //DIRTY CODE IN VIEW @LOL
    public void upDate(int argAmount, int argOrigin, ArrayList<BeeScout> argScouts, ArrayList<BeeHive> argHives, ArrayList<BeeFood> argFoods, ArrayList<BeeWorker> argWorkers)
    {
        this.amount = argAmount;
        this.origin = argOrigin;
        this.scouts = argScouts;
        this.hives = argHives;
        this.foods = argFoods;
        this.workers = argWorkers;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for(int i=0;i<=scouts.size();i++)
        {
            try
            {
                scout = scouts.get(i);
                g.setColor(Color.black);
                //g.fillOval(scout.currentWidth - 5,scout.currentHeight - 5,10,10);
            }
            catch(Exception e)
            {}
        }
        for(int i=0;i<=workers.size();i++)
        {
            try
            {
                worker = workers.get(i);
                g.setColor(Color.blue);
                //g.fillOval(worker.currentWidth - 5,worker.currentHeight - 5,10,10);
            }
            catch(Exception e)
            {}
        }
        for(int i=0;i<=foods.size();i++)
        {
            try
            {
                food = foods.get(i);
                g.setColor(Color.red);
                g.fillOval(food.getCoordinates()[0] - 10,food.getCoordinates()[1] - 10,20,20);
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
                g.fillOval(hive.getCoordinates()[0] - 10,hive.getCoordinates()[1] - 10,20,20);
            }
            catch(Exception e)
            {}
        }
    }
}
