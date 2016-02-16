package cipolla;

public class Department {
	public Department(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMangerID() {
		return mangerID;
	}
	public void setMangerID(int mangerID) {
		this.mangerID = mangerID;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	@Override
	public String toString(){
		return "ID: " + getId() +"\n"+
				"Name: " +getName() + "\n"+
				"Manager ID: " +getMangerID() +"\n"+
				"Locationn ID: " + getLocationID() +"\n";
	}


	private int id;
	private String name;
	private int mangerID;
	private int locationID;
}
