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
 * Servlet implementation class studentdetails
 */
@WebServlet("/studentdetails")
public class studentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentdetails() {
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
		usn=usn.toUpperCase();
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
			
		pw.print(" <table width=1500>\r\n" + 
				"<tr>\r\n" + 
				"<td><b><font size=4>USN =   </td>\r\n" + 
				"<td><b><font size=4>"+usn+"</td>\r\n" + 
				"<td><b><font size=4>NAME =  </td>\r\n" + 
				"<td><b><font size=4>"+name+"</td>\r\n" + 
				"</tr>\r\n" + 
				" <tr>\r\n" + 
				"<td><b><font size=4>Gender =   </td>\r\n" + 
				"<td><b><font size=4>"+gender+"</td>\r\n" + 
				"<td><b><font size=4>SEM =  </td>\r\n" + 
				"<td><b><font size=4>"+sem+"</td>\r\n" + 
				"</tr> \r\n" + 
				"<tr>\r\n" + 
				"<td><b><font size=4>SEC =   </td>\r\n" + 
				"<td><b><font size=4>"+sec+"</td>\r\n" + 
				"<td><b><font size=4>Phone =  </td>\r\n" + 
				"<td><b><font size=4>"+phone+"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td><b><font size=4>Address =   </td>\r\n" + 
				"<td><b><font size=4>"+address+"</td>\r\n" + 
				"<td><b><font size=4>Email Id =  </td>\r\n" + 
				"<td><b><font size=4>"+email+"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>");	
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
	}
}
