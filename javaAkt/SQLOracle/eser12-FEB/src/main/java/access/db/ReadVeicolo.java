package access.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import action.db.Veicoli;
import dmike.util.dbms.PlugToDB;

public class ReadVeicolo {
	public ReadVeicolo()
			throws SQLException
		{
			prop = new ReadProprieta();
			conn = PlugToDB.startConnection("localhost", "xe", "HR", "HR8716linUX");
		}
		public ReadVeicolo(String host,String db, String user, String passw)
			throws SQLException
		{
			prop = new ReadProprieta();
			conn = PlugToDB.startConnection(host, db, user, passw);
		}
		public ReadProprieta getProprieta(){
			return prop;
		}
		public List<Veicoli> listData()
				throws SQLException
			{
				ArrayList<Veicoli> items = new ArrayList<>();
				Statement stat = null;
				ResultSet rslt = null;
				
				try{
					String sql = "select * from veicoli";
				
					stat = conn.getConnection().createStatement();
					rslt = stat.executeQuery(sql);
				
					while(rslt.next()){
						Veicoli v = new Veicoli();
					
						v.setTarga(rslt.getString(1));
						v.setCilindrata(rslt.getInt(2));
						v.setKw(rslt.getFloat(3));
						v.setVel(rslt.getFloat(4));
						v.setPosti(rslt.getInt(5));
						v.setImm(rslt.getDate(6));
						v.setCat(rslt.getString(7));
						v.setComb(rslt.getString(8));
						v.setMod(rslt.getString(9));
											
						items.add(v);
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
		public int maxCilindrata(String fabbrica)
			throws SQLException
		{
			int result = 0;
			
			PreparedStatement pstatm = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT max(cilindrata)\n"+
						"FROM veicoli v, modelli m, fabbriche f\n"+
						"WHERE v.cod_modello = m.cod_modello\n"+
						"and m.cod_fabbrica = f.cod_fabbrica\n"+
						"and f.nome_fabbrica = ?";
				pstatm = conn.getConnection().prepareStatement(sql);
				pstatm.setString(1, fabbrica.toUpperCase());
				
				rslt = pstatm.executeQuery();
				
				while(rslt.next()){
					result = rslt.getInt(1);
				}
			}finally{
				if(pstatm != null){
					if(rslt != null){
						rslt.close();
					}
					pstatm.close();
				}
			}
			
			return result;
		}
		public int totalVersioni()
			throws SQLException
		{
			int total=0;
			
			Statement stmt = null;
			ResultSet rslt = null;
			
			try{
				String sql = "SELECT sum(numero_versioni) FROM modelli\n"+
						"WHERE cod_fabbrica = (SELECT max(cod_fabbrica) from fabbriche)";
				stmt = conn.getConnection().createStatement();
				rslt = stmt.executeQuery(sql);
				
				while(rslt.next()){
					total = rslt.getInt(1);
				}
			
			}finally{
				if(stmt != null){
					if(rslt != null){
						rslt.close();
					}
					stmt.close();
				}
			}
			
			return total;
		}
		public int updateData(Veicoli v)
			throws SQLException
		{
			int rows = -1;
			
			PreparedStatement pstmt = null;
			try{
				String sql = "INSERT INTO veicoli(targa,cilindrata,cavalli_fiscali,velocita,posti,immatricolazione,"+
					"cod_categoria,cod_combustibile,cod_modello) VALUES (?,?,?,?,?,?,?,?,?)";
				
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, v.getTarga());
				pstmt.setInt(2, v.getCilindrata());
				pstmt.setFloat(3,v.getKw());
				pstmt.setFloat(4, v.getVel());
				pstmt.setInt(5, v.getPosti());
				pstmt.setDate(6, new Date(v.getImm().getTime()));
				pstmt.setString(7, v.getCat());
				pstmt.setString(8, v.getComb());
				pstmt.setString(9, v.getMod());
				
				rows = pstmt.executeUpdate();
			}finally{
				if(pstmt != null){
					PlugToDB.closeStatement(pstmt);
				}
			}
			
			return rows;
		}
		private PlugToDB conn;
		private ReadProprieta prop;
}
