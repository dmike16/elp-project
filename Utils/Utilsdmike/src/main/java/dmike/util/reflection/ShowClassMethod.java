/**
 * Use this class to investigate the method of the argument class
 * @author dmike
 */
package dmike.util.reflection;

import java.util.regex.Pattern;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class ShowClassMethod {
	public static void show(String... args)
		throws Exception
	{
		if(args.length < 1){
			throw new Exception(usage);
		}
		
		int lines = 0;
		try{
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor<?>[] ctors = c.getConstructors();
			
			if(args.length == 1){
				for(Method m: methods){
					System.out.println(
							p.matcher(m.toString()).replaceAll(""));
				}
				for(Constructor<?> ctor : ctors){
					System.out.println(
							p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			}else {
				for(Method m: methods){
					if(m.toString().indexOf(args[1]) != -1){
						System.out.println(
								p.matcher(m.toString()).replaceAll(""));
						lines++;
					}
				}
				for(Constructor<?> ctor: ctors){
					if(ctor.toString().indexOf(args[1]) != -1){
						System.out.println(
								p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
			
		}catch(ClassNotFoundException e){
			System.out.println("No such class: " + e);
		}
	}
	public static void main(String[] args)
		throws Exception
	{
		ShowClassMethod.show(args);
	}
	
	private static String usage = "usage:\n" + 
			"ShowsClassMethods <qualified>.class.<name>\n" +
			"To show all method in a class. Or \n" + 
			"ShowClassMethod <qualified>.class.<name> <word>\n:" +
			"To search for a method involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
}
