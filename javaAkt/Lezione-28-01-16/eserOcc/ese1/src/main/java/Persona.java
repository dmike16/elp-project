public class Persona{
	private final String name;
	private int eta;

	public Persona(String name, int eta){
		this.name = name;
		this.eta = eta;
	}
	public Persona(String name){
		this(name,(int)(Math.random()*(43)) + 18);
		//this.name = name;
		// Compresa tra 18 e 60;
		//this.eta = (int)(Math.random()*(43)) + 18;
	}
	public String getName(){
		return name;
	}
	public int getEta(){
		return eta;
	}
	public void setEta(int neta){
		this.eta = neta;
	}
	@Override
	public String toString(){
		return this.getName() + " " + this.getEta() + " anni";
	}
}