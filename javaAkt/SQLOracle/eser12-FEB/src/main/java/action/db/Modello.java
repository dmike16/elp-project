package action.db;

public class Modello {
	
	public Modello(){}
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCodFabbrica() {
		return codFabbrica;
	}
	public void setCodFabbrica(String codFabbrica) {
		this.codFabbrica = codFabbrica;
	}
	
	public String toString(){
		return "Cod: " + getCod() +"\n"+
				"Nome: " + getNome()+"\n"+
				"Version: " + getVersion() +"\n"+
				"CodF: " + getCodFabbrica();
	}

	private String cod;
	private String nome;
	private int version;
	private String  codFabbrica;
	
	
}
