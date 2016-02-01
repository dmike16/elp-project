public class ExceptionPreCondozioni extends Exception{
	public ExceptionPreCondozioni(){
		super("Parametri Costruttore non validi");
	}		
	public ExceptionPreCondozioni(String mes){
		super(mes);
	}
}