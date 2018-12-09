package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class parententery
 */
@WebServlet("/parententery")
public class parententery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public parententery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String sid=request.getParameter("sid");
		email=email.toUpperCase();
		sid=sid.toUpperCase();
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
		
		if(login.value1P(email)) {
			if(!login.valuePP(email,sid)) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
					
					Statement stmt=con.createStatement();
					stmt.executeQuery("insert into parents"+" values('"+email+"','"+sid+"') ");
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
				pw.print("<div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
						"<h1>Details are  updated</h1><br> </div><div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
						"<font size=7 color=\"black\"><center><br>\r\n" + 
						"To Repeat the Following Action ||<font color=\"red\"><a href=\"http://localhost:8085/first/parententry.html\">Click Here!!!</a></font></center></center>");
				pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
						"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
						"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
						"</div>");
				
			}else {
				pw.print("<div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
						"<h1>details are already updated</h1> </div><div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
						"<font size=7 color=\"black\"><center><br>\r\n" + 
						"To Repeat the Following Action ||<font color=\"red\"><a href=\"http://localhost:8085/first/parententry.html\">Click Here!!!</a></font></center></center>");
				pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
						"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
						"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
						"</div>");
			}
			
		}else
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();

				stmt.executeQuery("insert into login"+" values('"+email+"','CNS123') ");
				stmt.executeQuery("commit");
				stmt.executeQuery("insert into parents"+" values('"+email+"','"+sid+"') ");
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
			pw.print("<div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
					"<h1>details are  updated</h1> </div><div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
					"<font size=7 color=\"black\"><center><br>\r\n" + 
					"To Repeat the Following Action ||<font color=\"red\"><a href=\"http://localhost:8085/first/parententry.html\">Click Here!!!</a></font></center></center>");
			pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
					"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
					"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
					"</div>");
		}
		
		}
	}


