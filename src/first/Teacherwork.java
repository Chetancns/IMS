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
 * Servlet implementation class Teacherwork
 */
@WebServlet("/Teacherwork")
public class Teacherwork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherwork() {
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
		String tid=null;
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String value=request.getParameter("teacher");
		
	   
		
		
		if(value.equals("student")) {
			RequestDispatcher rs=getServletContext().getRequestDispatcher("/Studententry.html")  ;
			rs.include(request, response);
			
		}
		if(value.equals("results")) {
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
			
			pw.print("<form name=\"Form1\" method=\"post\" action=\"http://localhost:8085/first/results\">\r\n" + 
					"<center><table width=750>\r\n" + 
					"<tr>\r\n" + 
					"<td><font size=7><b>Enter the Student sem:</td>\r\n" + 
					"<td><input type=textbox name=\"sem\"  value=\"\"></td>\r\n" + 
					"</tr><tr>"
					+ "<td><input type=submit value=\"Submit\"></td>\r\n" + 
					"<td><input type=reset value=\"reset\"></td></tr></table></center>");
			
			
			
			
		}
		
if(value.equals("stud")) {
	RequestDispatcher rs=getServletContext().getRequestDispatcher("/parententry.html")  ;
	rs.include(request, response);
		}
		
		
	}

}
