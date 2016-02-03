package attivita;

import assicurazioni.Agenzia;
import java.io.PrintWriter;
import assicurazioni.*;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class AttivitaPrincipale{
	private static PrintWriter cout = new PrintWriter(System.out,true);
	public static void esegui(){
		Agenzia agenzia = new Agenzia("Generali","Via Ostiense 34",10);

		AttivitaDatiTest.preparazione(agenzia);
		cout.println(agenzia);

		List<PolizzaIncendioFurto> list = agenzia.getPolizzeIncedioFurto();
		cout.println(list);

		String[] targe = agenzia.targePolizzeBaseRC100();
		cout.println(Arrays.toString(targe));

		PolizzaIncendioFurto p = new PolizzaIncendioFurto("BD898DE",10000, 2000);
		agenzia.cancella(p);

		PolizzaBase p2 = new PolizzaBase("BH838JI",3000);
		cout.println(agenzia.cancella(p2));

		cout.println("Premi. " + agenzia.sommaPremiAnnui());
		cout.println(list);
		cout.println(agenzia.polizzeRC());
		cout.close();
	}
}