package dominio;

public class Camion extends VeicoloAMotore{
	public Camion(String marca, String mod , String col,double costo,
	 String targa,boolean rim)
	{
		super(marca,mod,col,costo,targa);
		this.rimorchio = rim;
	}
	public boolean haRimorchio(){
		return rimorchio;
	}
	@Override
	public String toString(){
		return super.toString() + "\n Rimorchio: " +
		(haRimorchio()? "si": "no");
	}
	@Override
	public double costoManutenzione(int n){
		int range = (haRimorchio()? 9:11);
		int min = (haRimorchio()?7:10);
		return getCosto() + n*(Math.random()*range + min);
	}
	private final boolean rimorchio;
}