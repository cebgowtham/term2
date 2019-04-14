package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBCon;
import Model.DBResultSet;
import sun.security.x509.IssuerAlternativeNameExtension;

import java.sql.*;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		int cus_id=0;
		try
		{
		DBResultSet drs=new DBResultSet();
		ResultSet rs=drs.getResultSet("customer");
		//ResultSet rs=drs.getResultSet("customer where cust_id=max(cust_id)");
		while(rs.next())
		{
			cus_id=Integer.parseInt(rs.getString("cust_id"));
			//pw.print(cus_id);
		}
		rs.close();
	
		}
		catch(Exception e)
		{
			pw.println("error : "+e.toString());
		}
	
		int cid=cus_id+1;
		String cname=request.getParameter("cname");
		
		if(!(cname.matches("[a-zA-Z]+")))
		{
			pw.println("Enter only alphabets in name");
			return;			
		}
		String add=request.getParameter("cadd");
		String email=request.getParameter("email");
		String qual=request.getParameter("qual");
		int exp=Integer.parseInt(request.getParameter("expe"));
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		
		if(!(phone.matches("[0-9]{10}")))
		{
			pw.println("Enter only 10 digit phone number");
			return;
		}
		String gender=request.getParameter("gender");
		
		int esalary=Integer.parseInt(request.getParameter("esal"));
		String pass=request.getParameter("pass");
		
		
				
		//String qry="INSERT INTO customer(cust_id,cust_name,address,email,qual,experiance,age,phone,gender,esalary,password) VALUES "
				        //             + "(1010,'gowthaman','namakkal','gowthaman@niit-karur.com','mca',10,37,'9894083890','male',15000,'password')";
		
         String qry="INSERT INTO customer(cust_id,cust_name,address,email,qual,experiance,age,phone,gender,esalary,password) VALUES "
						               + "("+cid+",'"+cname+"','"+add+"','"+email+"','"+qual+"',"+exp+","+age+",'"+phone+"','"+gender+"',"+esalary+",'"+pass+"')";
		
		try
		{
		DBCon con=new DBCon();
		Connection mycon=con.getConnection();
		Statement st=mycon.createStatement();
		int ans=st.executeUpdate(qry);
		if(ans>0)
			pw.println("Successfully inserted to database==> Your ID:"+cid +"   Password :"+pass);
		mycon.close();
		}
		catch(Exception e)
		{
			pw.println("error Message:"+e.toString());
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
