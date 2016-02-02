package dominio;

import java.util.Date;
import java.util.GregorianCalendar;

public class Noleggio implements Comparable<Noleggio>{
	public Noleggio(Cliente cc, Veicolo vv, int gg, int mm, int aa){
		this.cliente = cc;
		this.veicolo = vv;
		this.inizio = (new GregorianCalendar(aa,mm-1,gg)).getTime();
	}
	public Noleggio(Cliente cc, Veicolo vv, Date i){
		this.cliente = cc;
		this.veicolo = vv;
		this.inizio = i;
	}
	public Cliente getCliente(){
		return cliente;
	}
	public Veicolo getVeicolo(){
		return veicolo;
	}
	public Date getDateInizio(){
		return inizio;
	}
	public boolean isTerminato(){
		return fine != null;
	}
	public void terminaNoleggio(){
		this.fine = new Date();
		this.veicolo.setDisponibile(true);
	}
	public int getNumeroGiorni(){
		if (!isTerminato()){
			throw new PreCondizioneException("Noleggio non terminato");
		}
		long diff = this.fine.getTime() - this.inizio.getTime();
		return (int)(diff / 86400000);
	}
	public double getCosto(){
		return getNumeroGiorni() * veicolo.getCosto();
	}
	@Override
	public String toString(){
		return "Cliente: \n" + this.cliente + 
		"\nVeicolo: " + this.veicolo + "\nInizio Noleggio: " + this.inizio +
		"\nFineNoleggio: " + (isTerminato()? this.fine: "non terminato");
	}
	@Override
	public int compareTo(Noleggio n){
		return -(this.inizio.compareTo(n.getDateInizio()));
	}
	private final Cliente cliente;
	private final Veicolo veicolo;
	private final Date inizio;
	private Date fine = null;
}