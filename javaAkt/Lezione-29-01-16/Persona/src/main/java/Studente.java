public class Studente extends Persona{
	public Studente(String nome,String cognome, String cdf,
		String citta, String matr, int esamiSostenuti)
	{
		super(nome,cognome,cdf,citta);
		this.matr = matr;
		if (esamiSostenuti < 0){
			this.esamiSostenuti = 0;
		} else{
			this.esamiSostenuti = esamiSostenuti;
		}
	}
	public String getMatricola(){
		return matr;
	}
	public int getEsamiSostenuti(){
		return esamiSostenuti;
	}
	public void setNumeroEsami(int n){
		this.esamiSostenuti = n;
	}
	@Override
	public String toString(){
		return super.toString() + " Matr: " + getMatricola() +
		" Esami: " +getEsamiSostenuti();
	}
	private final String matr;
	private int esamiSostenuti;
}