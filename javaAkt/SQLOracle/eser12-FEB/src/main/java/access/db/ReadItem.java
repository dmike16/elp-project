package access.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.db.Item;
import dmike.util.dbms.PlugToDB;

public class ReadItem {
	
	public ReadItem()
		throws SQLException
	{
		cat = new ReadCategory();
		conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
	}
	public ReadItem(String host,String db, String user, String passw)
		throws SQLException
	{
		cat = new ReadCategory();
		conn = PlugToDB.startConnection(host, db, user, passw);
	}
	public List<Item> listData()
		throws SQLException
	{
		ArrayList<Item> items = new ArrayList<>();
		Statement stat = null;
		ResultSet rslt = null;
		
		try{
			String sql = "select * from articoli";
		
			stat = conn.getConnection().createStatement();
			rslt = stat.executeQuery(sql);
		
			while(rslt.next()){
				Item i = new Item();
			
				i.setCod(rslt.getString(1));
				i.setCat(rslt.getString(2));
				i.setDescription(rslt.getString(3));
				i.setPrice(rslt.getDouble(4));
				i.setIva(rslt.getInt(5));
				i.setTransportCost(rslt.getDouble(6));
			
				items.add(i);
			}
		}finally{
			if(stat != null){
				if(rslt != null){
					rslt.close();
				}
				stat.close();
			}
		}
		
		return items;
	}
	
	public Map<Integer,Integer> groupAndCountCatItem(String descr, String attrG)
		throws SQLException
	{
		HashMap<Integer,Integer> group = new HashMap<>();
		
		StringBuilder preSql = new StringBuilder();

		preSql.append("select ar.art_iva , count(*) from articoli ar,categorie ca\n");
		preSql.append("where ar.cat_cod = ca.cat_cod");
		preSql.append("\n and ca.cat_descrizione = ?");
		preSql.append("\n group by ar.");
		preSql.append(attrG);
		
		PreparedStatement prestmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = preSql.toString();
			prestmt = conn.getConnection().prepareStatement(sql);
			prestmt.setString(1, descr);
			
			rslt = prestmt.executeQuery();
			
			while(rslt.next()){
				group.put(rslt.getInt(1), rslt.getInt(2));
			}
			
		}finally{
			if(prestmt != null){
				if (rslt != null){
					rslt.close();
				}
				prestmt.close();
			}
		}
		
		return group;
	}
	
	public ReadCategory getCategory(){
		return cat;
	}
	
	private ReadCategory cat = null;
	private PlugToDB conn = null;
}
