package action.db;

public class Location {
	public Location(){}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCod() {
		return postCod;
	}
	public void setPostCod(String postCod) {
		this.postCod = postCod;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}

	@Override
	public String toString(){
		return "ID: "+ getId()+"\n"+
				"Address: " +getAddress()+" " +getCity()+ "\n"+
				"State: " + getState() +"\n"+
				"PC: " +getPostCod()+ "\n"+
				"C_id: " +getCountryID();
 	}


	private int id;
	private String address;
	private String city;
	private String postCod;
	private String state;
	private String countryID;
}
