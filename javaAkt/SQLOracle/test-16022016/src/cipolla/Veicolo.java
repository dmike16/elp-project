package cipolla;

import java.util.Date;

public class Veicolo {
	public Veicolo(){}
	
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public float getKw() {
		return kw;
	}
	public void setKw(float kw) {
		this.kw = kw;
	}
	public float getVelocita() {
		return velocita;
	}
	public void setVelocita(float velocita) {
		this.velocita = velocita;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public Date getImmatricolazione() {
		return immatricolazione;
	}
	public void setImmatricolazione(Date immatricolazione) {
		this.immatricolazione = immatricolazione;
	}
	public String getCodCat() {
		return codCat;
	}
	public void setCodCat(String codCat) {
		this.codCat = codCat;
	}
	public String getCodComb() {
		return codComb;
	}
	public void setCodComb(String codComb) {
		this.codComb = codComb;
	}
	public String getCodMod() {
		return codMod;
	}
	public void setCodMod(String codMod) {
		this.codMod = codMod;
	}
	public Categoria getCategoria(){
		return cat;
	}
	public void setCategoria(Categoria cat){
		this.cat = cat;
	}
	@Override
	public String toString(){
		return "Targa: " + getTarga() + "\n"+
				"CC: " +getCilindrata()+"\n"+
				"KW: " +String.format("%.2f", getKw())+"\n"+
				"Vel: "+String.format("%.2f", getVelocita())+"\n"+
				"Posti: "+getPosti()+"\n"+
				"Immatricolazione: "+ getImmatricolazione()+"\n"+
				"Categoria:   "+getCategoria()+
				"Comb: " + getCodComb()+"\n"+
				"Mod: " +getCodMod()+"\n";
	}



	private String targa;
	private int cilindrata;
	private float kw;
	private float velocita;
	private int posti;
	private Date immatricolazione;
	private String codCat;
	private String codComb;
	private String codMod;
	private Categoria cat;
}
