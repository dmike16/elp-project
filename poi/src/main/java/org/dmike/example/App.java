package org.dmike.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException, XmlException, OpenXML4JException {
		String excel_format = "xls";
		if (args.length > 0) {
			excel_format = args[0];
		}

		switch (excel_format) {
		case "xls":
			xlsMaker("prova.xls");
			break;
		case "xlsx":
			xlsxMaker("prova.xlsx");
			break;
		case "xlsxEX":
			xlsxFSExetractor("prova.xlsx");
			break;
		case "xlsEX":
			xlsFSExetractor("prova.xls");
			break;
		default:
			System.exit(1);
		}
	}

	private static void xlsxFSExetractor(String name) throws IOException, XmlException, OpenXML4JException {
		try(XSSFExcelExtractor ext = 
				new XSSFExcelExtractor(OPCPackage.openOrCreate(new File(name)))){
			
			System.out.println("[INFO]" + ext.getText());
		}
	}
	
	private static void xlsFSExetractor(String name) throws IOException, InvalidFormatException {
		try(ExcelExtractor ext = new ExcelExtractor(new POIFSFileSystem(new File(name)))){
			System.out.println("[INFO]" + ext.getText());
			
		}
	}

	private static void xlsMaker(String nome_file) throws IOException {
		Workbook hwb = new HSSFWorkbook();
		commonOperation(hwb);

		writeToFile(nome_file, hwb);
	}

	private static void xlsxMaker(String nome_file) throws IOException {
		Workbook xwb = new XSSFWorkbook();
		commonOperation(xwb);

		writeToFile(nome_file, xwb);
	}

	private static void commonOperation(Workbook w) {
		CreationHelper helper = w.getCreationHelper();
		String sheet_name1 = WorkbookUtil.createSafeSheetName("Foglio 1?");
		String sheet_name2 = WorkbookUtil.createSafeSheetName("Foglio 2");
		String sheet_name3 = WorkbookUtil.createSafeSheetName("Foglio 3");
		Sheet sheet1 = w.createSheet(sheet_name1);
		Sheet sheet2 = w.createSheet(sheet_name2);
		Sheet sheet3 = w.createSheet(sheet_name3);
		// Foglio Uno
		w.setPrintArea(0, "$A$1:$C$2");
		sheet1.setZoom(75);
		PrintSetup ps = sheet1.getPrintSetup();
		sheet1.setAutobreaks(true);
		ps.setFitHeight((short)1);
		ps.setFitWidth((short)1);
		CellStyle cs = w.createCellStyle();
		Row row = sheet1.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(1);

		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(helper.createRichTextString("RichText"));
		row.createCell(3).setCellValue(true);

		row = sheet1.createRow(2);
		row.createCell(0).setCellValue(false);
		row.createCell(1).setCellValue(1.1);
		row.createCell(2).setCellValue(Calendar.getInstance());
		row.createCell(3).setCellValue(new Date());
		row.createCell(4).setCellValue(" a string");
		row.createCell(5).setCellType(CellType.ERROR);
		
		cell = row.createCell(6);
		cell.setCellValue("Hello \n Work");
		cs.setWrapText(true);
		cell.setCellStyle(cs);
		
		row.setHeight((short) (sheet1.getDefaultRowHeight()*2));
		sheet1.autoSizeColumn(6);
		// Foglio Due
		Row row1 = sheet2.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(new Date());

		CellStyle cell_style = w.createCellStyle();
		cell_style.setDataFormat(helper.createDataFormat().getFormat("dd/MM/yyyy"));
		cell1 = row1.createCell(1);
		cell1.setCellValue(new Date());
		cell1.setCellStyle(cell_style);

		cell1 = row1.createCell(2);
		cell1.setCellValue(Calendar.getInstance());
		cell1.setCellStyle(cell_style);
		
		row1 = sheet2.createRow(2);
		cell1 = row1.createCell(1);
		cell1.setCellValue("This a test of merge");
		
		sheet2.addMergedRegion(new CellRangeAddress(
				2,
				2,
				1,
				2));
		//Foglio tre
		Header header = sheet3.getHeader();
		header.setCenter("Center");
		header.setLeft("Left");
		
		sheet3.createSplitPane(2000, 2000, 0, 0, Sheet.PANE_LOWER_LEFT);
	}

	private static void writeToFile(String name, Workbook wk) throws IOException {
		try (FileOutputStream out = new FileOutputStream(name)) {
			wk.write(out);
		}
	}
}
