package access.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import action.db.Job;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dmike.util.dbms.PlugToDB;

public class ReadJobs {
	public ReadJobs()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
	public ReadJobs(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
	public List<Job> listData(Date d)
		throws SQLException
	{
		ArrayList<Job> jobs = new ArrayList<>();
		PreparedStatement pstatm = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT j.job_id,j.job_title,j.min_salary,j.max_salary\n"+
						"FROM jobs j\n"+
						"WHERE max_salary = (select max(max_salary)\n"+
						"FROM jobs j, job_history jh\n"+
						"WHERE j.job_id = jh.job_id\n"+
						"and ? between jh.start_date and jh.end_date)";
			pstatm = conn.getConnection().prepareStatement(sql);
			pstatm.setDate(1, d);
			
			rslt = pstatm.executeQuery();
			
			while(rslt.next()){
				Job j = new Job();
				
				j.setId(rslt.getString(1));
				j.setTitle(rslt.getString(2));
				j.setMinSalary(rslt.getDouble(3));
				j.setMaxSalary(rslt.getDouble(4));
				
				jobs.add(j);
			}
			
		}finally{
			if(pstatm != null){
				if(rslt != null){
					rslt.close();
				}
				pstatm.close();
			}
		}
		
		return jobs;
	}
	private PlugToDB conn;
}
