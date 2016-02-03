package assicurazioni;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class Agenzia{
	public Agenzia(){}
	public Agenzia(String nome,String ind, int nbase){
		this.nome = nome;
		this.indirizzo = ind;
		this.base = new PolizzaBase[nbase];
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String n){
		this.nome = n;
	}
	public String getIndirizzo(){
		return indirizzo;
	}
	public void setIndirizzo(String a){
		this.indirizzo = a;
	}
	public boolean aggiungiPolizza(PolizzaBase p){
		for(int i = 0; i < base.length; i++){
			if(base[i] == null){
				base[i] = p;
				return true;
			}
		}
		return false;
	}
	public boolean aggiungiPolizza(PolizzaIncendioFurto p){
		if (p != null){
			pif.add(p);
			return true;
		}
		return false; 
	}
	public double sommaPremiAnnui(){
		double premi = 0D;
		for(int i = 0; i < base.length && base[i] != null; premi += base[i++].premioAnnuale());
		for(PolizzaIncendioFurto p : pif){
			premi += p.premioAnnuale();
		}
		return premi;
	}
	public HashMap<String,Long[]> polizzeRC(){
		HashMap<String,Long[]> map = new HashMap<>();

		int k;
		for(k = 0; k < base.length && base[k] != null; k++);
		Long[] baseRC = new Long[k];
		int i = 0;
		for(PolizzaBase p: base){
			if(p != null){
				baseRC[i++] = p.getRC();
			}
		}
		map.put("PolizzaBase",baseRC);
		baseRC = new Long[pif.size()];
		i = 0;
		for(PolizzaIncendioFurto p: pif){
			baseRC[i++] = p.getRC();
		}
		map.put("PolizzaIncendioFurto",baseRC);
		return map;
	}
	public PolizzaBase cancella(PolizzaBase p){
		PolizzaBase pp= null;
		int i = 0;

		for(;i < base.length && base[i] != null; i++){
			if(base[i].equals(p)){
				pp = base[i];
				base[i] = null;
				break;
			}
		}
		for(int j = i; j < base.length - 1 && base[j+1] != null; j++){
			base[j] = base[j+1];
			base[j+1] = null;
		}
		return pp;
	}
	public PolizzaIncendioFurto cancella(PolizzaIncendioFurto p){
		PolizzaIncendioFurto pResult = null;
		Iterator<PolizzaIncendioFurto> iter = pif.iterator();

		while(iter.hasNext()){
			PolizzaIncendioFurto pp = iter.next();
			if (pp.equals(p)){
				pResult = pp;
				iter.remove();
				break;
			}
		}
		return pResult;
	}
	public List<PolizzaIncendioFurto> getPolizzeIncedioFurto(){
		return pif;
	}
	public String[] targePolizzeBaseRC100(){
		int k = 0;
		for(int i = 0; i < base.length && base[i] != null; i++){
			if (base[i].getRC() > 100){
				k++;
			}
		}
		String[] targe = new String[k];
		int i = 0;
		for(int j = 0; j < base.length && base[j] != null; j++){
			if(base[j].getRC() > 100){
				targe[i++] = base[j].getTarga();
			}
		}
		return targe;
	}
	@Override
	public String toString(){
		return "Agenzia: " + getNome() + "\nIndirizzo" + getIndirizzo();
	}

	private String nome = "No nome";
	private String indirizzo = "No indirizzo";
	private PolizzaBase[] base = null;
	private ArrayList<PolizzaIncendioFurto> pif = new ArrayList<>();
}