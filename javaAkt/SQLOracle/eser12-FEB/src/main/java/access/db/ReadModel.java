package access.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import action.db.Fabbrica;
import action.db.Modello;
import dmike.util.dbms.PlugToDB;

public class ReadModel {
	public ReadModel()
			throws SQLException
		{
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadModel(String host,String db, String user, String passw)
			throws SQLException
		{
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		public List<Modello> listModelliAndFabbriche()
			throws SQLException
		{
			ArrayList<Modello> modelli = new ArrayList<>();
			
			Statement stat = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT cod_modello,nome_modello,numero_versioni,m.cod_fabbrica, f.nome_fabbrica\n"+
							"FROM modelli m, fabbriche f\n "+
							"WHERE m.cod_fabbrica = f.cod_fabbrica";
				stat = conn.getConnection().createStatement();
				rslt = stat.executeQuery(sql);
				
				while(rslt.next()){
					ModelloFabbrica mf = new ModelloFabbrica();
					
					mf.setCod(rslt.getString("cod_modello"));
					mf.setCodFabbrica(rslt.getString("cod_fabbrica"));
					mf.setNome(rslt.getString("nome_modello"));
					mf.setVersion(rslt.getInt("numero_versioni"));
					
					Fabbrica fabb= ModelloFabbrica.getFabbFromCache(modelli,rslt.getString("nome_fabbrica"));
					
					if(fabb.getCod() == null){
						fabb.setCod(mf.getCodFabbrica());
						fabb.setNome(rslt.getString(5));
					}
					mf.setFabb(fabb);
					
					modelli.add(mf);
					
				}
			}finally{
				if(stat != null){
					if(rslt != null){
						rslt.close();
					}
					stat.close();
				}
			}
			
			return modelli;
		}
		
		
		private static class ModelloFabbrica extends Modello{
			 ModelloFabbrica(){
				super();
			}
			public Fabbrica getFabb(){
				return fabb;
			}
			public void setFabb(Fabbrica f){
				fabb = f;
			}
			protected static Fabbrica getFabbFromCache(List<Modello> mod,String cod){
				for(Modello m: mod){
					if(m.getCodFabbrica().equals(cod)){
						return ((ModelloFabbrica)m).getFabb();
					}
				}
				return new Fabbrica();
			}
			@Override
			public String toString(){
				return super.toString()+"\n"+
						"Fabbrica: " + this.fabb.getNome()+"\n";	
			}
			private Fabbrica fabb;
		}
		private PlugToDB conn;
}
