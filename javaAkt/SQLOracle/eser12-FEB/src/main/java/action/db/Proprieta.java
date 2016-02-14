package action.db;

import java.util.Date;

public class Proprieta {
	public Proprieta(){}
	
	
	public Date getAcquisto() {
		return acquisto;
	}
	public void setAcquisto(Date acquisto) {
		this.acquisto = acquisto;
	}
	public Date getVendita() {
		return vendita;
	}
	public void setVendita(Date vendita) {
		this.vendita = vendita;
	}
	public Veicoli getVel() {
		return vel;
	}
	public void setVel(Veicoli vel) {
		this.vel = vel;
	}
	public Proprietario getPerson() {
		return person;
	}
	public void setPerson(Proprietario person) {
		this.person = person;
	}

	@Override
	public String toString(){
		return "Targa: " + vel.getTarga() + "\n" +
				"Possessore: "  + person.getCod() +"\n"+
				"Acquistato il: " + getAcquisto() + "\n" +
				((getVendita() != null)? "Venduto il: " + getVendita(): "") + "\n";
	}
	public String toString(boolean withOwner){
		if(withOwner){
			return  "Targa: " + vel.getTarga() + "\n" +
					"Possessore: "  + "\n"+
					"            Nome: " + person.getNome() +"\n"+
					"            Cognome: " + person.getCognome() +"\n"+
					"Acquistato il: " + getAcquisto() + "\n" +
					((getVendita() != null)? "Venduto il: " + getVendita(): "") + "\n";
		}else{
			return this.toString();
		}
	}
	private Date acquisto;
	private Date vendita;
	private Veicoli vel;
	private Proprietario person;
}
