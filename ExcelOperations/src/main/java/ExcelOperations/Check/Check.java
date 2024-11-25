package ExcelOperations.Check;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Check {
	
	
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
		String s3="update Excel set Age=?,sallary=? where Name=?";
		
		PreparedStatement ps1=c1.prepareStatement(s1);
		PreparedStatement ps2=c1.prepareStatement(s2);
		PreparedStatement ps3=c1.prepareStatement(s3);
        
		
		
		 
	       for(int i= 1; i<=sh.getLastRowNum();i++)
			{
				XSSFRow row = sh.getRow(i);
				
	           if (row != null)
	           {	
	               String Name = row.getCell(0) != null ? row.getCell(0).toString() : null;
	               int Age = (int) (row.getCell(1) != null ? row.getCell(1).getNumericCellValue() : 0);
	              double sallary = (row.getCell(2) != null ? row.getCell(2).getNumericCellValue() :0);

	               // Use HashSet to check for duplicates
	             
	               	ps2.setString(1, Name);
	               	
	               	ResultSet rs = ps2.executeQuery();
	               	
	               	if(rs.next() && rs.getInt(1) > 0)
	               		// Insert into database if the name is unique
	               	{
	               		
	               		ps3.setInt(1, Age);
	               		ps3.setDouble(2, sallary);
	               		ps3.setString(3, Name);
	               		ps3.executeUpdate();
	               		System.out.println("Inserted: " + Name);
	               		System.out.println("update: " + Name);
	               	}
	               	else 
	               	{
	               		ps1.setString(1, Name);
	               		ps1.setInt(2, Age);
	               		ps1.setDouble(3, sallary);
	               		ps1.executeUpdate();
	               		System.out.println("Duplicate entry in database : " + Name);
	               	}
	                
	               
	          
	           }
			}
	       
		}

}
