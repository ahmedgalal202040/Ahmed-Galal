import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReaderReg2{

    static FileInputStream fis = null ;

    public FileInputStream getFileInputStream()
    {
        String filePath = System.getProperty("user.dir")+"/src/test/java/InvalidDataReg.xlsx";
        File srcFile = new File(filePath);

        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
            System.exit(0);
        }
        return fis ;
    }

    public Object[][] getExcelData() throws IOException
    {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet1.getLastRowNum()+1);
        int TotalNumberOfCols = 6;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ;

        for (int i = 0; i < TotalNumberOfRows; i++)
        {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet1.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }
}
