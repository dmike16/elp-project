package attivita;
import dominio.*;
import attivita.AttivitaIO;

public class AttivitaPrincipale{
	private static Agenzia agenzia;
	public static void esegui(){
		agenzia = new Agenzia("AKT","Roma",1000);
		caricaDatiTest();

		AttivitaIO.menuPrincipale(agenzia);
	}
	private static void caricaDatiTest(){
		agenzia.inserisciCliente(new Cliente("Alice","Rossi",12,12,1990));
		agenzia.inserisciCliente(new Cliente("Marco","Rossi",12,2,1990));
		agenzia.inserisciCliente(new Cliente("Giovanni","Rossi",12,4,1990));

		agenzia.inserisciVeicolo(new Bicicletta("Scott","Scale","Bianca",50,true));
		agenzia.inserisciVeicolo(new Auto("Audi","A3","Nero", 280,"HJ909JK",5));
		agenzia.inserisciVeicolo(new Camion("Mercedcs","B","Nero",390,"RE909EE",true));
	}
}