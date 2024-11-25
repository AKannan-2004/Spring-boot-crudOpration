package ExcelOperations.dup;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dup {
	public static void main(String[] args) throws  SQLException, IOException, ClassNotFoundException  {
		// TODO Auto-generated method stub
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kannan");
		
		FileInputStream f1=new FileInputStream("C:\\Users\\HP\\OneDrive\\Documents\\clg.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheetAt(0);
		Iterator<Row> row=sh.iterator();
		
		String s1="insert into dup (Name,City) values (?,?)";
		PreparedStatement ps=c1.prepareStatement(s1);
        
       row.next(); 
         
        while (row.hasNext()) {
            Row nextRow = row.next();
            Iterator<Cell> cell = nextRow.cellIterator();

            while (cell.hasNext()) {
                Cell nextCell = cell.next();

               
		 int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
//                case 0:
//                	 int Id = (int)nextCell.getNumericCellValue();
//                	 ps.setInt(2, Id);
//                	break;
                case 0:
                	String Name = nextCell.getStringCellValue();
                	ps.setString(1, Name);
                    break;
  
                 case 1:
                		String City = nextCell.getStringCellValue();
                    	ps.setString(1, City);
                        break;
                }
                    

            }
            ps.execute();
            System.out.println("Succcess");
            
        }
		
	}


}
