public abstract class Prodotto{
	private final String nome;
	private double prezzo;

	Prodotto(String nome, double prezzo){
		this.nome = nome;
		this.prezzo = prezzo;
	}
	public String getNome(){
		return nome;
	}
	public double getPrezzo(){
		return prezzo;
	}
	public void setPrezzo(double p){
		this.prezzo = p;
	}
	public abstract void applicaSconto();

	public String toString(){
		return "Prodotto: " + this.getNome() + " " +
		this.getPrezzo() + "€";
	}
}