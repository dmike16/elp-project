package access.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import action.db.Employees;
import dmike.util.dbms.PlugToDB;

public class ReadEmployees {
	public ReadEmployees()
			throws SQLException
		{
			dep = new ReadDepartment();
			job = new ReadJobs();
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
	public ReadEmployees(String host,String db, String user, String passw)
			throws SQLException
		{
			job = new ReadJobs();
			dep = new ReadDepartment();
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
	public ReadJobs getJob(){
		return job;
	}
	public ReadDepartment getDepartment(){
		return dep;
	}
	public List<Employees> listDate(double d)
		throws SQLException
	{
		ArrayList<Employees> employees = new ArrayList<>();
		PreparedStatement pstatm = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * from employees\n"+
					"WHERE salary > (SELECT avg(salary)\n"+
					"FROM employees)\n"+
					"and job_id in (SELECT job_id from jobs\n"+
					"WHERE max_salary > ?)";
			pstatm = conn.getConnection().prepareStatement(sql);
			pstatm.setDouble(1, d);
			
			rslt = pstatm.executeQuery();
			
			while(rslt.next()){
				Employees e = new Employees();
				
				e.setId(rslt.getInt(1));
				e.setName(rslt.getString(2));
				e.setSurname(rslt.getString(3));
				e.setEmail(rslt.getString(4));
				e.setPhone(rslt.getString(5));
				e.setHireDate(rslt.getDate(6));
				e.setJobID(rslt.getString(7));
				e.setSalary(rslt.getDouble(8));
				e.setPct(rslt.getFloat(9));
				e.setManagerID(rslt.getInt(10));
				e.setDepID(rslt.getInt(11));
				
				employees.add(e);
			}
		}finally{
			if(pstatm != null){
				if(rslt != null){
					rslt.close();
				}
				pstatm.close();
			}
		}
		
		return employees;
	}
	
		private ReadJobs job;
		private ReadDepartment dep;
		private PlugToDB conn;
}
