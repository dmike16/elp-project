import java.util.Date;
import java.util.GregorianCalendar;

public class Studente{
	private final String name;
	private int eta ;
	private final String matr;
	private final Date immatr;

	public Studente(String name, int eta, String matr, Date imm){
		this.name = name;
		this.eta = eta;
		this.matr = matr;
		this.immatr = imm;
	}
	public Studente(String name, String matr){
		int eta = (int)(Math.random()*(43)) + 18;
		int yy = (int)(Math.random()*(16)) + 2000;
		int mm = (int)(Math.random()*(12)) + 1;
		int gg = (int)(Math.random()*(31)) + 1;

		Date d = (new GregorianCalendar(yy,mm-1,gg)).getTime();

		this.name = name;
		this.eta = eta;
		this.matr = matr;
		this.immatr = d;
	}
	public String getName(){
		return this.name;
	}
	public int getEta(){
		return this.eta;
	}
	public void setEta(int neta){
		this.eta = neta;
	}
	public String getMatr(){
		return this.matr;
	}
	public Date getDate(){
		return this.immatr;
	}
	@Override
	public String toString(){
		return "Studente : " + this.getName() + " " + this.getEta() +
		" anni " + " immatricolato nel " + this.getDate() + " con matricola " +
		this.getMatr();
	}
}