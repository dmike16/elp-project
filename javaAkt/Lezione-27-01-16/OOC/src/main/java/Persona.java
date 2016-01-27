public class Persona {
	private final String name;
	private int eta;

	public Persona(String name, int eta){
		// this referenza all istanza che sto creando
		this.name = name;
		this.eta = eta;
	}
	public String getName(){
		return this.name;
	}
	public int getEta(){
		return this.eta;
	}
	public void setEta(int nEta){
		if (nEta > 0){
			this.eta = nEta;
		}
	}
	@Override
	public String toString(){
		return "Nome: " + this.name + " // Eta: " + this.eta;
	}
	// Errore --- I metodi statici non hanno referenza implicita all oggetto
	/*
	public static String giveMeName(){
		return this.name;
	}
	*/
}