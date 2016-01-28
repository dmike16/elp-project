public abstract class Figura{
	private final String nome;

	public Figura(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public String toString(){
		return nome;
	} 
}