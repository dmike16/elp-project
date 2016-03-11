package web.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbPool {
	
	public DbPool()
		throws SQLException, NamingException
	{
		Context root = new InitialContext();
		Context env = (Context) root.lookup("java:comp/env");
		DataSource jdbc = (DataSource) env.lookup("jdbc/hr");
		conn = jdbc.getConnection();
		
	}
	
	public Connection popConnection(){
		return conn;
	}
	
	public void pushConnection()
		throws SQLException
	{
		if(conn != null){
			conn.close();
		}
	}
	
	private Connection conn = null;
}
