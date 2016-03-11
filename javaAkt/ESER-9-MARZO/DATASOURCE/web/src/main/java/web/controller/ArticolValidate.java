package web.controller;


import java.util.ArrayList;
import java.util.List;

import util.ArticolForm;

public class ArticolValidate implements dmike.util.web.Validator<ArticolForm>{
	
	public ArticolValidate(){
		errors = new ArrayList<>();
	}
	public List<String> getErrors(){
		return errors;
	}
	
	@Override
	public List<String> validate(ArticolForm af){
		
		if(af.getCode().isEmpty()){
			errors.add("Codice prodotto richiesto");
		}
		if(af.getCode().matches("[^\\dA-Za-z]+")){
			errors.add("Ammessi solo caratteri alpha-numerici");
		}
		if(af.getCode().length() != 6){
			errors.add("Il codice deve essere di 6 caratteri");
		}
		if(af.getDescribe().isEmpty()){
			af.setDescribe("No Description");
		}else {
			String stripHtml = af.getDescribe().replaceAll("\\<.*?>", "");
			af.setDescribe(stripHtml);
		}
		
		try{
			Float.parseFloat(af.getPrice());
		}catch(NumberFormatException e){
			errors.add("price: " + e.getMessage());
		}
		
		try{
			Integer.parseInt(af.getInstock());
		}catch(NumberFormatException e){
			errors.add("instock" + e.getMessage());
		}
	
		return errors;
	}
	
	private List<String> errors;
}
