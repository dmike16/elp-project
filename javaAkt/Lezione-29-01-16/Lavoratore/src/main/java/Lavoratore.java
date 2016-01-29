public class Lavoratore{
	public String getNome(){
		return nome;
	}
	public double getSalario(){
		return salario;
	}
	public Lavoratore setSalario(double stip){
		this.salario = stip;
		return this;
	}
	public int getLivello(){
		return livello;
	}
	public Lavoratore setLivello(int liv){
		if (liv > 0 && liv < 10){
			this.livello = liv;
		}
		return this;
	}
	@Override
	public String toString(){
		return getNome() + " || Livello : " + getLivello() + " || Salario : "  +
		String.format("%.2f€",getSalario());
	}
	public Lavoratore(String nome, int liv, double stip){
		this.nome = nome;
		if (liv < 0 || liv > 10){
			this.livello = 0;
		} else {
			this.livello = liv;
		}
		this.salario = stip;
	}
	public Lavoratore(String nome,double stip){
		this(nome,0,stip);
	}

	private final String nome;
	private int livello;
	private double salario;
}