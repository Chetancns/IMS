package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resultsenter
 */
@WebServlet("/resultsenter")
public class resultsenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultsenter() {
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
		String sid=request.getParameter("sid");
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
		
		
		String inter=request.getParameter("i");
		String mark1=request.getParameter("mark1");
		String mark2=request.getParameter("mark2");
		String mark3=request.getParameter("mark3");
		String mark4=request.getParameter("mark4");
		String mark5=request.getParameter("mark5");
		String mark6=request.getParameter("mark6");
		if(login.valueSS(sid)) {
		if(!login.valueC(sid,inter)) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","chethancns498");
			
			Statement stm=conn.createStatement();
		stm.executeQuery("insert into results"+" values('"+
							sid+"',"
							+inter+","
							+mark1+","
							+mark2+","
							+mark3+","
							+mark4+","
							+mark5+","
							+mark6+") ");
		stm.executeQuery("commit");
				stm.close();
		conn.close();
		} catch(SQLException se){ 
		      //Handle errors for JDBC 
		      se.printStackTrace(); 
		   }catch(Exception er){ 
		      //Handle errors for Class.forName 
		      er.printStackTrace(); 
		   }
		
		
		pw.print("<center><div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
				"<font color=blue><h1>Student Results is Successfully Entered </h2><br>"
				+"</center>");
		pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
				"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
				"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
				"</div>");


		}else {
			pw.print("<div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
					"<font color=blue><h1><center>Students Internal "+inter+" marks is Updated</h1></center>");
			pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
					"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
					"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
					"</div>");
		}
		}else
		{
			pw.print("<div style=\"font-family:Times New Roman; color:red;font-size:50px;width:1000px;text-align:center;\">\r\n" + 
					"<font color=blue><h1><center>Students Details Doesn't Exist</h1></center>");
			pw.print("<div style=\"position:absolute-bottom;bottom:1px;color:blue;font-size:25px;background-color:yellow;width:1500px;height:25px;\">\r\n" + 
					"@2018 CNS INSTITUTE OF TECHNOLOGY  \r\n" + 
					"CNS-Bangalore,Karnataka||<font color=\"red\"><a href=\"http://localhost:8085/first/Projectlogin.html\">LOGOUT</a></font>\r\n" + 
					"</div>");
		}
		}
		
	}


