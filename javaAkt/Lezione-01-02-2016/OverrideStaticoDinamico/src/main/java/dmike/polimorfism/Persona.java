package dmike.polimorfism;

public class Persona implements Comparable<Persona>, Cloneable{
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
	@Override
	public int hashCode(){
		return nome.hashCode() + cognome.hashCode() + cdf.hashCode() +
		citta.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj != null && this.getClass().equals(obj.getClass())){
			Persona tmp = (Persona) obj;
			return (this.nome.equals(tmp.getNome())) && 
			(this.cognome.equals(tmp.getCognome())) &&
			(this.cdf.equals(tmp.getCodiceFiscale())) &&
			(this.citta.equals(tmp.getCitta()));
		}
		return false;
	}
	@Override
	public int compareTo(Persona p){
		if(p == null){
			throw new NullPointerException();
		}
		return this.nome.compareTo(p.getNome());
	}
	@Override
	public Persona clone(){
		try{
			return (Persona) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}
	}

	private final String nome;
	private final String cognome;
	private final String cdf;
	private String citta;

}