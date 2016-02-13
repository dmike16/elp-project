/**
 * Abstract class with default function to access a DBMS with JDBC
 * @author dmike
 */

package dmike.util.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class PlugToDB{
	private PlugToDB(String host,String nameDB,String user,String passw)
		throws SQLException
	{
		String dbURL = driver + '@'+ host + ":1521:" + nameDB;
		this.host = host;
		this.port = "1521";
		this.sid = nameDB;
		this.user = user;
		conn = DriverManager.getConnection(dbURL,user,passw);
		
	}
	public String getHost(){
		return host;
	}
	public String getPort(){
		return port;
	}
	public String getSID(){
		return sid;
	}
	public String getDriver(){
		return driver;
	}
	public String getUser(){
		return user;
	}
	public void setDriver(String nDriver){
		this.driver = nDriver;
	}
	public  Connection getConnection(){
		return conn;
	}
	@Override
	public String toString(){
		return getUser() + "-" + getHost() + 
				"-" + getSID() + "-" + getPort();
	}
	
	private void dispose()
		throws SQLException
	{
		if(conn != null){
			conn.close();
		}
	}
	
	public static PlugToDB startConnection(String host,String nameDB,String user,String passw)
		throws SQLException
	{
		String key = user+"@"+nameDB;
		if (pool == null || pool.isEmpty()){
			pool = new HashMap<>();
			pool.put(key, new PlugToDB(host,nameDB,user,passw));
		}else if(!(pool.containsKey(key))){
			pool.put(key, new PlugToDB(host,nameDB,user,passw));
		}
		return pool.get(key);
	}
	public static void shutDownConnection()
		throws SQLException
	{
		Iterator<String> iter = pool.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			pool.remove(key).dispose();
		}
	}
	public static void shutDownConnection(String user,String db){
		String key = user+"@"+db;
		
		if(pool.containsKey(key)){
			pool.remove(key);
		}
	}
	public static ArrayList<PlugToDB> showConnection(){
		
		ArrayList<PlugToDB> allConnection = new ArrayList<>();
		
		for(String k: pool.keySet()){
			allConnection.add(pool.get(k));
		}
		
		return allConnection;
	}
	protected Object clone() 
			throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
	
	private final String host;
	private final String sid;
	private final String port;
	private final String user;
	private String driver = "jdbc:oracle:thin:";
	private Connection conn = null;
	private static HashMap<String,PlugToDB> pool = null;
}
