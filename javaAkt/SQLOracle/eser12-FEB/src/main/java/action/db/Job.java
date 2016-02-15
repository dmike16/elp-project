package action.db;

public class Job {
	public Job(){}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	@Override
	public String toString(){
		return "ID: " + getId() +"\n"+
				"Title: " +getTitle()+"\n"+
				"MaxSalary: " +String.format("%.2f", getMaxSalary())+ "\n"+
				"MinSalary: " +String.format("%.2f", getMinSalary());
	}

	private String id;
	private String title;
	private double maxSalary;
	private double minSalary;
}
