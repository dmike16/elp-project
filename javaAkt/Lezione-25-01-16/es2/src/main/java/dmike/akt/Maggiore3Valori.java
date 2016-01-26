/**
* Prende tre numeri in input e stampa il max
* @author dmike
*
*/
package dmike.akt;

import java.util.Scanner;

public class Maggiore3Valori{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci tre numeri");

		System.out.print("N1= ");
		int max = cin.nextInt();

		System.out.print("N2= ");
		int n2 = cin.nextInt();

		System.out.print("N3= ");
		int n3 = cin.nextInt();

		if (max < n2)
			max = n2;
		if(max < n3)
			max = n3;

		System.out.println("Il max è " + max);ù

		cin.close();
	}
}