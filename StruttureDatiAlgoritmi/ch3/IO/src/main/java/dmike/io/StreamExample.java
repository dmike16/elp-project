package dmike.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

class Copy{
	public static void copyBytes()
		throws IOException
	{
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try{
			in = new FileInputStream("file.txt");
			out = new FileOutputStream("fileC.txt");
			int c;
			
			while((c = in.read()) != -1){
				out.write(c);
			}
		} finally{
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}
	public static void copyCharacter()
		throws IOException
	{
		FileReader in = null;
		FileWriter out = null;
		
		try{
			in = new FileReader("file.txt");
			out = new FileWriter("fileChar.txt");
			int c;
			
			while((c = in.read()) != -1){
				out.write(c);
			}
		} finally{
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}
	public static void copyLine()
		throws IOException
	{
		BufferedReader in = null;
		PrintWriter out = null;
		
		try{
			in = new BufferedReader(new FileReader("file.txt"));
			out = new PrintWriter(new FileWriter("fileLine.txt"));
			
			String l;
			while((l = in.readLine()) != null){
				out.println(l);
			}
		} finally {
			if (in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}
	public static void scanXan()
		throws IOException
	{
		Scanner s = null;
		
		try{
			s = new Scanner(new BufferedReader(new FileReader("file.txt")));
			
			while(s.hasNext()){
				System.out.println(s.next());
			}
		} finally {
			if(s != null)
				s.close();
		}
	}
	public static void scanSum()
		throws IOException
	{
		Scanner s = null;
		double sum = 0;
		
		try{
			s = new Scanner(new BufferedReader(new FileReader("number.txt")));
			s.useLocale(Locale.US);
			
			while(s.hasNext()){
				if(s.hasNextDouble()){
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}
		} finally{
			s.close();
		}
		System.out.println("Sum = " + sum);
	}
}
public class StreamExample {
	public static void main(String[] args)
		throws IOException, ClassNotFoundException
	{
		//Copy.copyBytes();
		//Copy.copyCharacter();
		//Copy.copyLine();
		//Copy.scanSum();
		//CommandLine.readFromCl();
		//CommandLine.readConsole();
		PrimaryType.dataStream();
	}
}
