package web.validate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import web.model.BooksDb;
import web.model.DbPool;

public class BookValidator implements Validator<BookForm>{
	
	
	public BookValidator(){
		errors = new ArrayList<>();
	}
	
	@Override
	public List<String> validate(BookForm obj){
		//TODO
		
		try{
			int id = Integer.parseInt(obj.getId());
			if(id <= 0){
				errors.add("Id deve essere superiore a zero");
			} else if( id > 999){
				errors.add("Id deve essere di max 3 cifre");
			}
		}catch(NumberFormatException e){
			errors.add("Id deve essere numerico");
		}
		
		if(obj.getTitle().length() < 5){
			errors.add("Il titolo deve essere di minimo 5 caratteri");
		}
		if(obj.getAuthor().length() < 5){
			errors.add("Il nome dell autore deve essere di minimo 5 caratteri");
		}
		
		DbPool db = null;
		
		try{
			db = new DbPool();
			BooksDb bookDb = new BooksDb();
			
			if(bookDb.searchByTitle(db,obj.getTitle())){
				errors.add("Titolo del libro già presente");
			}
			if(bookDb.booksNumberPerAuthor(db, obj.getAuthor()) > 10){
				errors.add("L'autore  " + obj.getAuthor()+" ha gia 10 libri");
			}
			
		}catch(Exception e){
			errors.add(e.getMessage());
		}finally{
			if(db != null){
				try{
					db.pushConnection();
				}catch(SQLException e){
					errors.add(e.getMessage());
				}
			}
		}
		
		return errors;
	}
	
	private List<String> errors;

}
