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

		int[][] matrice = {
			{9,1,2},
			{0,2,4}
		};
		UtilArray.stampa(matrice);
		System.out.print("Array media : " + 
			Arrays.toString(UtilArray.mediaMatrice(matrice)));
		System.out.println();

		UtilArray.riempiRandom(a3,2,8);
		System.out.print("Array riempito Random : ");
		UtilArray.stampa(a1);
		UtilArray.swap(b,-1,5);
	}

}