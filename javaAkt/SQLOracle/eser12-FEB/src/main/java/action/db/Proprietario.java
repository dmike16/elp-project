package action.db;

public class Proprietario {
	public Proprietario(){}
	
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString(){
		return "Nome: " + getNome() + "\n"+
				"Cognome: " +getCognome() + "\n"+
				"Indirizzo: " +getIndirizzo() +"\n" +
				"Prov: " + getProvincia() + "\n";
	}
	
	private String cod;
	private String cognome;
	private String nome;
	private String indirizzo;
	private String provincia;
}
