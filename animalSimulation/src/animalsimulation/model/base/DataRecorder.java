/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.model.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jeroen
 */
public class DataRecorder {
    public static final String OUTPUT_FILE = "SimulationOutput";
    
    private ArrayList<WorldObject> dataSources;
    private HashMap<XSSFSheet, Integer> sheetMap;
    private XSSFWorkbook workbook;
    private File file;
    
    public DataRecorder() throws IOException {
        this(null);
    }
    
    public DataRecorder(WorldObject[] dataSources) throws IOException {
        reset();
        
        if(dataSources != null) {
            for(WorldObject dataSource : dataSources) {
                addDataSource(dataSource);
            }
        }     
        
        file = new File(OUTPUT_FILE + "[" + System.identityHashCode(this) + "]" + ".xlsx");
        file.createNewFile();  
    }
    
    public WorldObject[] getDataSources() {
        WorldObject[] type = new WorldObject[dataSources.size()];
        return dataSources.toArray(type);
    }
    
    public void addDataSource(WorldObject dataSource) {
        try {
            dataSources.add(dataSource);
            XSSFSheet sheet = workbook.createSheet(dataSource.getClass().getSimpleName() +
                    " " + System.identityHashCode(dataSource));
            writeHeader(sheet, dataSource);
            sheetMap.put(sheet, 1);
        } catch (IOException ex) {}
    }
    
    public void removeDataSource(WorldObject dataSource) {
        int index = dataSources.indexOf(dataSource);
        dataSources.remove(dataSource);
        XSSFSheet sheet = workbook.getSheetAt(index);
        workbook.removeSheetAt(index);
        sheetMap.remove(sheet);
    }
    
    public void persistData(int simulationStep) throws IOException {
        for(int i = 0; i < dataSources.size(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            int currentRow = sheetMap.get(sheet);
            int currentColumn = 1;
            Row row = sheet.createRow(currentRow);            
            HashMap dataMap = dataSources.get(i).getData();
            Iterator iterator = dataMap.keySet().iterator();
            
            Cell cell = row.createCell(0);
            cell.setCellValue(simulationStep);
            
            while(iterator.hasNext()) {
                Object key = iterator.next();
                cell = row.createCell(currentColumn);
                Object value = dataMap.get(key);
                
                if(value == null) { cell.setCellValue("null"); }
                else { cell.setCellValue(value.toString()); }
                
                currentColumn++;
            }
            
            currentRow++;
            sheetMap.put(sheet, currentRow);
        }
        
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
    
    // PRIVATE METHODS
    
    private void writeHeader(XSSFSheet sheet, WorldObject object) throws IOException {
        Row row = sheet.createRow(0);
        Iterator iterator = object.getData().keySet().iterator();
        Cell cell = row.createCell(0);
        cell.setCellValue("SimulationStep");
        
        int i = 1;
        while(iterator.hasNext()) {
            Object key = iterator.next();
            cell = row.createCell(i);
            cell.setCellValue(key.toString());
            i++;
        }
        
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
    
    public void reset() {
        this.dataSources = new ArrayList<>();
        sheetMap = new HashMap<>();
        workbook = new XSSFWorkbook();
    }
}
