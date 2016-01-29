import java.util.Date;

public abstract class ProdottoAlimentare extends Prodotto{
	private final Date scadenza;

	public static final int PERCENTUALE_SCONTO = 20;

	public ProdottoAlimentare(String nome, double prezzo, Date scad){
		super(nome,prezzo);
		this.scadenza = scad;
	}
	public Date getScadenza(){
		return  this.scadenza;
	}
	@Override
	public String toString(){
		return super.toString() + " Scadenza: " + getScadenza(); 
	}
}