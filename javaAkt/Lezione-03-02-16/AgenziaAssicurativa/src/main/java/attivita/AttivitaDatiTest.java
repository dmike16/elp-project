package attivita;

import assicurazioni.*;

class AttivitaDatiTest{
	public static void preparazione(Agenzia agenzia){
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("GH898JI",6000, 1000));
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("FH898JI",3000, 500));
		agenzia.aggiungiPolizza(new PolizzaBase("KO898JI",8000));
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("MK909JI",2000, 50));
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("BD898DE",10000, 2000));
		agenzia.aggiungiPolizza(new PolizzaBase("BH838JI",3000));
		agenzia.aggiungiPolizza(new PolizzaBase("DE898GT",1000));
		agenzia.aggiungiPolizza(new PolizzaBase("ER898JI",9000));
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("ED898JI",3000, 3000));
		agenzia.aggiungiPolizza(new PolizzaIncendioFurto("SD898JI",26000, 23000));
	}
}