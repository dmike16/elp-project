package action.db;

public class Category {
	public Category(){}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "Cod: " + getCod() + "\n"+
				"Descr: " + getDescription();
	}
	
	private String cod;
	private String description;
}
