package dominio;

public abstract class Veicolo implements Comparable<Veicolo> {
	public Veicolo(String marca,String mod,String col, double costo){
		this.marca = marca;
		this.modello = mod;
		this.colore = col;
		this.costo = costo;
	}
	public String getMarca(){
		return marca;
	}
	public String getColore(){
		return colore;
	}
	public boolean isDisponibile(){
		return disponibilita;
	}
	public void setDisponibile(boolean b){
		this.disponibilita = b;
	}
	public double getCosto(){
		return costo;
	}
	@Override
	public String toString(){
		return "Marca: " + getMarca() +"\n Colore: " + getColore() +
		"\n Cost/gg: " + String.format("%.2f",getCosto()) + " \n" + 
		(isDisponibile()? "":"Non ") + " disponibile";

	}
	@Override
	public int compareTo(Veicolo v){
		if (v == null){
			throw new NullPointerException("compareTo don't allow null ref");
		}
		if(this instanceof VeicoloAMotore && v instanceof Bicicletta){
			return 1;
		}else if (this instanceof Bicicletta && v instanceof VeicoloAMotore){
			return -1;
		}else {
			if (this.getCosto() > v.getCosto()){
				return 1;
			} else if(this.getCosto() < v.getCosto()){
				return -1;
			}else{
				return 0;
			}
		}
	}
	public abstract double costoManutenzione(int n);
	
	private final String marca;
	private final String modello;
	private  String colore;
	private boolean disponibilita = true;
	private double costo;
}