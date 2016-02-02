package dominio;

public abstract class VeicoloAMotore extends Veicolo{
	public VeicoloAMotore(String marca, String mod , String col, double costo,
	 String targa)
	{
		super(marca,mod,col,costo);
		this.targa = targa;
	}
	public String getTarga(){
		return targa;
	}
	@Override
	public String toString(){
		return super.toString() + "\n Targa: " + getTarga();
	}
	private final String targa;
}