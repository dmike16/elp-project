package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenzia{
	public Agenzia(String nome,String localita){
		this.nome = nome;
		this.localita = localita;
	}
	public Agenzia(String nome,String localita, double bil){
		this.nome = nome;
		this.localita = localita;
		this.bilancio = bil;
	}
	public String getNome(){
		return nome;
	}
	public String getLocalita(){
		return localita;
	}
	public double getBilancio(){
		return bilancio;
	}
	public void inserisciCliente(Cliente c){
		if (c!= null && !this.client.contains(c)){
			client.add(c);
		}
	}
	public void rimuoviCliente(Cliente c){
		if(c != null)
			client.remove(c);
	}
	public List<Cliente> getClienti(){
		return this.client;
	}
	public void inserisciVeicolo(Veicolo v){
		if(v != null && !this.veicoli.contains(v)){
			veicoli.add(v);
			Collections.sort(this.veicoli);
		}
	}
	public void rimuoviVeicolo(Veicolo v){
		if (v != null){
			veicoli.remove(v);
		}
	}
	public List<Veicolo> getVeicoli(){
		return this.veicoli;
	}
	public void inserisciNoleggio(Noleggio n){
		if (n != null){
			Veicolo nolleggiato = n.getVeicolo();
			nolleggiato.setDisponibile(false);
			noleggi.add(n);
			Collections.sort(this.noleggi);
		}
	}
	public double terminaNoleggio(Noleggio n){
		if(n != null){
			n.terminaNoleggio();
			// Entrate
			bilancio += n.getCosto();
			// Uscite
			double result = n.getVeicolo().costoManutenzione(n.getNumeroGiorni());
			bilancio -= result;

			return result;
		}
		return -1;
	}
	public List<Noleggio> getNoleggiNonTerminati(){
		ArrayList<Noleggio> nonTerminato = new ArrayList<>();
		for(Noleggio ele: this.noleggi){
			if(!ele.isTerminato()){
				nonTerminato.add(ele);
			}
		}
		return nonTerminato;
	}
	public List<Noleggio> getNoleggiTerminati(){
		ArrayList<Noleggio> terminati = new ArrayList<>();
		for(Noleggio ele: this.noleggi){
			if(ele.isTerminato()){
				terminati.add(ele);
			}
		}
		return terminati;
	}


	private final String nome;
	private final String localita;
	private double bilancio = 0;

	private ArrayList<Cliente> client = new ArrayList<>();
	private ArrayList<Veicolo> veicoli = new ArrayList<>();
	private ArrayList<Noleggio> noleggi = new ArrayList<>();
}