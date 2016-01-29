public class Furgone extends VeicoloAMotore{
	public VeicoloAMotore(int yy, String marca, String ali,
		String cc, int carico)
	{
		super(yy,marca,ali,cc);
		this.massaAcarico = carico;
	}
	public int getCapacitaCarico(){
		return  massaAcarico;
	}
	@Override
	public String toString(){
		return super.toString() + " con massa a carico " + 
		getCapacitaCarico();
	}
	private final int massaAcarico;
}