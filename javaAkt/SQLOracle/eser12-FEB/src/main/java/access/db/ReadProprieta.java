package access.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import action.db.Proprieta;
import action.db.Proprietario;
import action.db.Veicoli;
import dmike.util.dbms.PlugToDB;

public class ReadProprieta {
	public ReadProprieta()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadProprieta(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		public List<Proprieta> listData()
				throws SQLException
			{
				ArrayList<Proprieta> items = new ArrayList<>();
				Statement stat = null;
				ResultSet rslt = null;
				
				try{
					String sql = "select * from proprieta";
				
					stat = conn.getConnection().createStatement();
					rslt = stat.executeQuery(sql);
				
					while(rslt.next()){
						Proprieta p = new Proprieta();
						Veicoli v = new Veicoli();
						v.setTarga(rslt.getString(1));
						p.setVel(v);
						
						Proprietario pp = new Proprietario();
						pp.setCod(rslt.getString(2));
						
						p.setPerson(pp);
						p.setAcquisto(rslt.getDate(3));
						p.setVendita(rslt.getDate(4));
											
						items.add(p);
					}
				}finally{
					if(stat != null){
						if(rslt != null){
							rslt.close();
						}
						stat.close();
					}
				}
				
				return items;
			}
		public List<Proprieta> findDateByDate(Date data)
			throws SQLException
		{
			ArrayList<Proprieta> list = new ArrayList<>();
			PreparedStatement prestmt =  null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT targa_veicolo,nome,cognome, data_acquisto,data_vendita \n "+
							"FROM proprieta p , proprietari pp\n"+
							"WHERE p.cod_proprietario = pp.cod_proprietario\n"+
								"and ? between data_acquisto and data_vendita";
				prestmt = conn.getConnection().prepareStatement(sql);
				prestmt.setDate(1, data);
				
				rslt = prestmt.executeQuery();
				
				while(rslt.next()){
					Proprieta p = new Proprieta();
					Veicoli v = new Veicoli();
					Proprietario pp = new Proprietario();
					
					v.setTarga(rslt.getString(1));
					pp.setCognome(rslt.getString(3));
					pp.setNome(rslt.getString(2));
					p.setVel(v);
					p.setPerson(pp);
					p.setAcquisto(rslt.getDate(4));
					p.setVendita(rslt.getDate(5));
					
					list.add(p);
					
				}
			}finally{
				if(prestmt != null){
					if(rslt != null){
						rslt.close();
					}
					prestmt.close();
				}
			}
			
			
			return list;
		}
		
	private PlugToDB conn;	
}
