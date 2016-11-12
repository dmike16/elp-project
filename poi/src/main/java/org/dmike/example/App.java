package org.dmike.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String excel_format = "xls";
    	if(args.length > 0){
    		excel_format = args[0];
    	}
        if("xls".equals(excel_format)){
        	xlsMaker("prova.xls");
        }else{
        	xlsxMaker("prova.xlsx");
        }
    }
    
    private static void xlsMaker(String nome_file) throws IOException{
    	Workbook hwb = new HSSFWorkbook();
    	String sheet_name1 = WorkbookUtil.createSafeSheetName("Foglio 1?");
    	String sheet_name2 = WorkbookUtil.createSafeSheetName("Foglio 2");
    	
    	Sheet sheet1 = hwb.createSheet(sheet_name1);
    	Sheet sheet2 =  hwb.createSheet(sheet_name2);
    	
    	writeToFile(nome_file,hwb);
    }
    
    private static void xlsxMaker(String nome_file) throws IOException{
    	Workbook xwb = new XSSFWorkbook();
    	String sheet_name1 = WorkbookUtil.createSafeSheetName("Foglio 1?");
    	String sheet_name2 = WorkbookUtil.createSafeSheetName("Foglio 2");
    	
    	Sheet sheet1 = xwb.createSheet(sheet_name1);
    	Sheet sheet2 =  xwb.createSheet(sheet_name2);
    	
    	writeToFile(nome_file,xwb);
    }
    
    private static void writeToFile(String name,Workbook wk) throws IOException{
    	try(FileOutputStream out = new FileOutputStream(name)){
    		wk.write(out);
    	}
    }
}
