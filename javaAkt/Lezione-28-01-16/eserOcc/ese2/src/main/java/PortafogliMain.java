public class PortafogliMain{
	public static void main(String[] args){
		Portafogli wallet = new Portafogli();

		wallet.aggiungiEuro(1000);
		wallet.aggiungiLire(50000);
		System.out.println("Totale : " + wallet.quantiSoldi());

		System.out.println(wallet);
	}
}