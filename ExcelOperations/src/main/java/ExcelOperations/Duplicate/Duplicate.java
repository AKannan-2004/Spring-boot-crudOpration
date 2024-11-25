package ExcelOperations.Duplicate;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Duplicate {
	
	
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kannan");
		
		FileInputStream f1=new FileInputStream("C:\\Users\\HP\\OneDrive\\Documents\\StdDet.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheetAt(0);
		//Iterator<Row> row=sh.iterator();
		
		String s1="insert into Excel (Name,Age,sallary) values (?,?,?)";
		String s2="select count(*) from Excel where Name=?";
		
		PreparedStatement ps1=c1.prepareStatement(s1);
		PreparedStatement ps2=c1.prepareStatement(s2);
        
        
      // row.next(); 
       HashSet<String> a=new HashSet<String>();
       
//       while (row.hasNext()) {
//           Row nextRow = row.next();
//           Iterator<Cell> cell = nextRow.cellIterator();

//           while (cell.hasNext()) {
//               Cell nextCell = cell.next();
       
//           }
       
       for(int i= 1; i<=sh.getLastRowNum();i++)
		{
			XSSFRow row = sh.getRow(i);
			
           if (row != null)
           {	
               String Name = row.getCell(0) != null ? row.getCell(0).toString() : null;
               int Age = (int) (row.getCell(1) != null ? row.getCell(1).getNumericCellValue() : 0);
              double sallary = (row.getCell(2) != null ? row.getCell(2).getNumericCellValue() :0);

               // Use HashSet to check for duplicates
               if (a.add(Name)) 
               {
               	ps2.setString(1, Name);
               	
               	ResultSet rs = ps2.executeQuery();
               	
               	if(rs.next() && rs.getInt(1) == 0)
               		// Insert into database if the name is unique
               	{
               		ps1.setString(1, Name);
               		ps1.setInt(2, Age);
               		ps1.setDouble(3, sallary);
               		ps1.executeUpdate();
               		System.out.println("Inserted: " + Name);	
               	}
               	else 
               	{
               		System.out.println("Duplicate entry in database : " + Name);
               	}
               } 
               else
			    {
               	System.out.println("Duplicate entry in HashSet: "+Name );
			 	}
           }
       }
       System.out.println("Data processing complete.");
       
	}
}

   
                       
            	           		   
               
              
            		   
     

