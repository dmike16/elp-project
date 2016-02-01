package dmike.polimorfism;

public class Pagamenti extends Soci{
	public Pagamenti(String nome, String cog, String cdf, String citta,
		String tessers, int mesi, double qt, double tassa)
	{
		super(nome,cog,cdf,citta,tessers,mesi,qt);
		this.tassaIscrizione = tassa;
	}
	public double getTassa(){
		return tassaIscrizione;
	}
	public void setTassa(double t){
		this.tassaIscrizione = t;
	}
	public double calcoloTotale(){
		return super.calcoloTotale() + getTassa();
	}
	@Override
	public String toString(){
		return super.toString() + " Tassa: " + getTassa();
	}
	private double tassaIscrizione;
}