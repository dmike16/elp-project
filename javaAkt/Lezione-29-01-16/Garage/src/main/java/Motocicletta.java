public class Motocicletta extends VeicoloAMotore{
	public Motocicletta(int yy, String marca, String ali,
		String cc, String tipo, int tempi)
	{
		super(yy,marca,ali,cc);
		this.tipo = tipo;
		this.tempiMotore = tempi;
	}
	public String getTipo(){
		return tipo;
	}
	public int getTempiMotore(){
		return tempiMotore;
	}
	@Override
	public String toString(){
		return super.toString() + " a " + getTempiMotore() +
		" tempi";
	}
	private final String tipo;
	private final int tempiMotore;
}