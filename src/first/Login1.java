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
 * Servlet implementation class Login1
 */
@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
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
		String password=request.getParameter("password");
		email=email.toUpperCase();
		password=password.toUpperCase();
		if(login.value(email))
				{
			 String pass=login.valueP(email); 
			 if(pass.equals(password)) {
				if(login.value11(email)) {
				String usn=login.valueS(email);
					RequestDispatcher rd=request.getRequestDispatcher("student");
						rd.forward(request, response);
				}
				if(login.value1(email))
				{	RequestDispatcher rd=request.getRequestDispatcher("Teacher");
				rd.forward(request, response);
				}
				if(login.value1P(email)) {
					RequestDispatcher rd=request.getRequestDispatcher("Parents");
					rd.forward(request, response);
				}
				else
					pw.print("<body bgcolor=#fffacd>\r\n" + 
							"<div style=\"font-family:Times New Roman; color:blue;font-size:75px;background:grey;width:1500px;text-align:center;\">\r\n" + 
							"<font color=red>CNS</font> INSTITUTE OF TECHNOLOGY\r\n" + 
							"<font size=5 color=\"black\"><center>(AICTE Approved,VTU Affiliated and NAAC 'A' Accredited)</font></div> \r\n" + 
							"<center>\r\n" + 
							"<div style=\"font-family:Times New Roman;font-size:50px;width:1000px;text-align:center;\">\r\n"
							+ "<h1>Sorry Your Details are not Updated</h1>"
							+ "<div style=\"position:absolute;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
							"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
							"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">HOME</a></font>\r\n" + 
							"</div>");
			 }else{
					pw.print("<h1><center>Sorry incorret Email id and password<br>"
							+ "Input correct Details");
					RequestDispatcher rs=getServletContext().getRequestDispatcher("/Projectlogin.html")  ;
		rs.include(request, response);}
				 
				}else
					{
					pw.print("<body bgcolor=#fffacd>\r\n" + 
							"<div style=\"font-family:Times New Roman; color:blue;font-size:75px;background:grey;width:1500px;text-align:center;\">\r\n" + 
							"<font color=red>CNS</font> INSTITUTE OF TECHNOLOGY\r\n" + 
							"<font size=5 color=\"black\"><center>(AICTE Approved,VTU Affiliated and NAAC 'A' Accredited)</font></div> \r\n" + 
							"<center>\r\n" + 
							"<div style=\"font-family:Times New Roman;;font-size:50px;width:1000px;text-align:center;\">"
							+ "<h1><center> Your Email Id is not in Login<br>"
							+ "<font color=red>Sorry </div>"
							+ "<div style=\"position:absolute;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
							"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
							"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">HOME</a></font>\r\n" + 
							"</div>  ");
					}
}
	}


