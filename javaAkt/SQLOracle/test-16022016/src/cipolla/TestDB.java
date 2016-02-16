package cipolla;

import java.sql.Date;
import java.sql.SQLException;

public class TestDB {
	public static void main(String[] args){
		LeggiDB db = null;
		StdIO std = StdIO.getStdIO();
		try{
			db = new LeggiDB("HR","localhost","xe","HR8716linUX");
			std.coutln("Query numero 1");
			for(Department d: db.listAllDepartment()){
				std.coutln(d.toString());
			}
			
			std.coutln("Query numero 2");
			for(NumberEmployeeDepartment ne: db.listAllDepartment(std.getDoubleNotNull("Inserisci salario"))){
				std.coutln(ne.toString());
			}
			
			std.coutln("Query numero 3");
			Date d = new Date(std.getDateNotNull("Inserisci una data").getTime());
			for(Negozio n: db.listNegozi(d)){
				std.coutln(n.toString());
			}
			
			std.coutln("Query numero 4");
			for(Veicolo v: db.listVeicoli(std.getIntNotNull("Inserisci cc"))){
				std.coutln(v.toString());
			}
			
			std.coutln("Query numero 5");
			Date dm = new Date(std.getDateNotNull("Inserisci una date").getTime());
			for(EmployeeWithManager em: db.listEmployeeManager(dm)){
				std.coutln(em.toString());
			}
			
			std.coutln("Tutto Okay");
			
		}catch(SQLException e){
			std.coutln("Error in DB operation\n"+
					e.getMessage());
		}catch(NotValidDateException e){
			std.coutln("Format Date not valid\n"+
					e.getMessage());
		}
		finally{
			try{
				db.dispose();
			}catch(SQLException e){
				std.coutln("Erro closing DB\n"+
						e.getMessage());
			}
			std.close();
		}
	}
}
