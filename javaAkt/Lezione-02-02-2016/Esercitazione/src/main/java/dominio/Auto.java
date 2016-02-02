package dominio;

public class Auto extends VeicoloAMotore{
	public Auto(String marca, String mod , String col,double costo,
	 String targa, int posti)
	{
		super(marca,mod,col,costo,targa);
		this.posti = posti;
	}
	public int getPosti(){
		return posti;
	}
	@Override
	public String toString(){
		return super.toString() + " \nPosti" + getPosti();
	}
	@Override
	public double costoManutenzione(int n){
		return getCosto() + n*(Math.random()*6 + 5);
	}
	private final int posti;
}