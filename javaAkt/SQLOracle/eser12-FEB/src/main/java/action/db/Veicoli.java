package action.db;

import java.util.Date;

public class Veicoli {
	public Veicoli(){}
	
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
	public float getVel() {
		return vel;
	}
	public void setVel(float vel) {
		this.vel = vel;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public Date getImm() {
		return imm;
	}
	public void setImm(Date imm) {
		this.imm = imm;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getComb() {
		return comb;
	}
	public void setComb(String comb) {
		this.comb = comb;
	}
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
	}
	
	@Override
	public String toString(){
		return "Tg: "+ getTarga() +"\n"+
				"Cl: " + getCilindrata() +"\n"+
				"KW: " + getKw() + "\n"+
				"Vl: " + getVel() + "\n"+
				"Po: " + getPosti() + "\n"+
				"Im: " + getImm() + "\n" +
				"Co: " + getComb() + "\n"+
				"Mo: " + getMod() + "\n";
	}
	private String targa;
	private int cilindrata;
	private float kw;
	private float vel;
	private int posti;
	private Date imm;
	private String cat;
	private String comb;
	private String mod;
	
}
