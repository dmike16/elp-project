package mvc.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDb {
	public ProductDb() 
			throws NamingException, SQLException
	{
		conn = this.popConnection(); 
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public int insert(Product pd) throws SQLException{
		int rows = -1;
		
		PreparedStatement pstmt = null;
		
		
		try{
			String sql = "INSERT INTO libri VALUES(?,?,?,?)";
			pstmt = this.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, pd.getDescription());
			pstmt.setString(2, pd.getName());
			pstmt.setString(3, pd.getAuthor());
			pstmt.setFloat(4, pd.getPrice());
			
			rows = pstmt.executeUpdate();
			
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		return rows;
	}
	
	public void dispose() throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	
	private Connection popConnection() 
			throws NamingException, SQLException
	{
		Context init = new InitialContext();
		Context env = (Context) init.lookup("java:comp/env");
		DataSource jdbc = (DataSource) env.lookup("jdbc/hr");
		
		return jdbc.getConnection();
	}
	private Connection conn;
}
