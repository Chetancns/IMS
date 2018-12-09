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
 * Servlet implementation class Parents
 */
@WebServlet("/Parents")
public class Parents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parents() {
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
		pw.print("<h1><center>Select One of The Child To See The Results</h1>"
				+ "<form name=\"Form1\" method=\"post\" action=\"http://localhost:8085/first/parentsee\">");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
			
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select sid from parents where email='"+email+"'");
			
		while(rs.next()) {
			String sid=rs.getString(1);
			pw.print("<center><h1>To View The Results of "+sid+"=<input type=radio name=\"sid\"  value=\""+sid+"\"></h1><br></center>");
		}
		
		
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
		pw.print("<center><input type=submit value=\"Submit\">\r\n" + 
				"<input type=reset value=\"reset\"></center>");
		pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
			"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
			"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
			"</div>");

	}
}
