package Model;
import java.sql.*;
public class DBResultSet {

	ResultSet rs=null;
	
	public ResultSet getResultSet(String tn)
	{
		try
		{
		Statement st=new DBCon().getConnection().createStatement();
		rs=st.executeQuery("select * from "+tn);
		
		}
		catch(Exception e)
		{
			//......
		}
		return rs;
	}
}
