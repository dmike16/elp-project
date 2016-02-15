package access.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dmike.util.dbms.PlugToDB;
import action.db.LabGroupComponenti;

public class ReadComponent {
	public ReadComponent()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadComponent(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		
		public List<LabGroupComponenti> contComponentperLab()
			throws SQLException
		{
			ArrayList<LabGroupComponenti> counts = new ArrayList<>();
			
			Statement stat = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT l.lab_cod,count(*)\n"+
							"FROM laboratori l, componenti co\n"+
							"WHERE l.lab_cod = co.lab_cod\n"+
							"GROUP BY l.lab_cod";
				
				stat = conn.getConnection().createStatement();
				rslt = stat.executeQuery(sql);
				
				while(rslt.next()){
					LabGroupComponenti group = new LabGroupComponenti();
					
					group.setCod(rslt.getString(1));
					group.setCount(rslt.getInt(2));
					
					counts.add(group);
				}
				
			}finally{
				if(stat != null){
					if(rslt != null){
						rslt.close();
					}
					stat.close();
				}
			}
			
			return counts;
		}
		private PlugToDB conn;
}
