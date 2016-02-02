package dominio;

public class Bicicletta extends Veicolo{
	public Bicicletta(String marca, String mod, String colore, double costo,
		boolean marce)
	{
		super(marca,mod,colore,costo);
		this.marce = marce;
	}
	public boolean haMarce(){
		return marce;
	}
	@Override
	public String toString(){
		return super.toString() + "\n Marce: " +
		(haMarce()? "si": "no");
	}
	@Override
	public double costoManutenzione(int n){
		int range = (haMarce()? 7:6);
		int min = (haMarce()? 1:0);

		return getCosto() + n * (Math.random()*range + min);
	}
	private final boolean marce;
}