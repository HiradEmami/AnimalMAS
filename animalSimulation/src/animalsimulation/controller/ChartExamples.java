
package animalsimulation.controller;

import animalsimulation.view.graphModel.*;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChartExamples {

    public  ChartExamples(String[] args) {
        ArrayList<Integer> exampleNaturalBeeFood= new ArrayList<Integer>();
        exampleNaturalBeeFood.add(5);
        exampleNaturalBeeFood.add(10);
        exampleNaturalBeeFood.add(13);
        exampleNaturalBeeFood.add(20);
        exampleNaturalBeeFood.add(22);
        exampleNaturalBeeFood.add(26);
        exampleNaturalBeeFood.add(31);
        exampleNaturalBeeFood.add(42);
        exampleNaturalBeeFood.add(50);
        exampleNaturalBeeFood.add(60);
        
         ArrayList<Integer> exampleAIlBeeFood = new ArrayList<Integer>();
         exampleAIlBeeFood.add(15);
         exampleAIlBeeFood.add(17);
         exampleAIlBeeFood.add(19);
         exampleAIlBeeFood.add(25);
         exampleAIlBeeFood.add(27);
         exampleAIlBeeFood.add(30);
         exampleAIlBeeFood.add(31);
         exampleAIlBeeFood.add(46);
         exampleAIlBeeFood.add(60);
         exampleAIlBeeFood.add(80);
         
        
        
        LineChart chart = new LineChart(exampleNaturalBeeFood,exampleAIlBeeFood);
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setLocationRelativeTo(null);                                  //centering the frame to center
        chart.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        chart.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        chart.setVisible(true);                                             //displaying the frame
        
        
        
        
        
        
    }
    
}
