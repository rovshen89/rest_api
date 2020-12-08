package DataTest;

import Utils.ExcelUtils;

import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        String excelPath = "./dataStorage/Data.xlsx";
        String sheetName = "Sheet1";
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);

        excelUtils.getCellData(1,1);
        excelUtils.getCellData(0,2);
        excelUtils.getCellData(0,1);



    }
}
