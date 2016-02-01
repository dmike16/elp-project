import dmike.polimorfism.*;

public class SociTest{
	public static void main(String[] args){
		Persona p[] = {
			new Persona("Mario", "Manzikic", "MDDMDDMDM", "Torino"),
			new Soci("Marco","zIO","ZMZMZM","Roma","KDOKDEOKDE",
				5,40.00),
			new Soci("Gianno","Bella","ZMZMZM","Roma","KDOKDEOKDE",
				9,50.00),
			new Persona("Valerio","IO","ZMZMZM","Roma"),
			new Pagamenti("Pino","zIO","ZMZMZM","Roma","KDOKDEOKDE",
				5,40.00,100.00)
		};
		// Override Dinamico
		for (Persona l: p){
			if (l instanceof Soci){
				// Override statico per i Soci dinamco per Pagamenti
				System.out.println(((Soci)l).calcoloTotale());
			}else{
				System.out.println(l);
			}
		}
	}
} 