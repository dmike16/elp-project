import java.util.Date;

public class Pasta extends ProdottoAlimentare{
	private final double carboidrati;

	public Pasta(String nome, double prezzo , Date d, double carbo){
		super(nome,prezzo,d);
		this.carboidrati = carbo;
	}
	public double getCarbo(){
		return this.carboidrati;
	}
	@Override
	public String toString(){
		return super.toString() + " Carbo: " + this.getCarbo();
	}
	@Override
	public void applicaSconto(){
		double p = super.getPrezzo();
		p = p - p*ProdottoAlimentare.PERCENTUALE_SCONTO;
		super.setPrezzo(p);
	}
}