package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testBase.TestBaseClass;

public class util extends TestBaseClass
{
	//public static String filePath = ".\\LoginCredentials.xlsx";
	public static String filePath = "D:\\TestData\\LoginCredentials.xlsx";
	public static File file;
	public static FileInputStream input;
	public static XSSFWorkbook book;
	
	public util() throws IOException 
	{
		super();
	}


	public Object[][] fetchExcelData() throws IOException
	{
		 file = new File(filePath);
		 input = new FileInputStream(file);
		 book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Credentials");
		
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	
	public void SetExcelData(String sheetname,ArrayList<String> list) throws IOException
	{
		file = new File(filePath);
		input = new FileInputStream(file);
		book = new XSSFWorkbook(input);
		
		XSSFSheet sheet = book.getSheet("Credentials");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowcount;i++)
		{
			sheet.getRow(i+1).createCell(colcount).setCellValue(list.get(i));
		}
		

        
        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        book.write(outFile);
        //outFile.close();
	}
	
	
	public void CreateSheetandSetExcelData1(ArrayList<String> list) throws IOException
	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date());
		
		file = new File(filePath);
		input = new FileInputStream(file);
		book = new XSSFWorkbook(input);
		XSSFSheet existingsheet = book.getSheet("Credentials");
		int rowcount = existingsheet.getLastRowNum();
		int colcount = existingsheet.getRow(0).getLastCellNum();
		
		
		XSSFSheet newsheet = book.createSheet(timeStamp);
		newsheet.createRow(0); 
		newsheet.getRow(0).createCell(0).setCellValue("UserName");
		newsheet.getRow(0).createCell(1).setCellValue("Password");
		newsheet.getRow(0).createCell(2).setCellValue("Customer Name");
		
		Object[][] data = fetchExcelData();
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				newsheet.createRow(i+1).createCell(j).setCellValue(data[i][j].toString());
			}
		}
		
		for(int i=0;i<rowcount;i++)
		{
			newsheet.getRow(i+1).createCell(colcount).setCellValue(list.get(i));
		}
		

        
        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        book.write(outFile);
        outFile.close();
		
		
	}
	
	
	public void CreateSheetandSetExcelData(ArrayList<String> list) throws IOException
	{
		Object[][] data = fetchExcelData();
		
		//String[][] stringdata = Arrays.copyOf(data, data.length, String[][].class);
		//Arrays.asList(data).toArray(new Stri)
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date());
		
		file = new File(filePath);
		input = new FileInputStream(file);
		book = new XSSFWorkbook(input);
		XSSFSheet existingsheet = book.getSheet("Credentials");
		int rowcount = existingsheet.getLastRowNum();
		int colcount = existingsheet.getRow(0).getLastCellNum();
		CellStyle headercellstyle = existingsheet.getRow(0).getCell(0).getCellStyle();
		CellStyle bodycellstyle = existingsheet.getRow(1).getCell(0).getCellStyle();
		
		
		
		
		/*System.out.println("Row - "+rowcount);
		System.out.println("Columns - "+colcount);*/
		
		
		
	
		book.cloneSheet(0); 
		book.setSheetName(book.getSheetIndex("Credentials (2)"), timeStamp);
		XSSFSheet newsheet = book.getSheet(timeStamp);
		
		/*newsheet.createRow(0); 
		newsheet.getRow(0).createCell(0).setCellValue("UserName");
		newsheet.getRow(0).createCell(1).setCellValue("Password");*/
		newsheet.getRow(0).createCell(2).setCellValue("Customer Name");
		newsheet.getRow(0).getCell(2).setCellStyle(headercellstyle);
	
		
		/*for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				newsheet.createRow(i+1).createCell(j).setCellValue((data[i][j]).toString());
				System.out.println(data[i][j]);
			}
		}*/
		
		
		for(int i=0;i<rowcount;i++)
		{
			newsheet.getRow(i+1).createCell(colcount).setCellValue(list.get(i));
			newsheet.getRow(i+1).getCell(colcount).setCellStyle(bodycellstyle);
		}
		
		 FileOutputStream outFile = new FileOutputStream(new File(filePath));
	        book.write(outFile);
	        outFile.close();
	}
	
}
