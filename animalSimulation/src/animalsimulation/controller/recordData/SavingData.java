
package animalsimulation.controller.recordData;

import animalsimulation.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import animalsimulation.behavior.base.*;
import animalsimulation.model.base.Agent;
import animalsimulation.model.bee.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SavingData {
   private XSSFWorkbook workbook;
   private XSSFSheet sheet;
   private ArrayList<Object[]>  NaturalhiveData;
   private ArrayList<Object[]> AiHiveData;
   private int iteration;
   
    public SavingData() {
        this.iteration=0;
        this.AiHiveData = new ArrayList<>();
        this.NaturalhiveData= new ArrayList<>();
        Object [] heading= {"Iteration","Hive Type","Inactive Agents","Active Agents","Food"};
        NaturalhiveData.add(heading); //since we first add the natural hive data then the heading will be there
    }
    
    public void addnewIteration(ArrayList<BeeScout> argNaturalScout, 
            ArrayList<BeeWorker> argNaturalWorker,
            ArrayList<BeeScout> argAIScout, 
            ArrayList<BeeWorker> argAIWorker,
            int aiFood, int naturalFood)
    {
        iteration++;
        int []inactive={0,0}; //natural - AI
        int [] active = {0,0}; //Natural - AI   
        int [] food = {0,0}; //Natural - AI 
        
        
        
    }
    
    private int [] countAgents(ArrayList<Agent> argScout, ArrayList<Agent> argWorker){
        int [] counter= {0,0};
        
        
        for(Agent b: argScout){
           b.getStateMachine().getCurrentState().getStateName().equals("Idle");
        }
        
        return counter;
    }
    
    public void saveSimulationData(){
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Simulation Output");
        int rowNum = 0;
        System.out.println("Creating excel File");

        for (Object[] datatype : NaturalhiveData) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
         for (Object[] datatype : AiHiveData) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("Simulation Output");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        javax.swing.JOptionPane.showMessageDialog(null, 
                "The data has been saved! ");
    }
}
