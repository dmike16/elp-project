import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Arrays;

public class ImpiegatoMain{
	public static void main(String[] args){
		Impiegato imp = new Impiegato("Mario",34,1434,12,12,2015);
		Impiegato imp2 = new Impiegato("Max");

		imp.aumentoSalario(18);
		System.out.println(imp);
		System.out.println(imp2);

		Impiegato[] impiegati = {
			imp,
			imp2,
			new Impiegato("Bob")
		};

		Impiegato maxsalario = UtilImpiegati.maxSalario(impiegati);
		System.out.print("L'impiegato con stipendio maggiore è : ");
		System.out.println(maxsalario.getNome() + " con stipendio " + maxsalario.getSalario());

		System.out.println("Next iD : " + Impiegato.getNextId());

		double salario = 2000;
		Date d = (new GregorianCalendar(1990,11,22)).getTime();
		Impiegato[] impDate = UtilImpiegati.selezionaDate(impiegati,d,salario);

		System.out.println("Impiegati assunti prima di " + d + " con salario almeno di " + salario);
		for(Impiegato ele: impDate){
			System.out.println(ele);
		}
	}
}