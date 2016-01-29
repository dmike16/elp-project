import java.util.GregorianCalendar;

public class ProdottoMain{
	public static void main(String[] args){
		Prodotto[] prodotti = {
			new Prodotto("IJ9892",34.00d),
			new Prodotto("Idk989","Libro",40.00),
			new ProdottoNonAlimentare("HH0909","Carta da Cucina",0.90d,"carta"),
			new ProdottiAlimentari("KH2098", "Mela", 5.00d, 
				(new GregorianCalendar(2016,1,20)).getTime())
		};

		for(Prodotto ele: prodotti){
			System.out.print(ele.getDescrizione() + " Prezzo:: " + ele.getPrezzo());
			ele.applicaSconto();
			System.out.println(" Nprezzo :: " + ele.getPrezzo());
		}
	}
}