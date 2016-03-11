package web.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDb {
	public BooksDb(){}
	public BooksDb(DbPool conn) 
	{
		pool = conn;
	}

	public int insert(DbPool db,Book bk)
		throws SQLException
	{
		int rows = -1;
		//TODO
		
		PreparedStatement pstmt = null;
		
		try{
			String sql = "INSERT INTO libri VALUES(?,?,?,?)";
			pstmt = db.popConnection().prepareStatement(sql);
			pstmt.setInt(1, bk.getId());
			pstmt.setString(2, bk.getTitle());
			pstmt.setString(3, bk.getAuthor());
			pstmt.setInt(4, bk.getPrice());
			
			rows = pstmt.executeUpdate();
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		
		return rows;
	}
	
	public int insert(Book bk)
		throws SQLException
	{
		return this.insert(pool,bk);
	}
	
	public boolean searchByTitle(DbPool db, String title)
		throws SQLException
	{
		boolean find = false;
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * FROM libri WHERE titolo_libro = ? ";
			pstmt = db.popConnection().prepareStatement(sql);
			pstmt.setString(1, title);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				find = true;
				break;
			}
			
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return find;
	}
	
	public boolean searchByTitle(String title)
			throws SQLException
	{
		return this.searchByTitle(pool, title);
	}
	
	public Book searchById(DbPool db, int id)
		throws SQLException
	{
		Book bk = new Book();
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * from libri WHERE id_libro=?";
			pstmt = db.popConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				bk.setId(rslt.getInt(1));
				bk.setTitle(rslt.getString(2));
				bk.setAuthor(rslt.getString(3));
				bk.setPrice(rslt.getInt(4));
				
				break;
			}
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return bk;
	}
	
	public Book serachById(int id) throws SQLException{
		return this.searchById(pool, id);
	}
	
	public List<Book> searchByAuthor(DbPool db, String author)
			throws SQLException
		{
			List<Book> bks = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT * from libri WHERE nome_autore=?";
				pstmt = db.popConnection().prepareStatement(sql);
				pstmt.setString(1, author);
				
				rslt = pstmt.executeQuery();
				
				while(rslt.next()){
					Book bk = new Book();
					bk.setId(rslt.getInt(1));
					bk.setTitle(rslt.getString(2));
					bk.setAuthor(rslt.getString(3));
					bk.setPrice(rslt.getInt(4));
					
					bks.add(bk);
					
					break;
				}
			}finally{
				if(pstmt != null){
					if(rslt != null){
						rslt.close();
					}
					pstmt.close();
				}
			}
			
			return bks;
		}
		
		public List<Book> serachByAuthor(String author) throws SQLException{
			return this.searchByAuthor(pool, author);
		}
		
	
	public int booksNumberPerAuthor(DbPool db,String author)
		throws SQLException
	{
		int total = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT count(*) FROM libri\n"+
					"WHERE nome_autore = ? \n";
			pstmt = db.popConnection().prepareStatement(sql);
			pstmt.setString(1, author);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				total = rslt.getInt(1);
				break;
			}
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return total;
	}
	
	public int booksNumberPerAuthor(String author)
			throws SQLException
	{
		return this.booksNumberPerAuthor(pool, author);
	}
	
	
	public void dispose() throws SQLException{
		if(pool != null){
			pool.pushConnection();
		}
	}
	
	private DbPool pool = null;
}
