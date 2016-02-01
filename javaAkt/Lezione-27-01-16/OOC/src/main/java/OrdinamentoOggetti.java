import java.util.Arrays;

public class OrdinamentoOggetti{
	public static void main(String[] args){
		Impiegato imp = new Impiegato("Mario",34,1434,12,12,2015);
		Impiegato imp2 = new Impiegato("Max");

		Impiegato[] impiegati = {
			imp,
			imp2,
			new Impiegato("Bob")
		};
		for(Impiegato i : impiegati){
			System.out.println(i);
		}
		System.out.println("After");
		Arrays.sort(impiegati);
		for(Impiegato i : impiegati){
			System.out.println(i);
		}
	}
}