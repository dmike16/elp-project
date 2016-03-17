package dmike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dmike.storage.Garage;
import dmike.domain.Veicol;

@Controller
public class GarageController {
	
	@ModelAttribute("garage")
	public Garage listGarage(){
		return this.garage;
	}
	
	@RequestMapping("garage_list.action")
	public String garageList(){
		return "garage";
	}
	
	@RequestMapping(path = "garage_insert.action",method=RequestMethod.GET)
	public String insert(@ModelAttribute("veicol") Veicol veicol){
		return "into";
	}
	@RequestMapping(path ="garage_insert.action",method=RequestMethod.POST)
	public String insert(@ModelAttribute("veicol")Veicol veicol, BindingResult errors, Model model){
		//TODO
		String jsp = "redirect:garage_list.action";
		if(errors.hasErrors()){
			jsp="into";
		}
		return jsp;
	}
	
	@Autowired
	private Garage garage;
}
