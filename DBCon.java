package Model;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBCon {
Connection c=null;
	public Connection getConnection()
	{
		try
		{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		c=DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=test","sa","12345");

		}
		catch(Exception e)
		{
			
		}
		return c;
	}
	
}
