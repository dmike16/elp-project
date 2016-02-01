import java.util.Scanner;
import java.util.InputMismatchException;

class LavoraNumeri{
	public static boolean dividi(){
		Scanner cin = new Scanner(System.in);
		System.out.println("Inserisci 5 numeri");

		boolean completato = false;
		int count = 0;
		try{
			do{
				System.out.println("Numeri rimasti da inserire " + 
					(LavoraNumeri.NUMERODIVISIONI - count));
				int i = cin.nextInt();
				try{
					int c = LavoraNumeri.DIVIDENDO / i;
					count++;
				} catch(ArithmeticException e){
					System.out.println("Attenzion divisine per zero non ammessa");
				}
			} while(count < LavoraNumeri.NUMERODIVISIONI);
		}finally{
			if(cin != null)
				cin.close();
		}
		completato = true;

		return  completato;
	}
	public static void prendiNumero(){
		Scanner cin = new Scanner(System.in);
		System.out.println("Inserisci un numero Intero");

		do{
			try{
				int i = cin.nextInt();
				System.out.println("Il numero è"+ (LavoraNumeri.isPari(i)?
					" pari ":" dispari "));
				break;
			}catch(NumberFormatException | InputMismatchException e){
				System.out.println("Il numero deve essere intero");
				cin.next();
			}
		}while(true);

		cin.close();
	}
	public static boolean isPari(int n){
		return ((n & 1) == 0);
	}
	public static final int DIVIDENDO = 25;
	public static final int NUMERODIVISIONI = 5;
}

public class NumberTest{
	public static void main(String[] args){
		//boolean fatto = LavoraNumeri.dividi();
		//System.out.println("Divisione " + (fatto? "effettuata": "non effettuata"));
		
		LavoraNumeri.prendiNumero();
	}	
}