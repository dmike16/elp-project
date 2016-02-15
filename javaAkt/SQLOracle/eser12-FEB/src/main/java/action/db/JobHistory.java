package action.db;

import java.util.Date;

public class JobHistory {
	public JobHistory(){}
	
	
	public int getEId() {
		return e_id;
	}
	public void setEId(int e_id) {
		this.e_id = e_id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getJobId() {
		return job_id;
	}
	public void setJobId(String job_id) {
		this.job_id = job_id;
	}
	public int getDepId() {
		return dep_id;
	}
	public void setDepId(int dep_id) {
		this.dep_id = dep_id;
	}
	@Override
	public String toString(){
		return "ID: " + getEId() + "\n"+
				"Start: " + getStart() + "\n"+
				"End: " + getEnd() + "\n"+
				"Job-ID: "+ getJobId()+ "\n"+
				"Dep-ID: " +getDepId();
	}

	private int e_id;
	private Date start;
	private Date end;
	private String job_id;
	private int dep_id;
}
