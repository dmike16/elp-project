package dmike.polimorfism;

public class Soci extends Persona{
	public Soci(String nome, String cog, String cdf, String citta,
		String tessera, int mesi, double qt)
	{
		super(nome,cog,cdf,citta);
		this.numeroTessera = tessera;
		this.numeroMesi = mesi;
		this.quoteMensile = qt;
	}
	public String getTessera(){
		return numeroTessera;
	}
	public int getMesi(){
		return numeroMesi;
	}
	public void setMesi(int n){
		this.numeroMesi += n;
	}
	public double getQuota(){
		return quoteMensile;
	}
	public void setQuota(double x){
		this.quoteMensile = x;
	}
	public double calcoloTotale(){
		return numeroMesi * quoteMensile;
	}
	@Override
	public String toString(){
		return super.toString() + " Tessera N " + getTessera() +
		" Numero Mesi: " + getMesi() + " qtMensile: " + getQuota();
	}
	private final String numeroTessera;
	private int numeroMesi;
	private double quoteMensile;
}