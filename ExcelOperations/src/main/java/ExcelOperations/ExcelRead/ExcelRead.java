package ExcelOperations.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f1 = new File("C:\\Users\\HP\\OneDrive\\Documents\\StdDet.xlsx");
		FileInputStream fs = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheetAt(0);
		
		
		
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			for (int j = 0; j <= row.getLastCellNum() - 1; j++) {
				XSSFCell cell = row.getCell(j);
//				System.out.println(cell);
				
				
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				default:
					break;

				}
				 System.out.print(" | ");
			}
			System.out.println();
		}

	}

}
