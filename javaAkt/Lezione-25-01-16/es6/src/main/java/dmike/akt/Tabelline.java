/**
*	Input un numero intero e stampa la tabellina
*	@author dmike
*/
package dmike.akt;

import java.util.Scanner;

public class Tabelline{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.println("Inserisci un numero");

		System.out.print("N=");
		int n = cin.nextInt();

		System.out.println("Tabellina di " + n);
		for(int i = 1; i < 11; i++){
			System.out.print(n*i + " ");
		}
		System.out.println("");

		cin.close();
	}
}