
package animalsimulation.view.graphModel;

/**
 *
 * @author Hirad Gorgoroth
 */

import java.util.ArrayList;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
        
public class liveChart {
 private  XYChart chart;
 private ArrayList<Double> xData;
 private ArrayList<Double> yData_Natural;
 private ArrayList<Double> yData_AI_Waggle;
 private ArrayList<Double> yData_AI_Common;
 private ArrayList<Double> yData_AI_Straigt;
 private SwingWrapper<XYChart> mySwingWrapper;
 
    public liveChart() {
        this.xData= new ArrayList<>();
        this.yData_Natural= new ArrayList<>();
        this.yData_AI_Straigt= new ArrayList<>();
        this.yData_AI_Waggle= new ArrayList<>();
        this.yData_AI_Common= new ArrayList<>();
        
        xData.add(0.0);
        yData_Natural.add(0.0);
        yData_AI_Common.add(0.0);
        yData_AI_Straigt.add(0.0);
        yData_AI_Waggle.add(0.0);
        
        this.chart = QuickChart.getChart("HIVE Behavior",
                "Simulation Steps", "Gathered Food", "Natural Hive", xData, yData_Natural);
        
        double [] ydata=new double[]{0};
        chart.addSeries("AI-Common Knowledge", ydata);
        chart.addSeries("AI-Straight", ydata);
        chart.addSeries("AI-waggle", ydata);
        
        this.mySwingWrapper= new SwingWrapper<XYChart>(chart);
    }
   
    public void StartChart(){
        mySwingWrapper.displayChart();
    }
    
    public void addNewStep(int step, double natural, double firstAI, double secondAI, double thirdAI){
       xData.add((double)step);
       yData_Natural.add(natural);
       yData_AI_Common.add(firstAI);
       yData_AI_Straigt.add(secondAI);
       yData_AI_Waggle.add(thirdAI);
       updateSeries();
    }
    
    private void updateSeries(){
        
       chart.updateXYSeries("Natural Hive", xData,yData_Natural, null); 
       chart.updateXYSeries("AI-Common Knowledge", xData,yData_AI_Common, null); 
       chart.updateXYSeries("AI-Straight", xData,yData_AI_Straigt, null); 
       chart.updateXYSeries("AI-waggle", xData,yData_AI_Waggle, null); 
       
       mySwingWrapper.repaintChart();
    }
}
