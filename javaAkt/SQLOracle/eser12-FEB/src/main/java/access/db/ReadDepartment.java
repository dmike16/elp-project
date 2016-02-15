package access.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import action.db.DepartmentWithLocation;
import action.db.Location;
import dmike.util.dbms.PlugToDB;

public class ReadDepartment {
	public ReadDepartment()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadDepartment(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		
		public List<DepartmentWithLocation> listDepartmentLocationCountEmployee(Date d)
			throws SQLException
		{
			ArrayList<DepartmentWithLocation> departs = new ArrayList<>();
			
			PreparedStatement pstatm = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT count(*),d.department_name,l.location_id,l.street_address,l.city\n"+
						"FROM locations l,departments d, job_history jh\n"+
						"WHERE d.department_id = jh.department_id\n"+
						"and ? between jh.start_date and jh.end_date\n"+
						"and d.location_id = l.location_id\n"+
						"GROUP BY d.department_name,l.location_id,l.street_address,l.city";
				pstatm = conn.getConnection().prepareStatement(sql);
				pstatm.setDate(1, d);
				
				rslt = pstatm.executeQuery();
				
				while(rslt.next()){
					DepartmentWithLocation count = CountEmployee(rslt.getInt(1));
				
					count.setName(rslt.getString(2));
					int id = rslt.getInt(3);
					count.setlID(id);
					count.setLocation(locationCached(departs, id));
					count.getLocation().setId(id);
					count.getLocation().setAddress(rslt.getString(4));
					count.getLocation().setCity(rslt.getString(5));
					
					departs.add(count);
				}
			}finally{
				if(pstatm != null){
					if(rslt != null){
						rslt.close();
					}
					pstatm.close();
				}
			}
			
			return departs;
		}
		
		private Location locationCached(List<DepartmentWithLocation> deps,int id){
			for(DepartmentWithLocation d: deps){
				if(d.getlID() == id){
					return d.getLocation();
				}
			}
			return new Location();
		}
		private DepartmentWithLocation CountEmployee(int ccount){
			return new DepartmentWithLocation(){
				@Override
				public String toString(){
					return "Name: " + super.getName() +"\n"+
							"LoID: " + super.getLocation().getId() + "\n"+
							"Address: " + super.getLocation().getAddress() + ", " + super.getLocation().getCity()+"\n"+
							"NumDip: " + count;
				}
				private int count = ccount;
				};
		}
		private PlugToDB conn;
}
