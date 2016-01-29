import java.util.*;

public class Polimorfismo{
	public static void main(String[] args){
		Persona p = new Persona("Mario", 34);
		Persona p2 = new Impiegato("Alice");
		Persona p3 = new Manager("Bob",400);
		Persona p4 = new Studente("Manzucic",22, 22,12,2006,"8998989");
		Persona persone[]  = {p, p2 ,p3, p4};

		/*
		Studente s = p1 // error compilazione
		Studente s = (Studente) p1 // RunTimeExcecution
		Persona p = p2; // Okay (Polimorfismo)
		*/

		for(Persona elem : persone){
			//String name = elem.getName();
			//System.out.println(elem);
			/*if(elem.getClass().equals(Impiegato.class)){
				Impiegato i = (Impiegato) elem;
				System.out.println(i.getName() + " " + i.getSalario());
			}*/
			if(elem instanceof Impiegato){
				System.out.println(((Impiegato)elem).getSalario() + " " +
					((Impiegato)elem).getName());
			}
		}
		Date d = (new GregorianCalendar(1990,10,23)).getTime();
		System.out.println(Arrays.toString(UtilPersone.selezionaDate(persone,d,200)));
	
		Figura[] fig = {
			new Rettangolo(20,10),
			new Circonferenza(2),
			new Cubo(3),
			new Sfera(2)
		};
		double sumArea = UtilFigure.sommaAree(fig);
		System.out.println("L'Area totale delle figure piane è :" + 
			String.format("%.2f",sumArea));

		Persona p1 = new Persona("Mario",90);
		Persona pe1 = new Persona("Mario",90);

		Persona p3p = p1;
		System.out.println(p1.equals(pe1));
		System.out.println(p1 == pe1);
	}
}