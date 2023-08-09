package multimediaData;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ImageSentToDB {

	public static void main(String[] args) {
		 try {
			  Scanner sc=new Scanner(System.in);
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			  PreparedStatement ps=con.prepareStatement("insert into BinaryTab51 values(?,?)");
			  System.out.println("Enter id");
			  String id=sc.nextLine();
			  ps.setString(1, id);
			  System.out.println("Enter file/Path");
			  File file=new File(sc.nextLine());//E:\image\img.jpg
			  if(file.exists())
			  {
				  //System.out.println("hi");
				  FileInputStream fis=new FileInputStream(file);
				  ps.setBinaryStream(2, fis,file.length());
				  int k=ps.executeUpdate();
				  if(k>0)
				  {
					  System.out.println("image stored successfully");
					  fis.close();
				  }
			  }else
			  {
				  System.out.println("invalid path");
			  }
			  sc.close();
			   
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}

}
