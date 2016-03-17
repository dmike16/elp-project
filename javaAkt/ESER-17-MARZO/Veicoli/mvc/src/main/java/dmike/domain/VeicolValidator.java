package dmike.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VeicolValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Veicol.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Veicol veicol = (Veicol) target;
		ValidationUtils.rejectIfEmpty(errors, "targa", "targa.empty");
		ValidationUtils.rejectIfEmpty(errors, "modello", "modello.empty");
		ValidationUtils.rejectIfEmpty(errors, "imm", "imm.empty");
		
		int pst = veicol.getPosti();
		if(pst < 0 || pst > 7){
			errors.rejectValue("posti", "posti.invalid");
		}
		
		if(veicol.getMaxVel() < 50){
			errors.reject("maxVel","vel.notReal");
		}
		
		if(veicol.getCilindrata() < 20){
			errors.reject("cilindrata", "cilindrato.notReal");
		}
	}

}
