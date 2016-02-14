package action.db;

import java.sql.SQLException;

import access.db.ReadUsers;
import dmike.util.dbms.GestureTable;
import dmike.util.inout.StdIO;

class UsersTable implements GestureTable{
	void newUser(ReadUsers dbUsers,StdIO std){
		
		try{
			if(dbUsers.insertData(InputAction.readUsers(std)) > 0){
				std.coutln("Utente inserito");
			}else{
				std.coutln("Errore nell'inserimento");
			}
		} catch(SQLException e){
			std.coutln("DB error");
			std.coutln(e.getMessage());
			
		}
	}

	void modifyUsers(ReadUsers db, StdIO std){
		int choice;
		do{
			try{
				String userName = std.getStringNotNull("Insert user name: ");
				Users ou = db.getUser(userName);
				std.coutln("Your user is\n" + ou.toString());
				choice = std.getIntNotNull("[1] Change current user password\n"+
											"[2] Delete current user\n"+
											"[0] Back");
				if(choice != 0){
					
				}
				switch(choice){
				case 1:
					Users nu = new Users();
					nu.setPassw(std.getStringNotNull("Insert new passw: "));
					if((db.updateData(nu,"user_name","=",userName)) > 0){
						std.coutln("Password UPDATE WITH SUCCESS!!!!");
					}else{
						std.coutln("NOT ABLE TO UDPATE!!!");
					}
					
					break;
				case 2:
					String  resp = std.getStringNotNull("Are you sure? [y/n]");
					if(resp.equals("y")){
						if((db.deleteData("user_name","=",userName)) > 0){
							std.coutln("Utente cancellato");
						}
					}
					break;
				case 0:
					return;
				default:
					break;
				}
			}catch(SQLException | NullPointerException  e){
				std.coutln("Error in conunicate with DB\n" +
						e.getMessage());
				choice = std.getIntNotNull("[1] Retry\n"+
											"[0] Back");
				if(choice != 1){
					return;
				}
			}
			
		}while(true);
	}
	
	
	
	@Override
	public void openTable(StdIO std){
		int choice = 0;
		try{
			ReadUsers db = null;
			String msg ="[1] List all Users in table\n"+
					"[2] Insert a new User\n"+
					"[3] Modify User\n"+
					"[0] Back";
			
			choice = std.getIntNotNull(msg);
						
			if(choice != 0){
				db = new ReadUsers();
			}
		
			while(true){
				switch(choice){
				case 1:
					GestureTable.showData(std, db.listData());
					break;
				case 2:
					newUser(db, std);
					break;
				case 3: 
					modifyUsers(db,std);
					break;
				case 0:
					return;
				default:
					break;
						
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
			default:
				std.coutln(e.getMessage());
			}
			error.append(e.getMessage());
			std.coutln(error.toString());
		}
		
	}
}
