
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
         
        
        //you need these to create the custom chart frame
        EnergyLinechart chart1 = new EnergyLinechart(exampleNaturalBeeFood,exampleAIlBeeFood);
        RefineryUtilities.centerFrameOnScreen( chart1 );
        chart1.setLocationRelativeTo(null);                                  //centering the frame to center
        chart1.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        chart1.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        chart1.setVisible(true);                                             //displaying the frame
        
        
        //you need these to create the custom chart frame
        FoodLinechart chart2 = new FoodLinechart(exampleNaturalBeeFood,exampleAIlBeeFood);
        RefineryUtilities.centerFrameOnScreen( chart2 );
        chart2.setLocationRelativeTo(null);                                  //centering the frame to center
        chart2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   //setting the close function to completely exit the app
        chart2.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);          //to make it full screen
        chart2.setVisible(true);                                             //displaying the frame
        
        
        
        
        
    }
    
}
