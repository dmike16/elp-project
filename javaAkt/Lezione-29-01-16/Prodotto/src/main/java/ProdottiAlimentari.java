import java.util.Date;

public class ProdottiAlimentari extends Prodotto{
	public ProdottiAlimentari(String codice,double prezzo,Date d){
		super(codice,prezzo);
		this.scandeza = d;
	}
	public ProdottiAlimentari(String codice, String desc,
		double prezzo, Date d)
	{
		super(codice,desc,prezzo);
		this.scandeza = d;
	}
	public Date getScadenza(){
		return scandeza;
	}
	@Override
	public String toString(){
		return super.toString() + " || " + " Scadenza :: " + getScadenza();
	}
	@Override
	public void applicaSconto(){
		Date now = new Date();
		long millSecDiff = this.scandeza.getTime() - now.getTime();
		int days = (int) millSecDiff / 86400000;
		if (days <= 10){
			double prezzo = super.getPrezzo();
			prezzo -= prezzo * ProdottiAlimentari.SCONTO / 100;
			super.setPrezzo(prezzo);
		} else {
			super.applicaSconto();
		}
	}
	private static final int SCONTO = 20;
	private final Date scandeza;
}