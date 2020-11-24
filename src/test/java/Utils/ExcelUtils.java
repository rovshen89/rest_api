package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class ExcelUtils {

    public static void main(String[] args) throws IOException {
        getRowCount();
        getCellData();
    }

    public static void getRowCount() throws IOException {
        String projectDir = System.getProperty("user.dir");
        System.out.println("Project path: " + projectDir);
        
        String excelPath = "./dataStorage/Data.xlsx"; //create system path for excel file;

        XSSFWorkbook workbook = new XSSFWorkbook(excelPath); //create workbook object and define path variable;
        XSSFSheet sheet = workbook.getSheet("Sheet1"); //inside workbook object reach to Sheet1;

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows: " + rowCount);
    }

    public static void getCellData() throws IOException {
        String excelPath = "./dataStorage/Data.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        DataFormatter formatter = new DataFormatter(); //use to format data from cells;

        Object value = formatter.formatCellValue(sheet.getRow(1).getCell(1)); //save data into object variable;

        System.out.println("Cell value: " + value);

        

    }

}
