package cipolla;

public class Negozio {
	public Negozio(){}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString(){
		return "Id: " + getId() +"\n"+
				"Name: " + getName()+ "\n"+
				"Indirizzo: " + getIndirizzo() +"\n"+
				"Citta: " +getCitta()+"\n"+
				"Tel: " + getTelefono()+"\n";
	}

	private String id;
	private String name;
	private String indirizzo;
	private String citta;
	private String telefono;
}
