package web.app;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import web.db.DbConnection;

public class VeicoloDb{
	
	public VeicoloDb()
		throws SQLException, NamingException
	{
		db = DbConnection.connect();
	}
	
	public DbConnection getDbConnection()
	{
		return db;
	}
	
	public int addVeicolo(Veicolo v)
		throws SQLException, NamingException
	{
		int rows = -1;
		
		String sql = "INSERT INTO veicoli VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		
		try{
			pstm = db.getConn().prepareStatement(sql);
			pstm.setString(1, v.getTarga());
			pstm.setFloat(2, v.getVelocita());
			pstm.setFloat(3, v.getKw());
			pstm.setFloat(4, v.getVelocita());
			pstm.setInt(5, v.getPosti());
			pstm.setDate(6, Date.valueOf(v.getImmatricolazione()));
			pstm.setString(7, v.getCat());
			pstm.setString(8, v.getComb());
			pstm.setString(9, v.getModello());
			
			rows = pstm.executeUpdate();
		}finally{
			if(pstm != null){
				pstm.close();
			}
		}
		
		
		return rows;
	}
	
	private DbConnection db;
}
