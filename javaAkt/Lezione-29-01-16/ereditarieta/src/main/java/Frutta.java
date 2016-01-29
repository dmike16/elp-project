import java.util.Date;

public class Frutta extends ProdottoAlimentare{
	private final String tipo;
	private final double peso;

	public Frutta(String nome, String tipo, double prezzo, Date d, double peso){
		super(nome,prezzo,d);
		this.tipo = tipo;
		this.peso = peso;
	}
	public String getTipo(){
		return this.tipo;
	}
	public double getPeso(){
		return peso;
	}
	@Override
	public String toString(){
		return super.toString() + " Tipo: " + this.getTipo() +
		" Peso: " + this.getPeso();
	}
	@Override
	public void applicaSconto(){
		if (this.peso > 0.5d){
			return ;
		}

		double p = super.getPrezzo();
		p = p - p * ProdottoAlimentare.PERCENTUALE_SCONTO / 100; 
		super.setPrezzo(p);
	}
}