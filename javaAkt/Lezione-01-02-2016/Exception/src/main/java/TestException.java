import java.util.Scanner;

public class TestException {
	public static void main(String[] args){
		//Scanner cin = new Scanner(System.in);
		try{
			int[] a = new int[3];
			// OutOfBound
			//System.out.println(a[3]);
			//Null Exception
			String[] a2  = new String[3];
			//System.out.println(a2[0].length());
			//NumberFormat Exception
			//int n = Integer.parseInt("laac");
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Indice Inesistente");
			e.printStackTrace();
		} catch(NullPointerException e){
			System.out.println("Null Pointer");
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("I need an integer");
			e.printStackTrace();
		}finally{
			//CleanUp
			System.out.println("Questo blocco viene eseguito comunque");
		}
		System.out.println("Fine Programma");
		int a = 7, b = 0;
		try{
			System.out.println(dividi(a,b));
		}catch(ArithmeticException e){
			System.out.println("Divisione per zero non ammessa");
		}
	}
	public static int dividi(int a , int b)
	{
		int c;
		c = a/b;
		return c;
	}
}