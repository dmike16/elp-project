package action.db;

import java.sql.SQLException;

import access.db.ReadUsers;
import dmike.util.dbms.GestureTable;
import dmike.util.inout.StdIO;

class UsersTable implements GestureTable{
	void newUser(ReadUsers dbUsers,StdIO std){
		
		try{
			if(dbUsers.insertUsersData(InputAction.readUsers(std)) > 0){
				std.coutln("Utente inserito");
			}else{
				std.coutln("Errore nell'inserimento");
			}
		} catch(SQLException e){
			std.coutln("DB error");
			std.coutln(e.getMessage());
			
		}
	}
	
	@Override
	public void openTable(StdIO std){
		int choice = 0;
		try{
			ReadUsers db = null;
			String msg ="[1] List all Users in table\n"+
					"[2] Insert a new User\n"+
					"[0] Exit";
			std.coutln(msg);
			choice = std.getIntNotNull("Make a Choice");
			boolean exit = false;
			
			if(choice != 0){
				db = new ReadUsers();
			}
		
	loop:	while(!exit){
				switch(choice){
				case 1:
					std.coutln("Complete List of Users");
					GestureTable.showData(std, db.listUsers());
					break;
				case 2:
					std.coutln("Insert a new user");
					newUser(db, std);
					break;
				case 0:
					exit=true;
					break loop;
				default:
					exit=true;
					break loop;
						
				}
				choice = std.getIntNotNull(msg);
			}
		} catch(SQLException e){
			StringBuilder error = new StringBuilder();
			switch(choice){
			case 0:
				error.append("Error in open or close DB\n");
				break;
			case 1:
				error.append("Error in get users rows\n");
				break;
			case 2:
				error.append("Error in insert users rows\n");
				break;
			default:
				std.coutln(e.getMessage());
			}
			error.append(e.getMessage());
			std.coutln(error.toString());
		}
		
	}
}
