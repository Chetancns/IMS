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
 * Servlet implementation class Teacherdetails
 */
@WebServlet("/Teacherdetails")
public class Teacherdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherdetails() {
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
		String tid=login.valueT(email);
		

		try
{
	String name=null,qualification=null,address=null;
	long phone=00;
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection con=DriverManager.getConnection(
	"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
	
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from TEACHER where tid='"+tid+"'");
	while(rs.next()) {
		name=rs.getString(2);
		phone=rs.getLong(3);
		qualification=rs.getString(4);
		address=rs.getString(5);		
	}
	pw.print("<center><div style=\"font-family:Times New Roman; color:red;font-size:50px;width:750px;text-align:center;\">\r\n" + 
			"<center> <b>Welcome to Teacher Editorial Page</b> "
			+ "Your Details"
			+ "<table width=1000>\r\n" + 
			"<tr>\r\n" + 
			"<td height=50><b><font size=4>TID =   </td>\r\n" + 
			"<td><b><font size=4>"+tid+"</td>\r\n" + 
			"<td><b><font size=4>NAME =  </td>\r\n" + 
			"<td><b><font size=4>"+name+"</td>\r\n" + 
			"</tr>\r\n" + 
			" <tr>\r\n" +  
			"<td height=50><b><font size=4>Qualification =   </td>\r\n" + 
			"<td><b><font size=4>"+qualification+"</td>\r\n" + 
			"<td><b><font size=4>Phone =  </td>\r\n" + 
			"<td><b><font size=4>"+phone+"</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td height=50><b><font size=4>Address =   </td>\r\n" + 
			"<td><b><font size=4>"+address+"</td>\r\n" + 
			"<td><b><font size=4>Email Id =  </td>\r\n" + 
			"<td><b><font size=4>"+email+"</td>\r\n" + 
			"</tr>\r\n" + 
			"</table></center></center></html>");
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
