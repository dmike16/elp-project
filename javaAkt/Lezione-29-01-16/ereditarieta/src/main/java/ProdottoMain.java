import java.util.Date;
import java.util.GregorianCalendar; 

public class ProdottoMain{
	public static void main(String[] args){
		Date d = (new GregorianCalendar(2016,1,29)).getTime();
		Frutta mela = new Frutta("Mela", "Verde", 5.00d, d, 1.00d);

		d = (new GregorianCalendar(2026,0,29)).getTime();
		ProdottoAlimentare prod = new Pasta("Penne DeCecco", 1.00d , d, 12000);

		CD cd = new CD("Eric Clapton Unplagged", 14.90d, true, "01232");

		d = (new GregorianCalendar(2007,4,23)).getTime();
		ProdottoNonAlimentare prod2 = new Libro("Thinking in Java", 40.00d, "ISB0390902", d);
	
		Prodotto[] stock = {
			mela,
			prod,
			cd,
			prod2
		} ;

		System.out.println("Nello stock abbiamo: ");
		for (Prodotto ele: stock){
			System.out.println(ele);
		}

		double totalPrice = 0;
		for(Prodotto ele: stock){
			ele.applicaSconto();
			totalPrice += ele.getPrezzo();
		}
		System.out.println("Il Prezzo Totale è : " + totalPrice);
	}
}