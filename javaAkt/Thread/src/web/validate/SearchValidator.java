package web.validate;

import java.util.ArrayList;
import java.util.List;

public class SearchValidator implements Validator<SearchForm>{

	public SearchValidator(){
		errors = new ArrayList<>();
	}
	
	@Override
	public List<String> validate(SearchForm obj) {
		try{
			int id = Integer.parseInt(obj.getId());
			if(id <= 0){
				errors.add("Id deve essere maggiore di zero");
			}
		}catch(NumberFormatException e){
			errors.add("Id deve essere numerico");
		}
		
		return errors;
	}
	
	private List<String> errors ;
}
