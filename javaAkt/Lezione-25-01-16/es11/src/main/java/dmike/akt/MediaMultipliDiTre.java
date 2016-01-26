/**
* Input Numeri interi se sono divisibili per 3 viene calcolata la media
* Output Media
*
*/
package dmike.akt;

import java.util.Scanner;

public class MediaMultipliDiTre{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.print("Quanti numeri vuoi inserire: ");
		int len = cin.nextInt();

		int countNum = 0;
		int sum = 0;

		for (int i = 0; i < len; i++){
			System.out.print("Inserisci numero ");
			int n = cin.nextInt();
			if ( n % 3 == 0){
				countNum++;
				sum += n;
			}
		}

		if (countNum != 0){
			System.out.println("La media è : " + (sum/countNum));
		}else {
			System.out.println("Non hai inserito nessun numero");
		}

		cin.close();
	}
}