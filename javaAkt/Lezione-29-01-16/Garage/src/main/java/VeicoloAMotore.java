public abstract class VeicoloAMotore{
	public VeicoloAMotore(int yy, String marca, String ali,
		String cc)
	{
		this.annoImmatricolazione = yy;
		this.marca = marca;
		this.alimentazione = ali;
		this.cilindrata = cc;
	}
	public int getImmatricolazione(){
		return annoImmatricolazione;
	}
	public String getMarca(){
		return marca;
	}
	public String getAlimentazione(){
		return alimentazione;
	}
	public String getCilindrata(){
		return cilindrata;
	}
	@Override
	public String toString(){
		return "Veicolo " + getMarca() + " innatricolato nel anno " +
 		getImmatricolazione() + " con alimentazione a " + getAlimentazione() +
 		" e cilindrata " + getCilindrata(); 
	}
	private final int annoImmatricolazione;
	private final String marca;
	private final String alimentazione;
	private final String cilindrata;
}