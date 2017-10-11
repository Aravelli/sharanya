
package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil 
{
	
	Workbook wb;
	
	// It will load all the excel sheet & it will instantiate that particular workbook
	
	public ExcelFileUtil() throws Exception
	{
		FileInputStream fis = new FileInputStream("./TestInputs/InputSheet.xlsx");
		
		wb = WorkbookFactory.create(fis);
	}
	
	
	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
	
	
	public String getData(String sheetname, int row, int column)
	{
		String data = null;
		
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_STRING)
		{
			
			data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		
		else
		{
			int celldata =(int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			
			data = String.valueOf(celldata);
		}
		
		return data;
	}
	
	
	
	
	
	public void setData(String sheetname, int row, int column, String str) throws Exception
	{
		Sheet sh = wb.getSheet(sheetname);
		
		Row rownum = sh.getRow(row);
		
		Cell cell = rownum.createCell(column);
		
		cell.setCellValue(str);
		
		FileOutputStream fos = new FileOutputStream("./TestOutput/OutputSheet.xlsx");
		
		wb.write(fos);
		
		fos.close();
		
	}	
}



