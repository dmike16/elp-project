/**
 * Read data from users table in oracle database user HR host localhost
 * @author dmike
 */
package access.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import action.db.Users;
import action.db.UsersType;
import dmike.util.dbms.PlugToDB;

public class ReadUsers{
	
	public ReadUsers()
		throws SQLException
	{
		conn = PlugToDB.startConnection("localhost","xe","HR","HR8716linUX");
	}
	public ReadUsers(String host,String nameDB,String user,String passw)
			throws SQLException
	{
		conn = PlugToDB.startConnection(host, nameDB, user, passw);
	}
	
	public int insertData(Users user)
		throws SQLException
	{
		int rows = -1;
		PreparedStatement prep = null;
		try{
			String sql = "INSERT INTO users (id,user_name,password, fullname," + 
						"email,salary,user_type) VALUES (?,?,?,?,?,?,?)";
			
			prep = conn.getConnection().prepareStatement(sql);
		
			prep.setInt(1, user.getId());
			prep.setString(2, user.getUserName());
			prep.setString(3, user.getPassw());
			if(user.getName() != null){
				prep.setString(4, user.getName());
			} else {
				prep.setNull(4, Types.NULL);
			}
			
			if(user.getEmail() != null){
				prep.setString(5, user.getEmail());
			} else {
				prep.setNull(5, Types.NULL);
			}
			
			prep.setDouble(6, user.getSalary());
			prep.setInt(7, user.getIdType());
		
			rows = prep.executeUpdate();
		
			}finally{
				if(prep != null){
					prep.close();
				}
			}
		
		return rows;
	}
	
	public int updateData(Users user, String attr, String oper, Object value)
		throws SQLException
	{
		int rows = -1;
		int count = 0;
		String[] attToUpdate = new String[4];
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder = ReadUsers.appendBody(sqlBuilder, "UPDATE users set\n");
		
		
		if(user.getUserName() != null){
			ReadUsers.appendExpression(sqlBuilder, "user_name");
			sqlBuilder.append(",");
			attToUpdate[count++] = user.getUserName();
		}
		
		if(user.getPassw() != null){
			ReadUsers.appendExpression(sqlBuilder, "password");
			sqlBuilder.append(",");
			attToUpdate[count++] = user.getPassw();
		}
		
		if(user.getName() != null){
			ReadUsers.appendExpression(sqlBuilder, "fullname");
			sqlBuilder.append(",");
			attToUpdate[count++] = user.getName();
		}
		
		if(user.getEmail() != null){
			ReadUsers.appendExpression(sqlBuilder, "email");
			sqlBuilder.append(",");
			attToUpdate[count++] = user.getEmail();
		}
		
		ReadUsers.appendExpression(sqlBuilder, "salary");
		count++;
		sqlBuilder.append("\nwhere ");
		sqlBuilder.append(attr);
		sqlBuilder.append(oper);
		sqlBuilder.append("?");
		count++;
		
		PreparedStatement prep = null;
		
		try{
			
			if (count != 0){
				String sql = sqlBuilder.toString();
				
				prep = conn.getConnection().prepareStatement(sql);
				
				prep.setObject(count--, value);
				prep.setDouble(count--, user.getSalary());
				
				for(int i = count; i >= 1; i--){
					prep.setString(i, attToUpdate[i-1]);
				}
				
				rows = prep.executeUpdate();
			}
			
			
		}finally{
			if(prep != null){
				prep.close();
			}
		}
		
		return rows;
	}
	
	public int deleteData(String attr,String oper, Object value)
		throws SQLException
	{
		int rows = -1;
		StringBuilder sqlBuild = new StringBuilder();
		sqlBuild.append("DELETE FROM users\nWhere ");
		sqlBuild.append(attr);
		sqlBuild.append(oper);
		sqlBuild.append("?");
		
		String sql = sqlBuild.toString();
						
		PreparedStatement prep = conn.getConnection().prepareStatement(sql);
		prep.setObject(1, value);
		
		rows = prep.executeUpdate();
			
		
		return rows;
	}
	
	public int insertUsersTypeData(UsersType ut)
		throws SQLException
	{
		int rows = -1;
		
		PreparedStatement prep  = null;
		
		try{
			String sql = "INSERT INTO users_type (user_type,description) VALUES (?,?)";
			
			prep = conn.getConnection().prepareStatement(sql);
			
			prep.setInt(1, ut.getType());
			if(ut.getDescription() != null){
				prep.setString(2, ut.getDescription());
			} else {
				prep.setNull(2, Types.NULL);
			}
			
			rows = prep.executeUpdate();
			
		}finally{
			if(prep != null){
				prep.close();
			}
		}
		
		return rows;
	}
	public int updateUsersTypeData(UsersType ut, String condition)
		throws SQLException
	{
		int rows = -1;
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder = ReadUsers.appendBody(sqlBuilder, "UPDATE users_type set\n");
		
		if (ut.getDescription() != null){
			ReadUsers.appendExpression(sqlBuilder, "description");
			PreparedStatement prep = null;
			try{	
				String sql = sqlBuilder.toString();
				prep = conn.getConnection().prepareStatement(sql);
				
				rows = prep.executeUpdate();
			
			}finally{
				if(prep != null){
					prep.close();
				}
			}
		}
		
		return rows;
	}
	
	public List<Users> listData()
		throws SQLException
	{
		ArrayList<Users> users = new ArrayList<>();
		Statement stat = null;
		ResultSet result = null;
		
		try{
			String sql = "SELECT * FROM users";
			stat = conn.getConnection().createStatement();
			result = stat.executeQuery(sql);
			
			while(result.next()){
				Users u = new Users();
				
				u.setId(result.getInt("id"));
				u.setUserName(result.getString("user_name"));
				u.setPassw(result.getString("password"));
				u.setName(result.getString("fullname"));
				u.setEmail(result.getString("email"));
				u.setSalary(result.getDouble("salary"));
				u.setIdType(result.getShort("user_type"));
				
				users.add(u);
			}
			
		}finally{
			if(stat != null){
				if(result != null){
					result.close();
				}
				stat.close();	
			}
		}
		
		return users;
	}
	
	public Map<UsersType,Integer> groupUsersByType()
		throws SQLException
	{
		
		HashMap<UsersType,Integer> groupsU  = new HashMap<>();
		Statement stat = null;
		ResultSet result = null;
		try{
			String sql = "SELECT t.user_type, t.description, count(*) as qta \n"+
						"FROM users u, users_type t\n" +
						"where u.user_type = t.user_type\n"+
						"group by t.user_type,t.desciption";
			
			stat = conn.getConnection().createStatement();
			result = stat.executeQuery(sql);
			
			while(result.next()){
				UsersType ut = new UsersType();
				
				ut.setType(result.getInt(1));
				ut.setDescription(result.getString(2));
				
				groupsU.put(ut, result.getInt(3));
			}
			
		}finally{
			if(stat != null){
				if(result != null){
					result.close();
				}
				stat.close();
			}
		}
		
		return groupsU;
	}
	public Users getUser(String user)
		throws SQLException
	{
		Users u = new Users();
		PreparedStatement prest = null;
		ResultSet rslt = null;
		String sql = "SELECT * FROM users\n"+
					"WHERE user_name = ?";
		try{
			prest = conn.getConnection().prepareStatement(sql);
			prest.setString(1, user);
			rslt = prest.executeQuery();
			
			while(rslt.next()){
				u.setId(rslt.getInt("ID"));
				u.setName(rslt.getString("fullname"));
				u.setUserName(rslt.getString("user_name"));
				u.setPassw(rslt.getString("password"));
				u.setSalary(rslt.getDouble("salary"));
				u.setEmail(rslt.getString("email"));
				u.setIdType(rslt.getInt("user_type"));
			}
		}finally{
			if(prest != null){
				if(rslt != null){
					rslt.close();
				}
				prest.close();
			}
		}
		return u;
	}
	
	@Override
	public String toString(){
		return ReadUsers.class.getName();
	}
	
	private static StringBuilder appendBody(StringBuilder build,String head){
		
		for(String s : head.split(" ")){
			build.append(s);
			build.append(" ");
		}
		
		return build;
	}
	
	private static StringBuilder appendExpression(StringBuilder build, String expr){
		build.append(expr);
		build.append("=");
		build.append("?");
		build.append(" ");
		
		return build;
	}
	
	private PlugToDB conn = null;
	
}
