import java.util.Date;
import java.util.GregorianCalendar;

public class Impiegato implements Comparable<Impiegato>{
	private static int nextId = 1;

	private final String nome;
	private final Date assunzione;
	private int eta;
	private double salario;
	private final int id;


	public Impiegato(String name, int eta, double salario, int gg, int mm, int aa){
		this.nome = name;
		this.eta = eta;
		this.salario = salario;
		this.assunzione = (new GregorianCalendar(aa,mm-1,gg)).getTime();
		this.id = Impiegato.nextId++;
	}
	public Impiegato(String name){
		this.nome = name;
		// Eta random tra 18 e 60
		this.eta = (int)(Math.random() * (61 - 18)) + 18;

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
	public String getNome(){
		return this.nome;
	}
	public Date getAssunzione(){
		return this.assunzione;
	}
	public int getEta(){
		return this.eta;
	}
	public void setEta(int nEta){
		if (nEta > 0 && nEta <= 120)
			this.eta = nEta;
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
		return "Id: "+ id + " | Nome : " + nome + " | Salario: " + String.format("%.2f",salario) +
				" | Eta: " + eta + " | Assunzione: " + assunzione;
	}
	public static int getNextId(){
		return Impiegato.nextId;
	}
	@Override
	public int compareTo(Impiegato o){
		if (this.getSalario() > o.getSalario()){
			return 1;
		}else if (this.getSalario() < o.getSalario()){
			return -1;
		}else {
			return this.assunzione.compareTo(o.assunzione);
		}		
	}
}