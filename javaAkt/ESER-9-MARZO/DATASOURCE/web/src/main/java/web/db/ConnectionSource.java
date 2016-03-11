package web.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionSource {
	protected ConnectionSource() 
			throws NamingException, SQLException
	{
		Context init = new InitialContext();
		Context java = (Context) init.lookup("java:comp/env");
		DataSource jdbc = (DataSource) java.lookup("jdbc/hr");
		conn = jdbc.getConnection();
	}
	protected Connection getConnection(){
		return conn;
	}
	
	protected void dispose()
		throws SQLException
	{
		if(conn != null){
			try{
				conn.close();
			}finally{
				conn = null;
			}
		}
	}
	
	private Connection conn = null;
}
