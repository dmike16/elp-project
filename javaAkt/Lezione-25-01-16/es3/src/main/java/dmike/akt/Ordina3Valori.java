/**
* Prende tre valori e li stampa in ordine crescente
* @author dmike
*
*/
package dmike.akt;

import java.util.Scanner;

public class Ordina3Valori{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci tre valori");

		System.out.print("N1= ");
		int n1 = cin.nextInt();

		System.out.print("N2= ");
		int n2 = cin.nextInt();

		System.out.print("N3= ");
		int n3 = cin.nextInt();

		System.out.println("Ordine crescente: " + 
			((n1 < n2)? (n3 < n1)? n3 + " " + n1 + " " + n2: 
			(n3 < n2)? n1 + " " + n3 + " " + n2 : n1 + " " + n2 + " " + n3:
			(n3 < n2)? n3 + " " + n2 + " " + n1: (n3 < n1)? n2 + " " + n3 + " " + n1:
			n2 + " " + n1 + " " + n3));

		cin.close();
	}
}