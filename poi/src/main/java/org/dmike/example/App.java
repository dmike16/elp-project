package org.dmike.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.ShapeTypes;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
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
		String sheet_name4 = WorkbookUtil.createSafeSheetName("Shape");
		String sheet_name5 = WorkbookUtil.createSafeSheetName("validation");
		
		Sheet sheet1 = w.createSheet(sheet_name1);
		Sheet sheet2 = w.createSheet(sheet_name2);
		Sheet sheet3 = w.createSheet(sheet_name3);
		Sheet sheet4 = w.createSheet(sheet_name4);
		Sheet sheet5 = w.createSheet(sheet_name5);
		
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
		cell.setCellValue("111111111");
		sheet1.setColumnWidth(cell.getColumnIndex(),8*256);
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
		
		row = sheet1.createRow(4);
		cell = row.createCell(1);
		cell.setCellValue("Test of merging");
		CellRangeAddress region = CellRangeAddress.valueOf("B5:E6");
		sheet1.addMergedRegion(region);
		final short borderMediumDashed = BorderStyle.MEDIUM_DASHED.getCode();
		RegionUtil.setBorderBottom(borderMediumDashed, region, sheet1);
		RegionUtil.setBottomBorderColor(IndexedColors.AQUA.getIndex(), region, sheet1);
		
		row = sheet1.createRow(5);
		cell = row.createCell(5);
		cell.setCellValue("F4");
		Drawing draw = sheet1.createDrawingPatriarch();
		ClientAnchor ac = helper.createClientAnchor();
		ac.setCol1(cell.getColumnIndex());
		ac.setCol2(cell.getColumnIndex()+1);
		ac.setRow1(row.getRowNum());
		ac.setRow2(row.getRowNum()+3);
		Comment comment = draw.createCellComment(ac);
		comment.setString(helper.createRichTextString("Hello,boys"));
		comment.setAuthor("dmike POI");
		
		cell.setCellComment(comment);
		
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
		sheet2.groupRow(5, 14);
		sheet2.groupRow(7, 14);
		sheet2.groupRow(16, 19);
		
		sheet2.groupColumn(4, 7);
		sheet2.groupColumn(9, 12);
		sheet2.groupColumn(10, 11);
		//Foglio tre
		Header header = sheet3.getHeader();
		header.setCenter("Center");
		header.setLeft("Left");
		
		sheet3.createSplitPane(2000, 2000, 0, 0, Sheet.PANE_LOWER_LEFT);
		
		Drawing patriarch = sheet4.createDrawingPatriarch();

		if(w instanceof HSSFWorkbook){
			//Foglio quattro
			HSSFClientAnchor a = new HSSFClientAnchor(100,0,800,255,(short)1,0,(short)1,0);
			HSSFPatriarch hsffpatriarch = (HSSFPatriarch)patriarch;
			hsffpatriarch.createSimpleShape(a).
			setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			a = new HSSFClientAnchor(0,0,1023,255,(short)1,1,(short)2,2);
			hsffpatriarch.createTextbox(a).setString(new HSSFRichTextString("This a test"));
			//Foglio cinque
			DVConstraint constr = DVConstraint.createExplicitListConstraint(
					new String[]{"10","20","30"});
			CellRangeAddressList address = new CellRangeAddressList(0,0,0,0);
			DataValidation data_v = new HSSFDataValidation(address,constr);
			data_v.setSuppressDropDownArrow(true);
			data_v.setErrorStyle(DataValidation.ErrorStyle.STOP);
			data_v.createErrorBox("Error Box", "Attento");
			data_v.createPromptBox("Prompt Box", "Message Text");
			data_v.setShowPromptBox(true);
			sheet5.addValidationData(data_v);
		}else{
			XSSFClientAnchor a = new XSSFClientAnchor();
			a.setCol1(1);
			a.setRow1(1);
			a.setCol2(2);
			a.setRow2(1);
			a.setDx1(0);
			a.setDy2(100000);
			XSSFDrawing xssfpatriarch = (XSSFDrawing)patriarch;
			XSSFSimpleShape shape = (xssfpatriarch).createSimpleShape(a);
			shape.setShapeType(ShapeTypes.LINE);
			shape.setLineWidth(1.5);
			shape.setLineStyleColor(0,0,255);
			a = new XSSFClientAnchor(100,0,1023,255,2,2,5,5);
			XSSFSimpleShape text = xssfpatriarch.createTextbox(a);
			text.setShapeType(ShapeTypes.RECT);
			text.setFillColor(255, 255, 255);
			text.setText("BElla");
			
			//Folgio cinque
			XSSFDataValidationHelper dv_helper = new XSSFDataValidationHelper((XSSFSheet)sheet5);
			XSSFDataValidationConstraint constr = (XSSFDataValidationConstraint)
					dv_helper.createExplicitListConstraint(new String[]{"10","20","30"});
			CellRangeAddressList address = new CellRangeAddressList(0,0,0,0);
			XSSFDataValidation valide = (XSSFDataValidation)dv_helper.createValidation(constr, address);
			//valide.setSuppressDropDownArrow(false);
			valide.setShowErrorBox(true);
			valide.setErrorStyle(DataValidation.ErrorStyle.STOP);
			valide.createErrorBox("Error Box", "Text error");
			valide.createPromptBox("Prompt Box", "Text message");
			valide.setShowPromptBox(true);
			sheet5.addValidationData(valide);
			
		}
		
	}

	private static void writeToFile(String name, Workbook wk) throws IOException {
		try (FileOutputStream out = new FileOutputStream(name)) {
			wk.write(out);
		}
	}
}
