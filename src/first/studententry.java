package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studententry
 */
@WebServlet("/studententry")
public class studententry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studententry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String email=null;
		 email=request.getParameter("email");
		email=email.toUpperCase();
		pw.print("<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"table{\r\n" + 
				"border-collapse:collapse;\r\n"
				+ "width:100%"
				+ "th,td{text-align:left;padding:8px;}"
				+ "tr:nth-child(even){background-color:#f2f2f2;}" + 
				"bgcolor=#eebb99;\r\n" + 
				"}</style>\r\n" + 
				"</head>\r\n" + 
				"<body bgcolor=#fffacd>\r\n" + 
				"<div style=\"font-family:Times New Roman; color:blue;font-size:75px;background:grey;width:1500px;text-align:center;\">\r\n" + 
				"<font color=red>CNS</font> INSTITUTE OF TECHNOLOGY\r\n" + 
				"<font size=5 color=\"black\"><center>(AICTE Approved,VTU Affiliated and NAAC 'A' Accredited)</font></div> \r\n");
		
		if(!login.value11(email)) {
			if(!login.value(email)) {
				String sid=request.getParameter("sid");
				sid=sid.toUpperCase();
				String name=request.getParameter("name");
				name=name.toUpperCase();
				String gender=request.getParameter("gender");
				String sem=request.getParameter("sem");
				String sec=request.getParameter("sec");
				String city=request.getParameter("city");
				city=city.toUpperCase();
				String phone=request.getParameter("phone");
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
					
					Statement stmt=con.createStatement();

					stmt.executeQuery("insert into login"+" values('"+email+"','CNS123') ");
					stmt.executeQuery("commit");
				
					stmt.close();
					con.close();
				} catch(SQLException se){ 
				      //Handle errors for JDBC 
				      se.printStackTrace(); 
				   }catch(Exception er){ 
				      //Handle errors for Class.forName 
				      er.printStackTrace(); 
				   }
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");

						Connection conn=DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
						
						Statement stm=conn.createStatement();
					stm.executeQuery("insert into students"+" values('"+
										sid+"','"
										+name+"','"
										+gender+"',"
										+sem+",'"
										+sec+"',"
										+phone+",'"
										+city+"','"
										+email+"') ");
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
					
				
					pw.print("<center><h1>Student is Succesfully Entered </h2><br>"
							+ "<h2>The Default Password is <font color=red>CNS123</font></h2></center>");
			
				
					pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
							"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
							"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
							"</div>");
				
				
				
			}else {
				pw.print("<h1><center><b>Email Id is Already Used to Login<br>"
						+ "<font color=red>Try using another Email ID </h1> ");
				
				pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
						"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
						"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
						"</div>");
			
			}
		}else {
			
			pw.print("<h1><center><b>This Student is Already in Student<br></h1>"
					+ "<h2><center><font color=blue>If this is not the Student </font></h2> "
					+ "<h3><center><font color=red>Use Another Email Id and USN</font></h3>");
			String usn=login.valueS(email);
			usn=usn.toUpperCase();
			try
			{
				String name=null,gender=null,sec=null,address=null;
				long sem=00,phone=00;
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from STUDENTS where sid='"+usn+"'");
				while(rs.next()) {
					name=rs.getString(2);
					gender=rs.getString(3);
					sem=rs.getInt(4);
					sec=rs.getString(5);
					phone=rs.getLong(6);
					address=rs.getString(7);	
					
				}
				
			pw.print("<html>\r\n" + 
					"<head>\r\n" + 
					"<style>\r\n" + 
					"table,th,td{\r\n" + 
					"border:15px solid white;}</style>\r\n" + 
					"</head>"
					+ "<center> <table width=1000>\r\n" + 
					"<tr>\r\n" + 
					"<td><b>USN =   </td>\r\n" + 
					"<td><b>"+usn+"</td>\r\n" + 
					"<td><b>NAME =  </td>\r\n" + 
					"<td><b>"+name+"</td>\r\n" + 
					"</tr>\r\n" + 
					" <tr>\r\n" + 
					"<td><b>Gender =   </td>\r\n" + 
					"<td><b>"+gender+"</td>\r\n" + 
					"<td><b>SEM =  </td>\r\n" + 
					"<td><b>"+sem+"</td>\r\n" + 
					"</tr> \r\n" + 
					"<tr>\r\n" + 
					"<td><b>SEC =   </td>\r\n" + 
					"<td><b>"+sec+"</td>\r\n" + 
					"<td><b>Phone =  </td>\r\n" + 
					"<td><b>"+phone+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td><b>Address =   </td>\r\n" + 
					"<td><b>"+address+"</td>\r\n" + 
					"<td><b>Email Id =  </td>\r\n" + 
					"<td><b>"+email+"</td>\r\n" + 
					"</tr>\r\n" + 
					"</table></html>");	
			pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
					"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
					"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
					"</div>");
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
		}
			
		}	
	}


