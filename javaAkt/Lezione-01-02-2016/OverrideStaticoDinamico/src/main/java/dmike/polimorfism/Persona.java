package dmike.polimorfism;

public class Persona{
	public Persona(String nome, String cog, String cdf, String citta){
		this.nome = nome;
		this.cognome = cog;
		this.cdf = cdf;
		this.citta = citta;
	}
	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public String getCodiceFiscale(){
		return cdf.toUpperCase();
	}
	public String getCitta(){
		return citta;
	}
	public void cambiaResidenza(String citta){
		this.setCitta(citta);
	}
	@Override
	public String toString(){
		return getNome() + " " + getCognome() + " " + getCodiceFiscale() + " " +
		" residente in " + getCitta();
	}
	private Persona setCitta(String citta){
		this.citta = citta;

		return this;
	}
	private final String nome;
	private final String cognome;
	private final String cdf;
	private String citta;

}