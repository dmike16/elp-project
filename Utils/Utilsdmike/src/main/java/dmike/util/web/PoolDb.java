package dmike.util.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolDb {
	
	public PoolDb() throws NamingException, SQLException
	{
		Context init = new InitialContext();
		Context env = (Context) init.lookup("java:comp/env");
		DataSource jdbc = (DataSource) env.lookup("jdbc/hr");
		conn = jdbc.getConnection();
	}
	public Connection pop(){
		return conn;
	}
	public void push() throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	
	private Connection conn = null;
}
