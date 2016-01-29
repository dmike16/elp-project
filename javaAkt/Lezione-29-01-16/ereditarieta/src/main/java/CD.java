public class CD extends ProdottoNonAlimentare{
	private final boolean limited;
	private final String id;

	public CD(String nome, double prezzo, String id){
		super(nome,prezzo);
		this.limited = false;
		this.id = id;
	}
	public CD(String nome, double prezzo, boolean lim, String id){
		super(nome,prezzo);
		this.limited = lim;
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public boolean isLimited(){
		return limited;
	}
	@Override
	public String toString(){
		return super.toString() + " " + id +(this.isLimited()? " è ": " non è ") +
		"limited Edition";
	}
	@Override
	public void applicaSconto(){
		if (!isLimited()){
			return;
		}
		double p = super.getPrezzo();
		p = p - p*ProdottoNonAlimentare.PERCENTUALE_SCONTO/100;
		super.setPrezzo(p);
	}
}