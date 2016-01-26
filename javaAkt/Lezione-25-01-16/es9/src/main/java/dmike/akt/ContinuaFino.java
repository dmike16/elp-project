/**
* Input una sequenza di interi fino a :
*	-negativo e divisibile per 2
*	-positivo e divisibile per 3
* Output stampo la somma di quelli che soddisfano tali condizioni
*	@author dmike;
*
*/
package dmike.akt;

import java.util.Scanner;

public class ContinuaFino{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		int sum = 0;

		System.out.print("Inserisci un numero: ");
		for(int n = cin.nextInt(); (n < 0 && n%2 == 0) || (n > 0 && n%3 == 0); n = cin.nextInt()){
			System.out.print("Inserisci numeri: ");
			sum += n;
		}

		System.out.println("La Somma è " + sum);
		cin.close();
	}
}