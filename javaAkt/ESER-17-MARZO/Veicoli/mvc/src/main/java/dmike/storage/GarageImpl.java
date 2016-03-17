package dmike.storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dmike.domain.Veicol;


@Service
public class GarageImpl implements Garage{
	
	public GarageImpl(){
		this.garage = new ArrayList<>();
		Veicol v = new Veicol();
		v.setTarga("DF789RG");
		v.setModello("Mercedes");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		v.setImm(LocalDate.parse("12/02/2010",formatter));
		this.garage.add(v);
	}

	@Override
	public void insert(Veicol v) {
		this.garage.add(v);
	}

	@Override
	public boolean isEmpty() {
		return this.garage.isEmpty();
	}

	@Override
	public boolean remove(Veicol v) {
		return this.garage.remove(v);
	}

	@Override
	public boolean contains(Veicol v) {
		return this.garage.contains(v);
	}
	
	@Override
	public List<Veicol> get(){
		return garage;
	}
	
	
	private ArrayList<Veicol> garage;
	
}
