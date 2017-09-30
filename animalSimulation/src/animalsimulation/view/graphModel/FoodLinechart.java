
package animalsimulation.view.graphModel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class FoodLinechart extends ApplicationFrame{ //application frame is their unique jframe (so it;s basically jframe)
    
    private ArrayList<Integer> naturalBeesFood;
    private ArrayList<Integer> aiBeesFood;
   /*
    
    naturalBeesFood = integer arraylist for how many foods natural hive had at each step
    so it is expected that the length of this array and aiBeesFood be the same
    
    */
   public FoodLinechart( ArrayList<Integer> argnaturalBeesFood, ArrayList<Integer> argaiBeesFood ) {
      super("Line Chart - Food Progress");
      //reading the data
      this.naturalBeesFood =argnaturalBeesFood;
      this.aiBeesFood=argaiBeesFood;
     
      
      
      //creating the energy chart 
      JFreeChart lineChart = ChartFactory.createXYLineChart(
         "Simulation Progress", //the title for the chart
         "Steps","Gathered Food", //y and x axies title 
         createDatasetEnergy(), //using the dataset that was created using this method
         PlotOrientation.VERTICAL, //Vertical or Hor
         
         true,true,false); //dont mess with these 
      
      
      XYPlot plot = lineChart.getXYPlot();//plot is used to make it look nice
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(); //adding the shapes at legends
      plot.setRenderer(renderer);
      
      plot.setOutlinePaint(Color.cyan); //outline color and stroke
      plot.setOutlineStroke(new BasicStroke(2.0f));
      
      plot.setBackgroundPaint(Color.DARK_GRAY); //background 
      
      javax.swing.JButton saveButton = new JButton("Save");// creating savebutton
      saveButton.addActionListener(new ActionListener() { //action listener
          @Override
          public void actionPerformed(ActionEvent ae) {
             try {
                 //creating the file and saving it 
                 File image= new File("FoodChart.png");
                 ChartUtilities.saveChartAsPNG(image, lineChart, 800, 800); //the size of image
                 //showing the file being saved 
                 javax.swing.JOptionPane.showMessageDialog(null, "Chart Saved at:"+image.getPath());
                 } 
             catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Failed to save the image :\n"+ex);
                                  }
                }});
         
      JPanel content = new JPanel(new BorderLayout()); //creating the content panel
      
      ChartPanel chartPanel = new ChartPanel( lineChart ); //creating the custom panel for the chart

      content.add(chartPanel, BorderLayout.NORTH); // assigning the chart to north border
      
       JPanel buttonPanel = new JPanel(new FlowLayout());
       buttonPanel.add(saveButton);
       content.add(buttonPanel, BorderLayout.SOUTH);
       
       chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 700 ) ); //just random width and height
       setContentPane( content );
     
  
     
   }

   private XYDataset  createDatasetEnergy( ) {
    XYSeriesCollection dataset = new XYSeriesCollection();
    boolean autoSort = false;
    boolean allowDuplicateXValues = false;
    XYSeries series1 = new XYSeries("Natural bees",allowDuplicateXValues,autoSort);
    XYSeries series2 = new XYSeries("AI bees",allowDuplicateXValues,autoSort);
    
 
    for(int i=0;i<=naturalBeesFood.size()-1;i++){
        series1.add(i,naturalBeesFood.get(i));
        series2.add(i,naturalBeesFood.get(i));
    }
 

    dataset.addSeries(series1);
    dataset.addSeries(series2);
    
      
      return dataset;
   }
   
   
  
}

