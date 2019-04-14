package View;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBCon;
import Model.DBResultSet;

import java.sql.*;
/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw=response.getWriter();
		pw.println("succss page ok");
		
		try
		{
			/*
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			pw.print("driver accepted");
			
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=test","sa","12345");
			*/
			
			/*DBCon dcon=new DBCon();  // Tightly Couple
			
			Connection con=dcon.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from customer");*/
			DBResultSet dbrs=new DBResultSet();
			ResultSet rs=dbrs.getResultSet("customer");
			pw.print("<table border=1 cellpadding=5 >");
			pw.print("<tr><th>customer id</th><th>customer Name</th><th>qualification</th><th>Email-Id</th><th>Address</th><th>Age</th><th>Phone</th><th>Gender</th><th>Salary</th><th>Password</th><th>Experiance(years)</th></tr>");
			while(rs.next())
			{
				pw.print("<tr><th>"+rs.getString("cust_id")+"</th>");
				pw.print("<th>"+rs.getString("cust_name")+"</th>");
				pw.print("<th>"+rs.getString("qual")+"</th>");
				pw.print("<th>"+rs.getString("email")+"</th>");
				pw.print("<th>"+rs.getString("address")+"</th>");
				
				pw.print("<th>"+rs.getString("age")+"</th>");
				pw.print("<th>"+rs.getString("phone")+"</th>");
				pw.print("<th>"+rs.getString("gender")+"</th>");
				pw.print("<th>"+rs.getString("esalary")+"</th>");
				pw.print("<th>"+rs.getString("password")+"</th>");
				pw.print("<th>"+rs.getString("experiance")+"</th></tr>");
			}
			pw.print("</table>");
		rs.close();	
			
		}
		catch(Exception e)
		{
			pw.print(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
