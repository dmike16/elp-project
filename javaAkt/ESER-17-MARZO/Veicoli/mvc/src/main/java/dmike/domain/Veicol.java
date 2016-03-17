package dmike.domain;

import java.time.LocalDate;

public class Veicol {
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public LocalDate getImm() {
		return imm;
	}
	public void setImm(LocalDate imm) {
		this.imm = imm;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public float getMaxVel() {
		return maxVel;
	}
	public void setMaxVel(float maxVel) {
		this.maxVel = maxVel;
	}
	public float getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(float cilindrata) {
		this.cilindrata = cilindrata;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	@Override
	public int hashCode(){
		return targa.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj != null && this.getClass().equals(obj.getClass())){
			Veicol tmp = (Veicol) obj;
			if(tmp.getTarga().equals(this.getTarga())){
				return true;
			}
		}
		return false;
	}
	private String targa;
	private LocalDate imm;
	private int posti;
	private float maxVel;
	private float cilindrata;
	private String modello;
}
