/**
*	Input sequenza di interi  e termina se inserisci 0
*	Output OK se c'è un positivo seguito da un negativo
*	@author dmike
*
*/
package dmike.akt;

import java.util.Scanner;

public class PositivoNegativo{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		boolean negFollowPos = false;
		int n;
		int old = 0;
		do{
			System.out.print("Inserisci numero (zero per terminare): ");
			n = cin.nextInt();
			if (old > 0 && n < 0){
				negFollowPos = true;
			}
			old = n;
		}while(n != 0 && !negFollowPos);
		for (;n != 0; n = cin.nextInt()){
			System.out.print("Inserisci numero (zero per terminare): ");
		}
		System.out.println((negFollowPos)? "OK":"NO");
		cin.close();

	}
}