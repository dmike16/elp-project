/**
 * Class that store values from uesrs_type object schema
 * @author dmike
 */
package action.db;

public class UsersType {
	public UsersType(){}
	
	public int getType(){
		return type;
	}
	public void setType(int t){
		type = t;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String s){
		description = s;
	}
	
	@Override
	public String toString(){
		return "Id Type: " + type + "\n" +
				"Descr: " + description + "\n";
	}
	
	private int type;
	private String description;
}
