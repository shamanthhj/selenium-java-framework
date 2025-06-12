package Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static Object[][] getTestData(String filePath, String sheetName){
		Object[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			data = new Object[rowCount - 1][colCount];
			
			for(int i = 1; i < rowCount; i++)
			{
				Row row = sheet.getRow(i);
				for(int j = 0; j< colCount; j++) {
					data[i-1][j] = row.getCell(j).toString();
				}
				
			}
			wb.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
