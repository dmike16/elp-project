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
		UtilString.stampaIniziali("Mario","Rossi");
		UtilString.stampaVocali("Hello World");

		String contr = "Hello";
		System.out.println("Il contrario di " + contr + " è " + UtilString.contrario(contr));
		
		String helloWorld = "Hello World";
		char l = 'l';
		System.out.println("Occorrenze di " + l + " in " + helloWorld + " : " + 
			UtilString.contaOccorrenze(helloWorld,l));

		String treOcc = "Heeeellooo";
		char e = 'e';
		System.out.println("Il carrattere '" + e + 
			(UtilString.occorrenze3Consecutive(treOcc,e)? "'": "' non ") + 
			" appare tre volte consecutive in " + treOcc);

		String treGenericOcc = "JavaBBBase";
		System.out.println("La Stringa " + treGenericOcc + 
			(UtilString.caratteriConsecutivi(treGenericOcc)? "": " non ") + 
			" ha tre caratteri uguali consecutivi ");		

		int n = 4;
		System.out.println("Il carrattere '" + e + 
			(UtilString.occorrenzeConsecutive(treOcc,n,e)? "'": "' non ") + 
			" appare " + n + " volte consecutive in " + treOcc);

		System.out.println(UtilString.sostituisciOccorrenze(helloWorld,'*','l'));
		System.out.println(UtilString.alternaString("Hello","World"));
		UtilString.stampaConInizialiMaiuscole("uno , due tre");
		System.out.println((UtilString.anagramma("tttta","ttttb"))? " è " : " non è ");
	
		String ha = "ciaoBellai";
		String ah = "zio";
		System.out.println("Alternata = " + UtilString.unisciPariDispari(ha,ah));
	}


}