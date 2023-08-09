package multimediaData;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrievedDataFromDB {

	public static void main(String[] args) {
		try {
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
		PreparedStatement ps=con.prepareStatement("select * from binarytab51 where id=?");
		System.out.println("Enter id");
		String id=sc.nextLine();
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			Blob b=rs.getBlob(2);
			byte by[]=b.getBytes(1,(int)b.length());
			System.out.println("Enter file path/location");//E:\dbimage\img.jpg
			File f=new File(sc.nextLine());
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(by);
			System.out.println("file retrieved successfully");
			fos.close();
		}
		else
		{
			System.out.println("invalid id");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	  
	}

}
