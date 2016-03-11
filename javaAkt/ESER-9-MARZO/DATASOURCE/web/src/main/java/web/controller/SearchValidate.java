package web.controller;

import java.util.ArrayList;
import java.util.List;

import util.SearchForm;
import dmike.util.web.Validator;

public class SearchValidate implements Validator<SearchForm>{

	public SearchValidate(){
		errors = new ArrayList<>();
	}
	
	@Override
	public List<String> validate(SearchForm obj) {
		
		if(obj.getCode().isEmpty() && !obj.getDescribe().matches(".*\\w+?.*")){
			errors.add("Espicitare almeno un campo");
		}
		
		return errors;
	}

	private List<String> errors;
}
