import java.util.*;

public class Collezioni{
	public static void main(String[] args)
		throws ExceptionPreCondozioni
	{
		Impiegato i1 = new Impiegato("Alice");
		Impiegato i2 = new Impiegato("Alex");

		Persona p1 = new Persona("Mario",25);
		Persona p2 = new Persona("Mario",25);

		ArrayList<Persona> list = new ArrayList<>();

		list.add(i1);
		list.add(i2);
		list.add(p1);
		list.add(p2);

		System.out.println(list);

		/*for(Persona ele : list){
			if (ele instanceof Impiegato){
				Impiegato i = (Impiegato)ele;
				System.out.println(i.getName() + " " + i.getSalario());
			}
		}*/

		HashSet<Persona> set = new HashSet<>();

		set.addAll(list);

		System.out.println(set);

		for(Persona ele: set){
			if (ele.getClass().equals(Persona.class)){
				System.out.println(ele);
			}
		}

	}
}