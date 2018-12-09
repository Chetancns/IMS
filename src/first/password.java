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
 * Servlet implementation class password
 */
@WebServlet("/password")
public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public password() {
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
		String oldpass=request.getParameter("pass");
		String newpass=request.getParameter("pass1");
		email=email.toUpperCase();
		oldpass=oldpass.toUpperCase();
		newpass=newpass.toUpperCase();
		if(login.value(email))
		{
	 String pass=login.valueP(email); 
	 if(pass.equals(oldpass)) {
		 try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
				
				Statement stmt=con.createStatement();

				stmt.executeQuery("update login set password='"+newpass+"' where email='"+email+"'");
				stmt.executeQuery("commit");
				pw.print("<h1><cenetr>Password succsessfuly updated");
				
				stmt.close();
				con.close();
				RequestDispatcher rs=getServletContext().getRequestDispatcher("/Projectlogin.html")  ;
				rs.include(request, response);
			
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
	 }
		 
	 else
	 pw.print("<h1>Your Old Password is <font color=red>INCORRECT");
	}else 
		pw.print("<h1><center>Your Email Id does Not Exist</h1>");
	
}
}