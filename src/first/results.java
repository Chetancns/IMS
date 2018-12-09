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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class results
 */
@WebServlet("/results")
public class results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public results() {
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
		String sub1=null,sub2=null,sub3=null,sub4=null,sub5=null,sub6=null;
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String sem=request.getParameter("sem");
		
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
		
	
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();
				
					ResultSet ps=stmt.executeQuery("select * from subjects  where sem="+sem+"");
					ps.next();
					sub1=ps.getString(2);
					sub2=ps.getString(3);
					sub3=ps.getString(4);
					sub4=ps.getString(5);
					sub5=ps.getString(6);
					sub6=ps.getString(7);
					ps.close();
				}catch(SQLException se){ 
				      //Handle errors for JDBC 
				      se.printStackTrace(); 
				   }catch(Exception er){ 
				      //Handle errors for Class.forName 
				      er.printStackTrace(); 
				   }
			pw.print("<center>\r\n" +
					"<font color=blue size=7> Enter Student Results</font></h1>\r\n" + 
					"<form name=\"Form1\" method=\"post\" action=\"http://localhost:8085/first/resultsenter\">\r\n" + 
					"<table width=750 bgcolor=white>\r\n"
					+ "<col width=\"500\">\r\n" + 
					"<col width=\"500\">" + 
					"<tr>"
					+ "<td height=50><b><font size=4><center>Enter the USN of Student:</td>"
					+ "<td><center><input type=textbox name=\"sid\"  value=\"\"></td>\r\n"
					+ "</tr>"
					+ "<tr>\r\n" + 
					"<td height=50><b><center><font size=4> Enter the INTERNAL </td>\r\n" + 
					"<td><center>No:1<input type=radio name=\"i\"  value=\"1\"> No:2<input type=radio name=\"i\"  value=\"2\">\r\n" + 
					" No:3<input type=radio name=\"i\"  value=\"3\"> </td>\r\n" + 
					" </tr>"
					+ "<tr>\r\n" + 
					"<td height=50><center><b><font size=4>Enter the Marks "+sub1+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark1\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=50><center><b><font size=4>Enter the Marks "+sub2+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark2\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=50><center><b><font size=4>Enter the Marks "+sub3+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark3\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=50><b><center><font size=4>Enter The Marks "+sub4+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark4\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=50><center><b><font size=4>Enter the  Marks "+sub5+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark5\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td height=50><center><b><font size=4>Enter the Marks "+sub6+":</td>\r\n" + 
					"<td><center><input type=textbox name=\"mark6\"  value=\"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td><b><center><input type=submit value=\"Submit\"></center></td>\r\n" + 
					"<td><center><input type=reset value=\"reset\"></center></td>\r\n" + 
					"</tr>\r\n" + 
					"</tr>\r\n" + 
					"</table>\r\n" + 
					"</form>\r\n");
			
			pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
					"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
					"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
					"</div>");

		}
	}

