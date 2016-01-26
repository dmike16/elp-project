/**
* Prende un numero di input e controlla se è pari o tra [0,100]
* @author dmike
*/

package dmike.akt;

import java.util.Scanner;

public class PariPiccolo{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci un numero intero");

		System.out.print("N=");
		int n = cin.nextInt();
		int lastBit = n & 1;

		System.out.println(((lastBit == 0 && n > 0 && n < 100)? "": "Non è") + " pari e piccolo");

		cin.close();
	}
}