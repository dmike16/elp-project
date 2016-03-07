package web.app;

import java.time.LocalDate;

public class Veicolo {
	private String targa;
	private String modello;
	private float kw;
	private LocalDate immatricolazione;
	
	public Veicolo(){
		targa = " ";
		modello = " ";
		kw = 0.0f;
		immatricolazione =null;
	}
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public float getKw() {
		return kw;
	}
	public void setKw(float kw) {
		this.kw = kw;
	}
	public LocalDate getImmatricolazione() {
		return immatricolazione;
	}
	public void setImmatricolazione(LocalDate immatricolazione) {
		this.immatricolazione = immatricolazione;
	}
	
	
}
