/**
* Input una sequenza di interi. Stampa "tutti positivi e pari" se lo sono altrimenti "no" 
* @author dmike
*
*/
package dmike.akt;

import java.util.Scanner;

public class TuttiPositiviPari{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);

		System.out.print("Quanti numeri vuoi inserire: ");
		int len = cin.nextInt();

		int numCount = 0;
		int num = 0;
		boolean allPosAndEven = true;

		while(numCount < len && allPosAndEven){
			System.out.print("N" + ++numCount +"=");
			num = cin.nextInt();

			if (((num & 1) == 1) || (num < 0))
				allPosAndEven = false;
		}
		for (; numCount < len;){
			System.out.print("N" + ++numCount +"=");
			num = cin.nextInt();			
		}

		System.out.println((allPosAndEven)? "Tutti Pari e Positivi": "No");

		cin.close();
	}
}