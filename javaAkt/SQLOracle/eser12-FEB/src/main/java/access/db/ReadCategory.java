package access.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dmike.util.dbms.PlugToDB;
import action.db.Category;

public class ReadCategory {
	public ReadCategory()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
	public ReadCategory(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
	public List<Category> listData()
		throws SQLException
	{
		
		ArrayList<Category> cat = new ArrayList<>();
		Statement stat = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * FROM categorie";
			stat = conn.getConnection().createStatement();
			rslt = stat.executeQuery(sql);
		
			while(rslt.next()){
				Category c = new Category();
			
				c.setCod(rslt.getString(1));
				c.setDescription(rslt.getString(2));
			
				cat.add(c);
			}
		}finally{
			if(stat != null){
				if(rslt != null){
					rslt.close();
				}
				stat.close();
			}
		}
		
		return cat;
	}
	
		private PlugToDB conn;
}
