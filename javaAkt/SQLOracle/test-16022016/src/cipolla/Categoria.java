package cipolla;

public class Categoria {
	public Categoria(){}
	public Categoria(String cod,String descr){
		this.cod = cod;
		this.descrizione = descr;
	}
	
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString(){
		return "Cod: " + getCod() +"\n"+
				"Descr: " + getDescrizione()+"\n";
	}

	private String cod;
	private String descrizione;
}
