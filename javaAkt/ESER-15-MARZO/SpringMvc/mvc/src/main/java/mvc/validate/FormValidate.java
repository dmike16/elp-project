package mvc.validate;

import java.util.ArrayList;
import java.util.List;

import mvc.form.ProductForm;

public class FormValidate {
	public FormValidate(){
		errors = new ArrayList<>();
	}
	
	public List<String> validate(ProductForm obj){
		
		if(obj.getName().isEmpty()){
			errors.add("Campo nome necessario");
		}
		if(obj.getDescription().isEmpty()){
			errors.add("ISBN necessario");
		}
		if(obj.getAuthor().isEmpty()){
			errors.add("Autore non presente");
		}
		
		try{
			Float.parseFloat(obj.getPrice());
		}catch(NumberFormatException e){
			
			errors.add("Prezzo non in formato numerico");
		}
		
		return errors;
	}
	
	private ArrayList<String> errors;
}
