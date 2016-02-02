import dmike.polimorfism.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList<Persona> list = new ArrayList<>(Arrays.asList(p));
		// Override Dinamico
		for (Persona l: list){
			//if (l instanceof Soci){
				// Override statico per i Soci dinamco per Pagamenti
			//	System.out.println(((Soci)l).calcoloTotale());
			//}else{
				System.out.println(l);
			//}
		}
		Persona p1 = p[0].clone();
		Soci s1 = new Soci("Gianno","Bella","ZMZMZM","Roma","KDOKDEOKDE",
				9,50.00);
		Pagamenti pa1 = new Pagamenti("Pino","zIO","ZMZMZM","Roma","KDOKDEOKDE",
				5,40.00,100.00);
		System.out.println(p1 == p[0]);
		System.out.println(p1.equals(p[0]));
		System.out.println("**************************");
		Collections.sort(list);
		for (Persona l: list){
			//if (l instanceof Soci){
				// Override statico per i Soci dinamco per Pagamenti
			//	System.out.println(((Soci)l).calcoloTotale());
			//}else{
				System.out.println(l);
			//}
		}
	}
} 