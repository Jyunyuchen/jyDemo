package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping("/getfile")
	public ResponseEntity<byte[]> exportFile() throws IOException{
		//File file = new File("C:\\Users\\jy\\Desktop\\invoices.xlsx");
		
		//Create workbook in .xlsx format
		Workbook workbook = new XSSFWorkbook();
		//For .xsl workbooks use new HSSFWorkbook();
		//Create Sheet
		Sheet sh = workbook.createSheet("Invoices");
		//Create top row with column headings
		String[] columnHeadings = {"Item id","Item Name","Qty","Item Price","Sold Date"};
		//We want to make it bold with a foreground color.
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)12);
		headerFont.setColor(IndexedColors.BLACK.index);
		//Create a CellStyle with the font
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFont(headerFont);
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		//Create the header row
		Row headerRow = sh.createRow(0);
		//Iterate over the column headings to create columns
		for(int i=0;i<columnHeadings.length;i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnHeadings[i]);
			cell.setCellStyle(headerStyle);
		}
		//Freeze Header Row
		sh.createFreezePane(0, 1);
		
		
		/* HttpHeaders headers = new HttpHeaders();
		   // headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		    headers.add("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
//		    headers.add("Pragma", "no-cache");
//		    headers.add("Expires", "0");
//		    headers.add("Last-Modified", new Date().toString());
//		    headers.add("ETag", String.valueOf(System.currentTimeMillis()));

		    return ResponseEntity
		    		.ok() 
		    		.headers(headers) 
		    		.contentLength(file.length()) 
		    		.contentType(MediaType.parseMediaType("application/octet-stream")) 
		    		.body(new FileSystemResource(file));*/
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", "test.xls");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		workbook.write(byteArrayOutputStream);
		
		return  new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
		
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
}
