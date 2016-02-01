public class Studente extends Persona{
	public Studente(String nome,String cognome, String cdf,
		String citta, String matr, int esamiSostenuti)
	{
		super(nome,cognome,cdf,citta);
		this.matr = matr;
		if (esamiSostenuti < 0){
			this.esamiSostenuti = 0;
			this.votoEsami = new int[]{-1};
		} else{
			this.esamiSostenuti = esamiSostenuti;
			this.votoEsami = new int[this.esamiSostenuti];
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
	public int[] getVotoEsami(){
		return this.votoEsami;
	}
	public void caricaVotoEsami(int... args)
		throws VotoStudentiException
	{
		if(args.length == 0){
			return;
		} 
		for(int i = 0; i < args.length && i < this.getEsamiSostenuti(); i++){
			if(args[i] < 0 || args[i] > 10){
				throw new VotoStudentiException("Voto " + args[i] + 
					" non appartiene all intervallo [0,10]");
			}
			this.votoEsami[i] = args[i];
		}
	}
	@Override
	public String toString(){
		return super.toString() + " Matr: " + getMatricola() +
		" Esami: " +getEsamiSostenuti();
	}
	private final String matr;
	private int esamiSostenuti;
	private final int[] votoEsami;
}