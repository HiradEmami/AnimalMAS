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
    public static final String OUTPUT_FILE = "SimulationOutput.xlsx";
    
    private ArrayList<WorldObject> dataSources;
    private HashMap<XSSFSheet, Integer> sheetMap;
    private XSSFWorkbook workbook;
    private File file;
    
    public DataRecorder() throws IOException {
        this(null);
    }
    
    public DataRecorder(WorldObject[] dataSources) throws IOException {
        this.dataSources = new ArrayList<>();
        sheetMap = new HashMap<>();
        workbook = new XSSFWorkbook();
                
        if(dataSources != null) {
            for(WorldObject dataSource : dataSources) {
                addDataSource(dataSource);
            }
        }
        
        file = new File(OUTPUT_FILE);
        file.createNewFile();        
    }
    
    public WorldObject[] getDataSources() {
        WorldObject[] type = new WorldObject[dataSources.size()];
        return dataSources.toArray(type);
    }
    
    public void addDataSource(WorldObject dataSource) {
        dataSources.add(dataSource);
        XSSFSheet sheet = workbook.createSheet(dataSource.toString());
        sheetMap.put(sheet, 0);
    }
    
    public void removeDataSource(WorldObject dataSource) {
        int index = dataSources.indexOf(dataSource);
        dataSources.remove(dataSource);
        XSSFSheet sheet = workbook.getSheetAt(index);
        workbook.removeSheetAt(index);
        sheetMap.remove(sheet);
    }
    
    public void persistData() throws IOException {
        for(int i = 0; i < dataSources.size(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            int currentRow = sheetMap.get(sheet);
            int currentColumn = 0;
            Row row = sheet.createRow(currentRow);            
            HashMap dataMap = dataSources.get(i).getData();
            Iterator iterator = dataMap.keySet().iterator();
            
            while(iterator.hasNext()) {
                Object key = iterator.next();
                Cell cell = row.createCell(currentColumn);
                Object value = dataMap.get(key);
                cell.setCellValue(value.toString());
                currentColumn++;
            }
            
            currentRow++;
            sheetMap.put(sheet, currentRow);
        }
        
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
