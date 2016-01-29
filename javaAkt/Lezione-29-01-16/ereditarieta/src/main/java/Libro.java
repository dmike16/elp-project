import java.util.Date;

public class Libro extends ProdottoNonAlimentare{
	private final String isbn;
	private final Date publicazione;

	public Libro(String nome, double prezzo,String isbn, Date pub){
		super(nome,prezzo);
		this.isbn = isbn;
		this.publicazione = pub;
	}
	public String getIsbn(){
		return this.isbn;
	}
	public Date getPublicazione(){
		return this.publicazione;
	}
	@Override
	public String toString(){
		return super.toString() + " ISBN: " + this.isbn +
		" publicato il " + this.publicazione;
	}
	@Override
	public void applicaSconto(){
		long millSecDiff = (new Date()).getTime() - this.publicazione.getTime();

		int days = (int) (millSecDiff / 86400000);
		int years = days / 365;

		if (years >= 10){
			double p = this.getPrezzo();
			p = p - p*ProdottoNonAlimentare.PERCENTUALE_SCONTO;
			this.setPrezzo(p);
		} 
	}
}