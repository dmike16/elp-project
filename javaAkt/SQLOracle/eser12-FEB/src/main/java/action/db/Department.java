package action.db;

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
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public int getlID() {
		return lID;
	}
	public void setlID(int lID) {
		this.lID = lID;
	}

	@Override
	public String toString(){
		return "ID: " + getId() +"\n"+
				"Name: " + getName() +"\n"+
				"Man_ID: " +getmID() + "\n"+
				"Loc_ID: " + getlID();
	}
	private int id;
	private String name;
	private int mID;
	private int lID;
}
