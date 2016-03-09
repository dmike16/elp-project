package web.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {
	
	public static DbConnection connect()
			throws SQLException, NamingException
	{
		DbConnection.refCount++;
		if(DbConnection.dbconn == null){
			DbConnection.dbconn = new DbConnection();
		}
		return DbConnection.dbconn;
	}
	
	private DbConnection()
		throws SQLException, NamingException
	{
		this.extabilishConnection();
	}
	
	public void dispose() throws SQLException{
		long total = --DbConnection.refCount;
		if(total < 0){
			DbConnection.refCount = 0;
		} else if(total == 0){
			conn.close();
		}
	}
	
	public Connection getConn(){
		return conn;
	}
	
	private void extabilishConnection()
		throws NamingException, SQLException
	{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/hr");
		conn = ds.getConnection();
	}
	
	private static volatile long refCount = 0;
	private static DbConnection dbconn = null;
	private Connection conn;
}
