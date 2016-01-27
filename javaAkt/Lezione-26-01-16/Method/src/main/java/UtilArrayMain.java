import java.util.Arrays;

public class UtilArrayMain{
	public static void main(String[] args){
		int[] a = {34,34,12,2,0,4,1,24};
		UtilArray.stampa(a);

		int x = 34;
		System.out.println("Il numero " + x + " compare " +UtilArray.contaOccorrenze(a,x)+ " volte");
		int[] a1 = {1,2,3,4};
		int[] a2 = {1,2,3,4};
		int[] a3 = a1;

		System.out.println("Uguaglianza Superficile: a1 == a2 -> " + (a1 == a2));
		System.out.println("Uguaglianza Profonda: a1 == a2 -> " + Arrays.equals(a1,a2));
		System.out.println("Uguaglianza Superficile: a1 == a3 -> " + (a1 == a3));

		int[] b = {7,3,4,1,2};
		System.out.print("Array iniziale ");
		UtilArray.stampa(b);
		System.out.print("Array solo pari ");
		UtilArray.stampa(UtilArray.numeriPari(b));

		int c[] = {6,9,1,2,12};
		System.out.println("La somma dei numeri multipli di 2 e 3 è: " + 
			UtilArray.sommaMultipli2e3(c));
		System.out.println("Numeri dispari in " + Arrays.toString(c) +
			" : " + UtilArray.contaDispari(c) + "\n" +
			"Elemeto massimo: " + UtilArray.max(c));
		System.out.println("L array " + (UtilArray.tuttiPari(c) ? "": "non") + 
			" ha tutti gli elementi pari");
		int k = 4;
		System.out.println("L array " + (UtilArray.tuttiMinoriDik(c,k) ? "": "non") + 
			" ha tutti gli elementi minori di " + k);
		int[] cc = {34,3,2,3,4,4,4,3};
		System.out.println("L array " + (UtilArray.elementi3k(cc,k) ? "": "non") + 
			" ha tre elementi uguali a " + k);
		System.out.println("L array " + (UtilArray.elementi3kConsecutivi(cc,k) ? "": "non") + 
			" ha tre elementi consecutivi uguali a " + k);

	}

}