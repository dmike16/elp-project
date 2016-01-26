/**
* Input numero intero è calcola le prime 10 potenze
*	@author dmike
*
*/
package dmike.akt;

import java.util.Scanner;

public class Potenze{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci un numero intero");
		System.out.print("N=");
		int n = cin.nextInt();

		for(int i = 0; i < 11; i++){
			System.out.println("La potenza di " + n + " elevato a " + i + " è " +
				(int)Math.pow(n,i));
		}
		cin.close();
	}
}