/**
* Example of Server class with method and class Client that use this method
* @author dmike
*/
import java.util.Arrays;

public class UtilStringMain{
	public static void main(String[] args){
		char c = 'b';
		String s = "Anna";
		String alphaNum = "Hrj2s34jk11";
		
		System.out.println(c + (UtilString.eVocale(c)? " è ": " non è ") + "una vocale");
		System.out.println(s + (UtilString.haVocali(s)? " ha ": " non ha ") + "vocali");
		System.out.println(s + " ha " + UtilString.quanteVocali(s) + " vocali");
		System.out.println("Il contrario di " + s + " è " + UtilString.contrario(s));
		System.out.println(s + (UtilString.palindromo(s)? " è ": " non è ") + " palindromo");
		System.out.println("La somma delle cifre in " + alphaNum + " è " + UtilString.sommaCifre(alphaNum));
		
		int[] a = {34,1,34,0,45,34,14};
		System.out.println(Arrays.toString(a));
	}


}