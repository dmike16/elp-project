/**
 * Abstract class with default function to access a DBMS with JDBC
 * @author dmike
 */

package dmike.util.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ReadDB{
	public ReadDB(String host,String nameDB,String user,String passw)
		throws SQLException
	{
		String dbURL = driver + '@'+ host + ":1521:" + nameDB;
		conn = DriverManager.getConnection(dbURL,user,passw);
		
	}
	public String getDriver(){
		return driver;
	}
	public void setDriver(String nDriver){
		this.driver = nDriver;
	}
	public Connection getConnection(){
		return conn;
	}
	
	@Override
	abstract public String toString();
	
	public void dispose()
		throws SQLException
	{
		if(conn != null){
			conn.close();
		}
	}
	
	private String driver = "jdbc:oracle:thin:"; 
	private Connection conn = null;
}
