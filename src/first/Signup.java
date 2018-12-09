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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		String password=request.getParameter("pass");
		String pass=request.getParameter("pass1");
		email=email.toUpperCase();
		pass=pass.toUpperCase();
		if(login.valuelo(email)==false) {
			if(password.equals(pass)) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
					
					Statement stmt=con.createStatement();
						
					stmt.executeQuery("Insert into login"+" values('"+email+"' , '"+pass+"')");
				    stmt.executeQuery("commit");
				    pw.print("<h1>Your Successfully inserted</h1>");
					RequestDispatcher rs=getServletContext().getRequestDispatcher("/WEB-INF/Projectlogin.html")  ;
					rs.include(request, response);
					
				
				
			} catch(SQLException se){ 
			      //Handle errors for JDBC 
			      se.printStackTrace(); 
			   }catch(Exception er){ 
			      //Handle errors for Class.forName 
			      er.printStackTrace(); 
			   }
				
			}else
			{
				pw.print("<h1>Password don't match</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Signup.html");
				rd.include(request, response);
			}
		}else
		{
			pw.print("<h1>Email Id is already in login</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Signup.html");
			rd.include(request, response);
			
		}
	}

}
