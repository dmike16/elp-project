package access.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import action.db.Veicoli;
import dmike.util.dbms.PlugToDB;

public class ReadVeicolo {
	public ReadVeicolo()
			throws SQLException
		{
			prop = new ReadProprieta();
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadVeicolo(String host,String db, String user, String passw)
			throws SQLException
		{
			prop = new ReadProprieta();
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		public ReadProprieta getProprieta(){
			return prop;
		}
		public List<Veicoli> listData()
				throws SQLException
			{
				ArrayList<Veicoli> items = new ArrayList<>();
				Statement stat = null;
				ResultSet rslt = null;
				
				try{
					String sql = "select * from veicoli";
				
					stat = conn.getConnection().createStatement();
					rslt = stat.executeQuery(sql);
				
					while(rslt.next()){
						Veicoli v = new Veicoli();
					
						v.setTarga(rslt.getString(1));
						v.setCilindrata(rslt.getInt(2));
						v.setKw(rslt.getFloat(3));
						v.setVel(rslt.getFloat(4));
						v.setPosti(rslt.getInt(5));
						v.setImm(rslt.getDate(6));
						v.setCat(rslt.getString(7));
						v.setComb(rslt.getString(8));
						v.setMod(rslt.getString(9));
											
						items.add(v);
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
		private PlugToDB conn;
		private ReadProprieta prop;
}
