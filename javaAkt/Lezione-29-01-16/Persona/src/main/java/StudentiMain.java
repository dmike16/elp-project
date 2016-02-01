import java.util.Arrays;

public class StudentiMain{
	public static void main(String[] args){
		Studente s = new Studente("Goig","Rossi", "fdgsfsgt",
		"Roma", "Sfrewretet", 5);

		try{
			s.caricaVotoEsami(2,4,5,7,-8);
			System.out.println("Voto Esami " + 
				Arrays.toString(s.getVotoEsami()));
		}catch(VotoStudentiException e){
			e.printStackTrace();
		}

	}
}