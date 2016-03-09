package web.app;

import java.time.LocalDate;

public class Veicolo {
	
	public String getComb() {
		return comb;
	}

	public void setComb(String comb) {
		this.comb = comb;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public float getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(float cilindrata) {
		this.cilindrata = cilindrata;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public float getVelocita() {
		return velocita;
	}

	public void setVelocita(float velocita) {
		this.velocita = velocita;
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
	
	private String targa;
	private String modello;
	private String comb;
	private String cat;
	private float cilindrata;
	private int posti;
	private float velocita;
	private float kw;
	private LocalDate immatricolazione;
}
