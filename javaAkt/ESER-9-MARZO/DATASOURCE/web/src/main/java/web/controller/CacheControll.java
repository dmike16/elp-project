package web.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import util.Articol;
import web.db.ArticolDb;

public class CacheControll{
	
	public static CacheControll createCache(HttpSession session)
		throws SQLException, NamingException
	{
		ArticolDb adb = null;
		CacheControll codes;
		
		try{
			codes = (CacheControll) session.getAttribute("codes");
			
			if(codes == null){
				adb = new ArticolDb();
				
				codes = new CacheControll();
				codes.fillCache(adb.findAll());
				session.setAttribute("codes", codes);
			}
			
		}finally{
			if(adb != null){
				adb.dispose();
			}
		}
		
		return codes;
	}
	
	public CacheControll(){
		cache = new HashMap<>();
	}
	public Map<String,Integer> getCache(){
		return cache;
	}
	public void gesture(String code){
		if(cache.containsKey(code)){
			cache.remove(code);
		}
	}
	public void gesture(String code, int qty){
		if(cache.containsKey(code)){
			int tmp = cache.get(code);
			cache.put(code,tmp + qty);
		}else{
			cache.put(code, qty);
		}
	}
	public void fillCache(List<Articol> arts){
		for(Articol art: arts){
			cache.put(art.getCode(), art.getInstock());
		}
	}
	
	@Override
	public String toString(){
		return cache.toString();
	}
	private HashMap<String,Integer> cache = null;
}
