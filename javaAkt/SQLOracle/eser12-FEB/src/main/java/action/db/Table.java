package action.db;

import java.sql.SQLException;

import dmike.util.dbms.GestureTable;
import dmike.util.dbms.PlugToDB;
import dmike.util.inout.StdIO;

public class Table {
	public static void selectTable(){
		StdIO std = StdIO.getStdIO();
		int choice = 0;
		String msg = "Select Table\n"+
				"[1] Gesture Users\n" +
				"[2] Gesture Mobili\n"+
				"[3] Gesture Veicoli\n"+
				"[4] Get All Connection\n"+
				"[0] Exit";
		
		try{
			do{
				choice = std.getIntNotNull(msg);
				switch(choice){
				case 1:
					Table.openUser().openTable(std);
					break;
				case 2:
					Table.openItem().openTable(std);
					break;
				case 3:
					Table.openVeicoli().openTable(std);
					break;
				case 0:
					PlugToDB.shutDownConnection();
					return;
				case 4:
					std.coutln(PlugToDB.showConnection().toString());
					break;
				}
			}while(true);
		}catch(SQLException e){
			std.coutln("Error in closing database connection\n"+
					e.getMessage());
		}finally{
			std.close();
		}
	}
	private static GestureTable openUser(){
		return new UsersTable();
	}
	private static GestureTable openItem(){
		return new ItemTable();
	}
	private static GestureTable openVeicoli(){
		return new VeicoliTable();
	}
	private Table(){};
}
