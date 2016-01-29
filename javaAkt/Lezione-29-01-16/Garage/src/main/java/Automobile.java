public class Automobile extends VeicoloAMotore{
	public Automobile(int yy, String marca, String ali,
		String cc,int porte)
	{
		super(yy,marca,ali,cc);
		this.porte = porte;
	}
	public int getPorte(){
		return porte;
	}
	@Override
	public String toString(){
		return super.toString() + " avente " + getPorte() +
		" porte";
	}
	private final int porte;
}