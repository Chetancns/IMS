package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;

public class login {

	
		public static boolean value(String e ) {
			
		boolean status=false;
		
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
			
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from login where email='"+e+"'");

		status=rs.next();
		rs.close();
		stmt.close();
		con.close();
		
		
	} catch(SQLException se){ 
	      //Handle errors for JDBC 
	      se.printStackTrace(); 
	   }catch(Exception er){ 
	      //Handle errors for Class.forName 
	      er.printStackTrace(); 
	   }
		return status;
	}
		public static boolean value1(String e) {
			boolean FF=false;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();


				ResultSet rs=stmt.executeQuery("select * from teacher where email='"+e+"'");

			FF=rs.next();
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
			return FF;
		}
		public static boolean value11(String e ) {
			boolean F=false;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();

				ResultSet rs=stmt.executeQuery("select * from students where email='"+e+"'");

			F=rs.next();
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
			return F;
		}
		public static String valueS(String e) {
			String FF=null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();

				ResultSet rs=stmt.executeQuery("select * from students where email='"+e+"'");

			rs.next();
			FF=rs.getString(1);
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
			return FF;
		}
		public static String valueT(String e) {
			String FF=null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();

				ResultSet rs=stmt.executeQuery("select * from teacher where email='"+e+"'");

			rs.next();
			FF=rs.getString(1);
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
			return FF;
		}
	
public static boolean valuelo(String e) {
	boolean FF=false;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from login where email='"+e+"'");

	FF=rs.next();
	rs.close();
	stmt.close();
	con.close();
	
	
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return FF;
}

public static String valueP(String e) {
	String FF=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select password from login where email='"+e+"'");

	rs.next();
	FF=rs.getString(1);
	rs.close();
	stmt.close();
	con.close();
	
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return FF;
}
public static boolean valueC(String e,String i ) {
	
	boolean FF=false;
	
	// TODO Auto-generated method stub
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from results where sid='"+e+"' and internal="+i+"");

		FF=rs.next();
		rs.close();
		stmt.close();
		con.close();
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return FF;
}
public static boolean valueSS(String e ) {
	boolean F=false;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from students where sid='"+e+"'");

	F=rs.next();
	rs.close();
	stmt.close();
	con.close();
	
	
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return F;
}
public static boolean value1P(String e) {
	boolean FF=false;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();


		ResultSet rs=stmt.executeQuery("select * from Parents where email='"+e+"'");

	FF=rs.next();
	rs.close();
	stmt.close();
	con.close();
	
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return FF;
}
public static boolean valuePP(String e,String i ) {
	
	boolean FF=false;
	
	// TODO Auto-generated method stub
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from parents where email='"+e+"' and sid='"+i+"'");

		FF=rs.next();
		rs.close();
		stmt.close();
		con.close();
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return FF;
}
public static int valueA(int m,int n) {
	int FF=0;
	FF=(((m+n)*20)/90);
	return FF;
}
public static boolean valueAP(String e ) {
	boolean F=false;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from avgmark where sid='"+e+"'");

	F=rs.next();
	rs.close();
	stmt.close();
	con.close();
	
	
} catch(SQLException se){ 
      //Handle errors for JDBC 
      se.printStackTrace(); 
   }catch(Exception er){ 
      //Handle errors for Class.forName 
      er.printStackTrace(); 
   }
	return F;
}
}