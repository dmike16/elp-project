package web.validate;

import java.util.ArrayList;
import java.util.List;

public class AuthorValidate implements Validator<AuthorForm>{

	public AuthorValidate(){
		errors = new ArrayList<>();
	}
	
	@Override
	public List<String> validate(AuthorForm obj) {
		if(obj.getName().length() <5){
			errors.add("Nome troppo corto");
		}
		return errors;
	}
	
	private List<String> errors;

}
