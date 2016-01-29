public class Stagista extends Persona{
	public Stagista(String nome, String cogn, String cdf, String citta,
		int pre)
	{
		super(nome,cogn,cdf,citta);
		this.presenze = pre;
	}
	public int getId(){
		return id;
	}
	public int getPresenze(){
		return presenze;
	}
	public void setPresenze(int n){
		this.presenze = n;
	}
	public String toString(){
		return super.toString() + " id: " + getId() +
		" presenze: " + getPresenze();
	}
	private static int count = 1;
	private final int id = 255 + count++;
	private int presenze;
}