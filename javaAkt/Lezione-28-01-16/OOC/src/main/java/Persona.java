public class Persona implements Cloneable{
	private final String name;
	private int eta;

	public Persona(String name, int eta)
		throws ExceptionPreCondozioni
	{
		// this referenza all istanza che sto creando
		//if (eta < 0){
		//	throw new ExceptionPreCondozioni("Eta negativa (" + eta + ")");
		//}
		if(name == null || eta < 0){
			throw new ExceptionPreCondozioni();
		}
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
		if (nEta > 0 && nEta < 120){
			this.eta = nEta;
		}
	}
	@Override
	public String toString(){
		return "Nome: " + this.name + " / Eta: " + this.eta;
	}
	@Override
	public boolean equals(Object obj){
		if (obj != null && this.getClass().equals(obj.getClass())){
			// Cast obj to this;
			Persona tmp = (Persona) obj;
			return (this.name.equals(tmp.name) && this.eta == tmp.eta);
		} 
		return false;
	} 
	@Override
	public int hashCode(){
		return name.hashCode() + eta;
	}
	@Override
	public Persona clone(){
		try{
			Persona clone = (Persona) super.clone();
			return clone;
		}// Non può mai accadere
		catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}
	}
	//public abstract String descrizione();
	// Errore --- I metodi statici non hanno referenza implicita all oggetto
	/*
	public static String giveMeName(){
		return this.name;
	}
	*/
}