package cipolla;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LeggiDB {
	public LeggiDB(String user,String host,String nDB, String passwd)
		throws SQLException
	{
		String dbURL = "jdbc:oracle:thin:"+"@"+host+":1521:"+nDB;
		conn = DriverManager.getConnection(dbURL,user,passwd);
	}
	
	public List<Department> listAllDepartment()
		throws SQLException
	{
		ArrayList<Department> departmens = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT * from departments\n"+
					"ORDER BY location_id";
			stmt = conn.createStatement();
			rslt = stmt.executeQuery(sql);
			
			while(rslt.next()){
				Department d = new Department();
				
				d.setId(rslt.getInt(1));
				d.setName(rslt.getString(2));
				d.setMangerID(rslt.getInt(3));
				d.setLocationID(rslt.getInt(4));
				
				departmens.add(d);
			}
		}finally{
			if( stmt != null){
				if(rslt != null){
					rslt.close();
				}
				stmt.close();
			}
		}
		return  departmens;
	}
	
	public List<NumberEmployeeDepartment> listAllDepartment(double d)
		throws SQLException
	{
		ArrayList<NumberEmployeeDepartment> deps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		
		try{
			String sql = "SELECT d.department_id,count(*)\n"+
					"FROM employees e, departments d\n"+
					"WHERE e.department_id = d.department_id\n"+
					"and e.salary > ?\n"+
					"GROUP BY d.department_id\n"+
					"ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, d);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				NumberEmployeeDepartment nd = new NumberEmployeeDepartment();
				
				nd.setDepartmentID(rslt.getInt(1));
				nd.setNumberEmployees(rslt.getInt(2));
				
				deps.add(nd);
			}
			
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		
		return deps;
	}
	public List<Negozio> listNegozi(Date d)
		throws SQLException
	{
		ArrayList<Negozio> negozi = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT n.neg_cod,n.neg_nome,n.neg_indirizzo,n.neg_citta,n.neg_telefono\n"+
					"FROM negozi n, ordini od\n"+
					"WHERE n.neg_cod = od.neg_cod\n"+
					"and od.ord_data > ?\n"+
					"ORDER BY n.neg_citta,n.neg_nome";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, d);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				Negozio n = new Negozio();
				
				n.setId(rslt.getString(1));
				n.setName(rslt.getString(2));
				n.setIndirizzo(rslt.getString(3));
				n.setCitta(rslt.getString(4));
				n.setTelefono(rslt.getString(5));
				
				negozi.add(n);
			}
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return negozi;
	}
	
	public List<Veicolo> listVeicoli(int cilindrata)
		throws SQLException
	{
		ArrayList<Veicolo> veicoli = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT v.targa,v.cilindrata,v.cavalli_fiscali,v.velocita,"+
					"v.posti,v.immatricolazione,v.cod_categoria,v.cod_combustibile,"+
					"v.cod_modello,ca.nome_categoria From Veicoli v, Categorie_Auto ca \n"+
					"WHERE v.cod_categoria = ca.cod_categoria\n"+
					"and v.cilindrata < ? and v.posti = ("+
					"SELECT max(posti) from veicoli)\n"+
					"ORDER BY v.cod_categoria";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cilindrata);
			
			rslt = pstmt.executeQuery();
			
			while(rslt.next()){
				Veicolo v = new Veicolo();
				
				v.setTarga(rslt.getString(1));
				v.setCilindrata(rslt.getInt(2));
				v.setKw(rslt.getFloat(3));
				v.setVelocita(rslt.getFloat(4));
				v.setPosti(rslt.getInt(5));
				v.setImmatricolazione(rslt.getDate(6));
				v.setCodCat(rslt.getString(7));
				v.setCodComb(rslt.getString(8));
				v.setCodMod(rslt.getString(9));
				v.setCategoria(categoriaCached(veicoli,v.getCodCat(),rslt.getString(10)));
				
				veicoli.add(v);
				
			}
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return veicoli;
	}
	
	public List<EmployeeWithManager> listEmployeeManager(Date d)
		throws SQLException
	{
		ArrayList<EmployeeWithManager> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try{
			String sql = "SELECT e.first_name,e.last_name,m.first_name,m.last_name,m.hire_date\n"+
					"FROM employees e, employees m\n"+
					"WHERE e.manager_id = m.employee_id\n"+
					"and m.hire_date  > ?\n"+
					"ORDER BY e.last_name,e.first_name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, d);
			
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				EmployeeWithManager em = new EmployeeWithManager();
				
				em.setEmplName(rslt.getString(1));
				em.setEmplLast(rslt.getString(2));
				em.setManaName(rslt.getString(3));
				em.setManaLast(rslt.getString(4));
				em.setManaHireDate(rslt.getDate(5));
				
				list.add(em);
			}
			
		}finally{
			if(pstmt != null){
				if(rslt != null){
					rslt.close();
				}
				pstmt.close();
			}
		}
		
		return list;
		
	}
	
	public void dispose()
		throws SQLException
	{
		conn.close();
	}
	
	private Categoria categoriaCached(List<Veicolo> veicoli,String codCat,String descr){
		for(Veicolo v: veicoli){
			if(v.getCategoria().getCod().equals(codCat)){
				return v.getCategoria();
			}
		}
		return new Categoria(codCat,descr);
		
	}
	private Connection conn;
	
}
