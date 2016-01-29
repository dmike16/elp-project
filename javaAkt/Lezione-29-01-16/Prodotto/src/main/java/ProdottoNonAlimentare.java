public class ProdottoNonAlimentare extends Prodotto{
	public ProdottoNonAlimentare(String codice, double prezzo,
		String mater)
	{
		super(codice,prezzo);
		this.materiale = mater;
	}
	public ProdottoNonAlimentare(String codice, String descr, 
		double prezzo, String mate)
	{
		super(codice,descr,prezzo);
		this.materiale = mate;
	}
	public String getMateriale(){
		return materiale;
	}
	@Override
	public String toString(){
		return super.toString() + " || Materiale :: " + getMateriale();
	}
	@Override 
	public void applicaSconto(){
		String lowCase = this.materiale.toLowerCase();
		if (lowCase.equals("carta") || lowCase.equals("vetro") ||
			lowCase.equals("plastica"))
		{
			double prezzo = super.getPrezzo();
			prezzo -= prezzo * ProdottoNonAlimentare.SCONTO / 100;
			super.setPrezzo(prezzo);
		} else {
			super.applicaSconto();
		}
	}
	private static final int SCONTO = 10;
	private final String materiale;
}