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
	
	public List<Category> listChiperCatWithIva()
		throws SQLException
	{
		ArrayList<Category> categorie = new ArrayList<>();
		Statement stmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT ca.cat_cod,ca.cat_descrizione,max(a.art_iva)\n"+
					"FROM articoli a, categorie ca\n"+
					"WHERE a.cat_cod = ca.cat_cod\n"+
						"and a.art_prezzo < (SELECT avg(art_prezzo)\n"+
						"FROM articoli)\n"+
					"GROUP BY ca.cat_cod,ca.cat_descrizione";
			stmt = conn.getConnection().createStatement();
			rslt = stmt.executeQuery(sql);
			
			while(rslt.next()){
				Category c = categiroriaWithIva(rslt.getInt(3));
				c.setCod(rslt.getString(1));
				c.setDescription(rslt.getString(2));
				
				categorie.add(c);
			}
		}finally{
			PlugToDB.closeStatement(stmt, rslt);
		}
		
		return categorie;
	}
	
	private Category categiroriaWithIva(int iva_1){
		return new Category(){
			@Override
			public String toString(){
				return super.toString() + "\n"+
						"MaxIva: " + iva;
			}
			private int iva = iva_1; 
		};
	}
	
	private PlugToDB conn;
}
