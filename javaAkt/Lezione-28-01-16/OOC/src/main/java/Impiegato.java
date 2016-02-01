import java.util.Date;
import java.util.GregorianCalendar;

public class Impiegato extends Persona{
	private static int nextId = 1;

	private final Date assunzione;
	private double salario;
	private final int id;


	public Impiegato(String name, int eta, double salario, int gg, int mm, int aa)
		throws ExceptionPreCondozioni
	{
		super(name,eta);
		this.salario = salario;
		this.assunzione = (new GregorianCalendar(aa,mm-1,gg)).getTime();
		this.id = Impiegato.nextId++;
	}
	public Impiegato(String name)
		throws ExceptionPreCondozioni
	{
		super(name,(int)(Math.random() * (61 - 18)) + 18);
		// Eta random tra 18 e 60
		// Salario random tra 1000 e 4000
		this.salario = Math.random()*(3001) + 1000;
		// Date random :
		// gg tra 1 e 31
		// mm tra 0 a 11
		// yy tra 1970 a 2013
		int dd = (int)(Math.random()* 31) + 1;
		int mm = (int)(Math.random()* 12);
		int yy = (int)(Math.random()*(2013- 1970)) + 1970;

		this.assunzione = (new GregorianCalendar(yy,mm,dd)).getTime();
		this.id = Impiegato.nextId++;
	}
	public Date getAssunzione(){
		return this.assunzione;
	}
	public double getSalario(){
		return this.salario;
	}
	public void aumentoSalario(double percetuale){
		this.salario = (this.salario * percetuale / 100) + this.salario;
	}
	public int getId(){
		return this.id;
	}
	@Override
	public String toString(){
		return "Id: "+ id + " | " + super.toString() + " | Salario: " + String.format("%.2f",this.getSalario()) +
				 " | Assunzione: " + assunzione;
	}
	public static int getNextId(){
		return Impiegato.nextId;
	}
	@Override
	public boolean equals(Object obj){
		if(super.equals(obj)){
			Impiegato tmp = (Impiegato) obj;
			return this.salario == tmp.salario && this.id == tmp.id && 
				this.assunzione.equals(tmp.assunzione);
		}
		return false;
	}
	@Override
	public int hashCode(){
		return super.hashCode() + id + (int) salario + assunzione.hashCode();
	}
}