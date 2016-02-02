package dmike.polimorfism;

public class Soci extends Persona {
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
	@Override
	public int hashCode(){
		return super.hashCode() + numeroTessera.hashCode() + numeroMesi +
		(int) quoteMensile;
	}
	@Override
	public boolean equals(Object obj){
		if(super.equals(obj)){
			Soci tmp = (Soci) obj;
			return (numeroTessera.equals(tmp.getTessera())) &&
			(numeroMesi == tmp.getMesi()) &&
			((Math.abs(quoteMensile-tmp.getQuota())) <= Soci.TOL);
		}
		return false;
	}
	@Override
	public int compareTo(Persona s){
		if (s instanceof Soci){
			Soci tmp = (Soci) s;
			if(this.quoteMensile > tmp.getQuota() && super.compareTo(s) == 1){
				return 1;
			} else if (this.quoteMensile < tmp.getQuota() && super.compareTo(s) == -1){
				return -1;
			} else if(super.compareTo(s) == 0){
				return 0;
			}
		}
		return super.compareTo(s);
	}
	private final String numeroTessera;
	private int numeroMesi;
	private double quoteMensile;
	protected static final double TOL = 1E-05D;
}