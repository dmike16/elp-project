/**
*	Input due numeri double. Più scelta dell'operazione da eseguire tramite menu
*	@author dmike
*/
package dmike.akt;

import java.util.Scanner;

public class Calcolatrice{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		System.out.println("Inserisci due numeri");
		System.out.print("x=");
		double x = cin.nextDouble();

		System.out.print("y=");
		double y = cin.nextDouble();

		System.out.println("Operazioni: ");
		System.out.println("1- Somma ");
		System.out.println("2- Sottrazione ");
		System.out.println("3- Moltiplicatione ");
		System.out.println("4- Divisione ");
		char choice = (char)cin.nextInt();
	
		double result = 0;
		boolean error = false;

		switch(choice){
			case 1:
				result = (x + y);
				break;
			case 2:
				result = (x-y);
				break;
			case 3:
				result = (x*y);
				break;
			case 4:
				if (y == 0)
					error = true;
				else
					result = (x/y);
				break;
			default:
				error = true;
				break;
		}

		System.out.println(((error)? "Operazione non consentita": "Il risultato è " + result));

		cin.close();
	}
}