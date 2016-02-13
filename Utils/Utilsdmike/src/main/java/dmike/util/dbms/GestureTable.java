package dmike.util.dbms;

import java.util.List;

import dmike.util.inout.StdIO;

public interface GestureTable {
	public static void showData(StdIO std, List<? extends Object> gen){
		if (gen == null)return;
		
		for(Object u: gen){
			std.coutln(u.toString());
		}
	}
	public void openTable(StdIO std);
}
