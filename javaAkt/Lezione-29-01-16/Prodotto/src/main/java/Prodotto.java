public class Prodotto{
	public Prodotto(String codice, String descr, double prezzo){
		this.codice = codice + Prodotto.COUNT++;
		this.descrizione = descr;
		this.prezzo = prezzo; 
	}
	public Prodotto(String codice, double prezzo){
		this.codice = codice + Prodotto.COUNT++;
		this.prezzo = prezzo;
		this.descrizione = "Descrizione non disponibile";
	}
	public String getCodice(){
		return codice;
	}
	public String getDescrizione(){
		return descrizione;
	}
	public void setDescrizione(String descr){
		this.descrizione = descr;
	}
	public double getPrezzo(){
		return prezzo;
	}
	public void setPrezzo(double prezzo){
		this.prezzo = prezzo;
	}
	public void applicaSconto(){
		this.prezzo -= this.prezzo * Prodotto.SCONTO / 100;
	}
	@Override
	public String toString(){
		return getDescrizione() + " || " + "Codice :: " + getCodice() +
		" || Prezzo :: " + String.format("%.2f€",getPrezzo());
	}

	private static int SCONTO = 5;
	private static int COUNT = 1;
	private final String codice;
	private String descrizione;
	private double prezzo;
} 