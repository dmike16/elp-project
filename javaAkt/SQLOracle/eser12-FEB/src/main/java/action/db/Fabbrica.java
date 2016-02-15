package action.db;

public class Fabbrica {
	
	public Fabbrica(){}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	@Override
	public String toString(){
		return "Nome: " +getNome() +"\n"+
				"Cod: " +getCod() +"\n";
	}

	private String nome;
	private String cod;
}
