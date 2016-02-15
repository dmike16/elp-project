package action.db;

import java.util.Date;

import dmike.util.inout.NotValidDateException;
import dmike.util.inout.StdIO;

class InputAction {
	public static Users readUsers(StdIO std){
		Users u = new Users();
		
		u.setId(std.getIntNotNull("Inserisci ID"));
		u.setEmail(std.getStringNotNull("Inserisci email"));
		u.setName(std.getStringNotNull("Name"));
		u.setUserName(std.getStringNotNull("User Name"));
		u.setPassw(std.getStringNotNull("Password"));
		u.setSalary(std.getDoubleNotNull("Salary"));
		u.setIdType(std.getIntNotNull("Id Type"));
		
		return u;
		
	}
	public static Date insertDate(StdIO std)
		throws NotValidDateException
	{
		return std.getDateNotNull("Dammi una date");
	}
}
