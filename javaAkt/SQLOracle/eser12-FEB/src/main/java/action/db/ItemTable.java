package action.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import access.db.ReadCategory;
import access.db.ReadItem;
import dmike.util.dbms.GestureTable;
import dmike.util.inout.StdIO;

class ItemTable implements GestureTable{
	@Override
	public void openTable(StdIO std){
		int choice = 0;
		try{
			ReadItem db = null;
			String msg ="[1] List all Items in table\n"+
					"[2] count by IVA\n"+
					"[3] List Modelli e Fabbrica\n"+
					"[4] List Lab with comp number\n"+
					"[5] List chipset item from a category\n"+
					"[6] Categorie\n"+
					"[0] Back";
			choice = std.getIntNotNull(msg);
						
			if(choice != 0){
				db = new ReadItem();
			}
		
			while(true){
				switch(choice){
				case 1:
					GestureTable.showData(std, db.listData());
					break;
				case 2:
					countItemCatByIva(std,db);
					break;
				case 3: 
					GestureTable.showData(std, db.getModel().listModelliAndFabbriche());
					break;
				case 4:
					GestureTable.showData(std,db.getComponent().contComponentperLab());
					break;
				case 5:
					String cat = std.getStringNotNull("Inserisci categoria");
					GestureTable.showData(std, db.chipestItem(cat));
					break;
				case 6:
					categorie(std,db.getCategory());
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
		}
		
	}
	void countItemCatByIva(StdIO std, ReadItem db){
		std.coutln("Insert a Category in: \n");
		std.coutln("{");
		try{
			List<Category> cat = db.getCategory().listData();
			for(Category c: cat){
				std.coutln(" " + c.getDescription());
			}
			std.coutln("}");
			String description = std.getStringNotNull("Categoria:");
			
			boolean inside = false;
			for(Category c: cat){
				if(c.getDescription().equals(description)){
					inside = true;
					break;
				}
			}
			
			if(inside){
				Map<Integer,Integer> group = db.groupAndCountCatItem(description, "art_iva");
				Set<Integer> iva = group.keySet();
				String fmt = "%-10s | %-10s";
				std.coutln(String.format(fmt, "Iva","Count"));
				fmt = "%-10s  %-10s";
				for(Integer i: iva){
					std.coutln(String.format(fmt, i,group.get(i)));
				}
			}
			else{
				std.coutln("Not in the list");
			}
		}catch(SQLException e){
			std.coutln("Problem in execution of the query\n" +
					e.getMessage());
		}
	}
	void categorie(StdIO std, ReadCategory db){
		int choice;
		String msg = "[1] List Categorie\n"+
					"[2] List Chipser Cat with IVA\n"+
					"[0] Back";
		choice = std.getIntNotNull(msg);
		
		while(true){
			try{
				switch(choice){
				case 1:
					GestureTable.showData(std, db.listData());
					break;
				case 2:
					GestureTable.showData(std, db.listChiperCatWithIva());;
					break;
				case 0:
					return;
				default:
					break;
				}
			}catch(SQLException e){
				std.coutln("Error in DB\n"+
						e.getMessage());
			}
			choice = std.getIntNotNull(msg);
		}
						
	}

}
