/**
* Prende due numeri da input e controlla se sono uguali
* @author dmike
*
*/

package dmike.akt;

import java.util.Scanner;

public class Uguali{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci due numeri interi");
		
		System.out.print("N1 = ");
		int n1 = cin.nextInt();

		System.out.print("N2 = ");
		int n2 = cin.nextInt();

		// Using if and else
		/*System.out.print("I due numeri sono ");
		if (n1 == n2){
			System.out.println("uguali");
		}else {
			System.out.println("diversi");
		}*/

		//Using ternary constructor
		System.out.println("I due numeri sono " + 
			((n1 == n2)? "uguali": "diversi"));

		cin.close();
	}
}

