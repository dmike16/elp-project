package access.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import action.db.Department;
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
		
		public List<Department> listDepartmentLocationCountEmployee(Date d)
			throws SQLException
		{
			ArrayList<Department> departs = new ArrayList<>();
			
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
					CountEmployee count = new CountEmployee();
					count.setCount(rslt.getInt(1));
					count.setName(rslt.getString(2));
					int id = rslt.getInt(3);
					count.setlID(id);
					count.setLocation(CountEmployee.locationCached(departs, id));
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
		
		private static class LocationDepartment extends Department{
			 protected LocationDepartment(){
				super();
			}
			public Location getLocation(){
				return dep;
			}
			public void setLocation(Location d){
				dep = d;
			}
			@Override
			public String toString(){
				return "Nome Dep: " + super.getName() + "\n"+
						"Location : " + "Id: " + getLocation().getId()+"\n" +
						"            Address: " + getLocation().getAddress()+ ", " +
										getLocation().getCity();
			}
			protected static Location locationCached(List<Department> dep,int id){
				for(Department d: dep){
					if(d.getlID() == id){
						return ((LocationDepartment) d).getLocation();
					}
				}
				return new Location();
			}
				
			private Location dep;
		}
		private static class CountEmployee extends LocationDepartment{
			protected CountEmployee(){
				super();
			}
			public int getCount(){
				return count;
			}
			public void setCount(int c){
				count = c;
			}
			@Override
			public String toString(){
				return super.toString() +"\n"+
						"NumDip: " + getCount();
			}
			private int count;
		}
		private PlugToDB conn;
}
