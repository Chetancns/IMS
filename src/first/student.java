package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student
 */
@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student() {
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
		String email=request.getParameter("email");
		email=email.toUpperCase();
		String usn=login.valueS(email);
		RequestDispatcher rd=request.getRequestDispatcher("studentdetails")  ;
		rd.include(request, response);
		try
		{
			String sub1=null,sub2=null,sub3=null,sub4=null,sub5=null,sub6=null;
			boolean a=false,b=false,c=false;
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
			
			Statement stmt=con.createStatement();
			try {
				ResultSet ps=stmt.executeQuery("select sa.* from students s,subjects sa where sid='"+usn+"' and s.sem=sa.sem ");
				ps.next();
				sub1=ps.getString(2);
				sub2=ps.getString(3);
				sub3=ps.getString(4);
				sub4=ps.getString(5);
				sub5=ps.getString(6);
				sub6=ps.getString(7);
				ps.close();
			}catch(Exception e) {}

			try {
			ResultSet rs=stmt.executeQuery("select * from results where sid='"+usn+"' order by internal");
			
			
			
			
			
		while(rs.next()) {
			if(1==rs.getInt(2)) {
				a=true;
			pw.print("<center><table style=\"display:inline-block\" border=\"4\" bordercolor=\"blue\">\r\n" + 
					"<col width=\"100\">\r\n" + 
					"<col width=\"100\"><col width=\"100\">\r\n" + 
					"<col width=\"100\">"
					+ "<tr>\r\n" + 
					"<td height=\"30\" colspan=\"2\"><b><center>INTERNAL</td>\r\n" + 
					"<td colspan=\"2\"><center>"+rs.getInt(2)+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=\"30\"><b>Subjects</td>\r\n" + 
					"<td><b>Max Marks</td>\r\n" + 
					"<td><b>Min Marks</td>\r\n" + 
					"<td><b>obtained Marks</td>\r\n" + 
					"<tr>\r\n" + 
					"<td height=\"30\"><b>"+sub1+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(3)+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=\"30\"><b>"+sub2+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(4)+"</td>\r\n" + 
					"</tr><tr>\r\n" + 
					"<td height=\"30\"><b>"+sub3+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(5)+"</td>\r\n" + 
					"</tr><tr>\r\n" + 
					"<td height=\"30\"><b>"+sub4+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(6)+"</td>\r\n" + 
					"</tr><tr>\r\n" + 
					"<td height=\"30\"><b>"+sub5+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(7)+"</td>\r\n" + 
					"</tr><tr>\r\n" + 
					"<td height=\"30\"><b>"+sub6+"</td>\r\n" + 
					"<td>45</td>\r\n" + 
					"<td>21</td>\r\n" + 
					"<td><font color=red><center>"+rs.getInt(8)+"</td>\r\n" + 
					"</tr>\r\n" + 
					"</table>\r\n");
			}
			if(2==rs.getInt(2)) {
				b=true;
				pw.print("<table style=\"display:inline-block\" border=\"4\" bordercolor=\"blue\">\r\n" + 
						"<col width=\"100\">\r\n" + 
						"<col width=\"100\"><col width=\"100\">\r\n" + 
						"<col width=\"100\">"
						+ "<tr>\r\n" + 
						"<td height=\"30\" colspan=\"2\"><b><center>INTERNAL</td>\r\n" + 
						"<td colspan=\"2\"><center>"+rs.getInt(2)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>Subjects</td>\r\n" + 
						"<td><b>Max Marks</td>\r\n" + 
						"<td><b>Min Marks</td>\r\n" + 
						"<td><b>obtained Marks</td>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>"+sub1+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(3)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>"+sub2+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(4)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub3+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(5)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub4+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(6)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub5+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(7)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub6+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(8)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"</table>\r\n");
				}
			if(3==rs.getInt(2)) {
				c=true;
				pw.print("<table style=\"display:inline-block\" border=\"4\" bordercolor=\"blue\">\r\n" + 
						"<col width=\"100\">\r\n" + 
						"<col width=\"100\"><col width=\"100\">\r\n" + 
						"<col width=\"100\">"
						+ "<tr>\r\n" + 
						"<td height=\"30\" colspan=\"2\"><b><center>INTERNAL</td>\r\n" + 
						"<td colspan=\"2\"><center>"+rs.getInt(2)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>Subjects</td>\r\n" + 
						"<td><b>Max Marks</td>\r\n" + 
						"<td><b>Min Marks</td>\r\n" + 
						"<td><b>obtained Marks</td>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>"+sub1+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(3)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"<tr>\r\n" + 
						"<td height=\"30\"><b>"+sub2+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(4)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub3+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(5)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub4+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(6)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub5+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(7)+"</td>\r\n" + 
						"</tr><tr>\r\n" + 
						"<td height=\"30\"><b>"+sub6+"</td>\r\n" + 
						"<td>45</td>\r\n" + 
						"<td>21</td>\r\n" + 
						"<td><font color=red><center>"+rs.getInt(8)+"</td>\r\n" + 
						"</tr>\r\n" + 
						"</table>\r\n");
				}
			
			
		}}catch(Exception e) {}
			if(a==true && b==true && c==true) {
			pw.print("<center><h1>Your Final Average Internal Marks</center></h1>");
				Average.value(usn);
				try {
					ResultSet rs=stmt.executeQuery("select * from avgmark where sid='"+usn+"'");
				while(rs.next()) {
				pw.print("<center><table style=\"display:inline-block\" border=\"4\" bordercolor=\"blue\">\r\n" + 
							"<col width=\"100\">\r\n" + 
							"<col width=\"100\"><col width=\"100\">\r\n" + 
							"<col width=\"100\">"
							+"<tr>\r\n" + 
							"<td height=\"30\"><b>Subjects</td>\r\n" + 
							"<td><b>Max Marks</td>\r\n" + 
							"<td><b>Min Marks</td>\r\n" + 
							"<td><b>obtained Marks</td>\r\n" + 
							"<tr>\r\n" + 
							"<td height=\"30\"><b>"+sub1+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(2)+"</td>\r\n" + 
							"</tr>\r\n" + 
							"<tr>\r\n" + 
							"<td height=\"30\"><b>"+sub2+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(3)+"</td>\r\n" + 
							"</tr><tr>\r\n" + 
							"<td height=\"30\"><b>"+sub3+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(4)+"</td>\r\n" + 
							"</tr><tr>\r\n" + 
							"<td height=\"30\"><b>"+sub4+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(5)+"</td>\r\n" + 
							"</tr><tr>\r\n" + 
							"<td height=\"30\"><b>"+sub5+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(6)+"</td>\r\n" + 
							"</tr><tr>\r\n" + 
							"<td height=\"30\"><b>"+sub6+"</td>\r\n" + 
							"<td>20</td>\r\n" + 
							"<td>12</td>\r\n" + 
							"<td><font color=red><center>"+rs.getInt(7)+"</td>\r\n" + 
							"</tr>\r\n" + 
							"</table>\r\n");
					}
				
			} catch(SQLException se){ 
			      //Handle errors for JDBC 
			      se.printStackTrace(); 
			   }catch(Exception er){ 
			      //Handle errors for Class.forName 
			      er.printStackTrace(); 
			   }
		pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
				"<center>@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
				"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
				"</div>");
			
			stmt.close();
			con.close();
			} }catch(SQLException se){ 
	      //Handle errors for JDBC 
	      se.printStackTrace(); 
	   }catch(Exception er){ 
	      //Handle errors for Class.forName 
	      er.printStackTrace(); 
	   }
		
		
	}
		}
		

