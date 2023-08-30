package TestUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtilsQA {
	
	@DataProvider(name="TestData")
	public Object[][] testData() throws IOException {
		String filePath = "src\\main\\resources\\TestData\\TestdataQA.xlsx";
        String sheetName = "Sheet1";

        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][columnCount];
        

         for (int i = 1; i < rowCount; i++) {
           Row row = sheet.getRow(i);
          for (int j = 0; j < columnCount; j++) {
              Cell cell = row.getCell(j);
              data[i - 1][j] = cell.toString();
            }
       }

        workbook.close();
        inputStream.close();

        return data;
	}
}
