package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBCon;
import Model.DBResultSet;

/**
 * Servlet implementation class VendorServlet
 */
@WebServlet("/VendorServlet")
public class VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorServlet() {
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
		int ven_id=0;
		
		
		try
		{
		DBResultSet drs=new DBResultSet();
		ResultSet rs=drs.getResultSet("vendor1");
		//ResultSet rs=drs.getResultSet("vendor1 where ven_id=max(ven_id)");
		while(rs.next())
		{
			ven_id=Integer.parseInt(rs.getString("ven_id"));
			//pw.print(cus_id);
		}
		rs.close();
	
		
		}
		catch(Exception e)
		{
			pw.println("error : "+e.toString());
		}
				
		int vid=ven_id+1;
		String vname=request.getParameter("vname");
		String vadd=request.getParameter("vadd");
		String jrole=request.getParameter("jrole");
		String jlocation=request.getParameter("jlocation");
		String email=request.getParameter("email");
		String qual=request.getParameter("qual");
		int exp=Integer.parseInt(request.getParameter("expe"));
		String phone=request.getParameter("phone");		
		int sal=Integer.parseInt(request.getParameter("vsal"));
		String ldate=request.getParameter("ldate");
		String pass=request.getParameter("pass");
		
		//insert into vendor1 (ven_id,v_name,v_add,jrole,qual,expe,jlocation,salary,ldate,password,phone,email) values(10101,'TCS','Chennai,T-Nagar,TN','software engineer','mca',0,'chennai',20000,'30-3-2019','password','9870654321','tcschennai@tcs.com')
		
		
         String qry="INSERT INTO vendor1(ven_id,v_name,v_add,jrole,qual,expe,jlocation,salary,ldate,password,phone,email) VALUES "
						               + "("+vid+",'"+vname+"','"+vadd+"','"+jrole+"','"+qual+"',"+exp+",'"+jlocation+"',"+sal+",'"+ldate+"','"+pass+"','"+phone+"','"+email+"')";
		
		try
		{
		DBCon con=new DBCon();
		Connection mycon=con.getConnection();
		Statement st=mycon.createStatement();
		int ans=st.executeUpdate(qry);
		if(ans>0)
			pw.println("Successfully inserted Vendor details to database==> Vendor ID:"+vid +"   Password :"+pass);
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
