package action.db;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import access.db.ReadVeicolo;
import dmike.util.dbms.GestureTable;
import dmike.util.inout.NotValidDateException;
import dmike.util.inout.StdIO;

public class VeicoliTable implements GestureTable{
	@Override
	public void openTable(StdIO std){
		int choice = 0;
		try{
			ReadVeicolo db = null;
			String msg ="[1] List all Veicol in table\n"+
					"[2] Ownership secion\n"+
					"[3] Find max cc\n"+
					"[4] Find total Versioni fabbricate dal max fabb_cod\n"+
					"[5] Insert new Veicolo\n"+
					"[0] Back";
			choice = std.getIntNotNull(msg);
						
			if(choice != 0){
				db = new ReadVeicolo();
			}
		
			while(true){
				switch(choice){
				case 1:
					GestureTable.showData(std, db.listData());
					break;
				case 2:
					ownerShipSection(std,db);
					break;
				case 3:
					String fabb = std.getStringNotNull("Inserisci fabbrica");
					std.coutln("Max cc veicolo costruito in "+fabb+" è " + 
							db.maxCilindrata(fabb));
					break;
				case 4:
					std.coutln("Verioni totali : " + db.totalVersioni());
					break;
				case 5:
					if((db.updateData(InputAction.insertVeicoli(std))) > 0){
						std.coutln("Veicolo Inserito Correttamente");
					}else{
						std.coutln("Mancato inserimento");
					}
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
				error.append("Error in get Items rows\n");
				break;
			default:
				std.coutln(e.getMessage());
			}
			error.append(e.getMessage());
			std.coutln(error.toString());
		}catch(NotValidDateException e){
			std.coutln("Invalid format data" +
					e.getMessage());
		}
		
	}
	void ownerShipSection(StdIO std, ReadVeicolo db){
		int choice;
		String msg ="[1] List Proprieta\n"+
				 	"[2] Find Veicolo and Owner by Date\n"+
					"[0] Back";
		choice = std.getIntNotNull(msg);
		while(true){
			try{
				switch(choice){
				case 1:
					GestureTable.showData(std, db.getProprieta().listData());
					break;
				case 2:
					List<Proprieta> plist;
					long mill = InputAction.insertDate(std).getTime();
					plist = db.getProprieta().findDateByDate(new Date(mill));
					for(Proprieta p: plist){
						std.coutln(p.toString(true));
					}
				case 0:
					return;
				default:
					break;
				}
			}catch(SQLException e){
				std.coutln("Error in db:\n" +
							e.getMessage());
			}catch(NotValidDateException e){
				std.coutln("Invalid format data" +
						e.getMessage());
			}
			choice = std.getIntNotNull(msg);
		}
	}
}
