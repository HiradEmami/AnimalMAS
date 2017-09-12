/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;

/**
 *
 * @author Ebombo2
 */
public class WorldPanel extends javax.swing.JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for(int i=0;i<10;i++)
        {
            g.setColor(Color.black);
            g.fillOval(20*i,20*i,10,10);
            g.setColor(Color.red);
            g.fillOval(10+20*i,10+20*i,10,10);
            g.setColor(Color.green);
            g.fillOval(500-20,800-20,20,20);
        }
    }
}
