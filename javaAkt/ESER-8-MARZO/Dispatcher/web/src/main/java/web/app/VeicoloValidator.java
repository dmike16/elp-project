package web.app;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import utils.app.VeicoloForm;
import web.validate.Validator;

public class VeicoloValidator implements Validator<VeicoloForm>{
	@Override
	public List<String> validate(VeicoloForm vf){
		
		if(vf.getTarga().trim().isEmpty()){
			errors.add("Targa non inserita");
		}
		if(vf.getModello().trim().isEmpty()){
			errors.add("Modello non inserito");
		}
		if(vf.getKw().equals("0") || vf.getKw().isEmpty()){
			errors.add("Kw non possono essere zero");
		}
		try{
			LocalDate.parse(vf.getImmatricolazione());
		}catch(DateTimeParseException e){
			errors.add("Data nel formato sbagliato");
		}
		
		return errors;
	}
	public List<String> getErrors(){
		return errors;
	}
	private ArrayList<String> errors = new ArrayList<>();
}
