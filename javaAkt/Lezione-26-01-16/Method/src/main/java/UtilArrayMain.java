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

			char[] ab = {'a','b','c','b','a'};
		System.out.println("L array " + (UtilArray.alternanzaAeB(ab) ? "": "non") +
				" ha alternanze di a e b");
				UtilArray.stampaZipZag(b);

				int pd[] = {3,4,0,4};
				UtilArray.sommaPariDispari(pd);

				int[] aaa = {1,2,3,4}, bbb = {5,6,7,8,9,10};
				System.out.println("Array a U Array b : " +
					Arrays.toString(UtilArray.unisciArray(aaa,bbb)));

					int[] pari = {1,1,1,1}, dispari = {2,2,2,2};
					System.out.println("Array a U Array b : " +
						Arrays.toString(UtilArray.unisciAlternado(pari,dispari)));

					System.out.println("L Array " +
							(UtilArray.ordinato(aaa)? "": "non ") + "è ordinato");

					char[] seq = {'f','f','s','s','a','s','s','f'};
					System.out.println("L Array " +
								(UtilArray.caratteriConsecutivi(seq)? "": "non ") + "ha 3 caratteri consecutivi");
					//System.out.println("Il secondo Array è: " +
					//			Arrays.toString(UtilArray.secondoArray()));
		try{
			UtilArray.leggiArray();
		}catch(NegativeNumberException e){
			System.out.println("Non puoi Inserire numeri negativi");
			e.printStackTrace();
		}
	}
}
