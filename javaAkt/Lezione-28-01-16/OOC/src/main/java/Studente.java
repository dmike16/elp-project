import java.util.Date;
import java.util.GregorianCalendar;

public class Studente extends Persona{
	private final Date immatricolazione;
	private final String matricola;

	public Studente(String nome, int eta, int gg, int mm, int aa, String matricola){
		super(nome,eta);
		this.matricola = matricola;
		this.immatricolazione = (new GregorianCalendar(aa,mm-1,gg)).getTime();
	}
	public Date getImmatricolazione(){
		return this.immatricolazione;
	}
	public String getMatricola(){
		return this.matricola;
	}
	@Override
	public String toString(){
		return super.toString() + "/" + " Matricola : " + matricola + "/" +
			" Immatricolazine : " + immatricolazione;
	}
	public String descrizione(){
		return "Che bella classe";
	}
}