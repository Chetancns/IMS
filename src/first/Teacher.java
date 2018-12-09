package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Teacher
 */
@WebServlet("/Teacher")
public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher() {
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
		
		
		RequestDispatcher rd=request.getRequestDispatcher("Teacherdetails");
		rd.include(request, response);
		RequestDispatcher rs=getServletContext().getRequestDispatcher("/Teacher1.html")  ;
		rs.include(request, response);
		
	
		
		pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
				"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
				"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
				"</div>");

		
		
		;
	}

}
