package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Sql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int	m1[]=new int[3];
		int	m2[]=new int[3];
		int	m3[]=new int[3];
		int	m4[]=new int[3];
		int	m5[]=new int[3];
		int	m6[]=new int[3];
		String usn="1CN16IS027";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
			
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from results where sid='"+usn+"' order by internal");
			
	while(rs.next()){
		m1[i]=rs.getInt(3);
		m2[i]=rs.getInt(4);
		m3[i]=rs.getInt(5);
		m4[i]=rs.getInt(6);
		m5[i]=rs.getInt(7);
		m6[i]=rs.getInt(8);
		i++;
		}
		
			Arrays.sort(m1);
			Arrays.sort(m2);
			Arrays.sort(m3);
			Arrays.sort(m4);
			Arrays.sort(m5);
			Arrays.sort(m6);
			con.close();
			stmt.close();
			rs.close();
			
		
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
	int i1=login.valueA(m1[1], m1[2]);
	int i2=login.valueA(m2[1], m2[2]);
	int i3=login.valueA(m3[1], m3[2]);
	int i4=login.valueA(m4[1], m4[2]);
	int i5=login.valueA(m5[1], m5[2]);
	int i6=login.valueA(m6[1], m6[2]);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
		
		Statement stm=conn.createStatement();
	stm.executeQuery("insert into avgmark"+" values('"+
						usn+"',"
						+i1+","
						+i2+","
						+i3+","
						+14+","
						+i5+","
						+i6+") ");
	stm.executeQuery("commit");
			stm.close();
	conn.close();
	} catch(SQLException se){ 
	      //Handle errors for JDBC 
	      se.printStackTrace(); 
	   }catch(Exception er){ 
	      //Handle errors for Class.forName 
	      er.printStackTrace(); 
	   }
	

	}}
