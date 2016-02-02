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
	@Override 
	public int hashCode(){
		return super.hashCode() + (int)tassaIscrizione;
	}
	@Override
	public boolean equals(Object obj){
		if (super.equals(obj)){
			Pagamenti tmp = (Pagamenti)obj;
			return (Math.abs(tassaIscrizione - tmp.getTassa())) < Soci.TOL;
		}
		return false;
	}
	private double tassaIscrizione;
}