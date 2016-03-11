package web.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import util.Articol;
import util.NonQuantityException;
import util.Vendite;
import web.controller.CacheControll;

public class ArticolDb extends ConnectionSource{
	public ArticolDb()
		throws SQLException, NamingException
	{
		super();
	}
			
	@Override
	public void dispose() 
		throws SQLException
	{
		super.dispose();
	}
	
	public int insert(Vendite v, CacheControll cache)
			throws SQLException, NonQuantityException
		{
			int rows = -1;
			
			PreparedStatement pstmt = null;
			
			try{
				String sql = "INSERT INTO vendite_due VALUES(?,?,?)";
				pstmt = super.getConnection().prepareStatement(sql);
				
				pstmt.setString(1, v.getCode());
				pstmt.setString(2,v.getNumber());
				pstmt.setInt(3, v.getQty());
				
				Articol art = new Articol();
				
				art.setCode(v.getCode());
				art.setInstock(-v.getQty());
				
				this.update(art, cache);
				
				rows = pstmt.executeUpdate();
				
			}finally{
				if(pstmt != null){
					pstmt.close();
				}
			}
			
			return rows;
		}
	
	public int insert(Articol art, CacheControll cache)
		throws SQLException
	{
		int rows = -1;
		
		PreparedStatement pstm = null;
				
		try{
			String sql = "INSERT INTO articoli_due VALUES(?,?,?,?)";
			pstm = super.getConnection().prepareStatement(sql);
			pstm.setString(1, art.getCode());
			pstm.setString(2, art.getDescription());
			pstm.setInt(3, art.getInstock());
			pstm.setFloat(4, art.getPrice());
			
			rows = pstm.executeUpdate();
			
			cache.gesture(art.getCode(),art.getInstock());
		}finally{
			if(pstm != null){
				pstm.close();
			}
		}
		
		return rows;
	}
	
	public int update(Articol art,CacheControll cache)
		throws SQLException, NonQuantityException
	{
		int rows = -1;
		
		PreparedStatement pstmt = null;
		
		try{
			String sql = "UPDATE articoli_due SET giacenza = ? \n"+
					"WHERE codice = ?";
			pstmt = super.getConnection().prepareStatement(sql);
			int qty = cache.getCache().get(art.getCode()) + art.getInstock();
			
			if(qty < 0){
				throw new NonQuantityException();
			}
			pstmt.setInt(1, qty);
			pstmt.setString(2, art.getCode());
			
			rows = pstmt.executeUpdate();
			
			cache.getCache().put(art.getCode(), qty);
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		return rows;
	}
	
	public List<Articol> findAll()
		throws SQLException
	{
		List<Articol> arts = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * FROM articoli_due";
			stmt = super.getConnection().createStatement();
			rslt = stmt.executeQuery(sql);
			
			while(rslt.next()){
				Articol art = new Articol();
				
				art.setCode(rslt.getString(1));
				art.setDescription(rslt.getString(2));
				art.setInstock(rslt.getInt(3));
				art.setPrice(rslt.getFloat(4));
				
				arts.add(art);
			}
			
		}finally{
			if(stmt != null){
				if(rslt != null){
					rslt.close();
				}
				stmt.close();
			}
		}
		
		return arts;
	}
	
	public int insertOrUpdate(Articol art, CacheControll cache)
		throws SQLException, NonQuantityException
	{
		int rows = -1;
		boolean isIn = cache.getCache().containsKey(art.getCode());
		
				
		if(isIn){
			rows = update(art,cache);
		}else{
			rows = insert(art,cache);
		}
		
		return rows;
	}
	
}
