package dmike.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {
	public static void readFromCl()
		throws IOException
	{
		String s;
		
		try(BufferedReader cin = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("Insert a username: ");
			s = cin.readLine();
		}
		System.out.println("Your User Name is " + s);
	}
	public static void readConsole(){
		Console c = System.console();
		
		if(c == null){
			System.err.println("No Console functionalities");
			System.exit(1);
		}
		String username = c.readLine("Insert a username: ");
		System.out.println("Username is " + username);
	}
}
