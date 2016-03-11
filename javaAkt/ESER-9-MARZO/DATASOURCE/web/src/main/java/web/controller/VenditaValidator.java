package web.controller;

import java.util.ArrayList;
import java.util.List;

import util.VenditaForm;

public class VenditaValidator implements dmike.util.web.Validator<VenditaForm>{

	public VenditaValidator(){
		errors = new ArrayList<>();
	}
	@Override
	public List<String> validate(VenditaForm obj) {
		try{
			Integer.parseInt(obj.getQty());
		}catch(NumberFormatException e){
			errors.add("Quantita deve essere un numero");
		}
		
		if(obj.getBill().isEmpty()){
			errors.add("Numero ricevuta è necessario");
		}else if(obj.getBill().length() > 5){
			errors.add("Max 5 cifre");
		}
		return errors;
	}
	private List<String> errors ;

}
