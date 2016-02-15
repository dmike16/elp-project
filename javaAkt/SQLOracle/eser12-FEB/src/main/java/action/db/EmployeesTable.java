package action.db;

import java.sql.Date;
import java.sql.SQLException;

import access.db.ReadDepartment;
import access.db.ReadEmployees;
import access.db.ReadJobs;
import dmike.util.dbms.GestureTable;
import dmike.util.inout.NotValidDateException;
import dmike.util.inout.StdIO;

public class EmployeesTable implements GestureTable{
	@Override
	public void openTable(StdIO std){
		int choice = 0;
		try{
			ReadEmployees db = null;
			String msg ="[1] Department\n"+
						"[2] History Job\n"+
						"[3] List emplo with salary > avg(salary) and job wiht max_s > value\n"+
						"[0] Back";
			choice = std.getIntNotNull(msg);
						
			if(choice != 0){
				db = new ReadEmployees();
			}
		
			while(true){
				switch(choice){
				case 1:
					departmentGesture(std,db.getDepartment());
					break;
				case 2:
					jobs(std,db.getJob());
					break;
				case 3:
					GestureTable.showData(std, db.listDate(
							std.getDoubleNotNull("Insert max salary")));
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
	void departmentGesture(StdIO std,ReadDepartment db){
		int choice;
		String msg = "[1]List Department,Location and empl number tha worked in a specific date\n"+
			    "[0]Back";
		choice = std.getIntNotNull(msg);
		while(true){
			try{
				switch(choice){
				case 1:
					long mill = InputAction.insertDate(std).getTime();
					GestureTable.showData(std,db.listDepartmentLocationCountEmployee(
							new Date(mill)));
					break;
				case 0:
					return;
				default:
					break;
				}
			}catch(SQLException e){
				std.coutln("Error in db\n"+
						e.getMessage());
			}catch(NotValidDateException e){
				std.coutln("Date Format non Valid\n"+
						e.getMessage());
			}
			choice = std.getIntNotNull(msg);
		}
	}
	
	void jobs(StdIO std, ReadJobs db){
		int choice;
		String msg = "[1] List job in history with max salry\n"+
					"[0]Back";
		choice = std.getIntNotNull(msg);
		while(true){
			try{
				switch(choice){
				case 1:
					long mill = InputAction.insertDate(std).getTime();
					GestureTable.showData(std,db.listData(new Date(mill)));
					break;
				case 0:
					return;
				default:
					break;
				}
			}catch(SQLException e){
				std.coutln("Error in db\n"+
						e.getMessage());
			}catch(NotValidDateException e){
				std.coutln("Date not valid format\n"+
						e.getMessage());
			}
			
			choice = std.getIntNotNull(msg);
		}
	}
	

}
