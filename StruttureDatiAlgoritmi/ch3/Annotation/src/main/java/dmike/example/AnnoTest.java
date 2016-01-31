package dmike.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str() default "Testing";
	int val() default 10;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}

public class AnnoTest {
	@MyMarker
	@MyAnno(str="Annotaction Example", val= 100)
	public static void meth(){
		AnnoTest obj = new AnnoTest();
		
		try{
			Class<?> c = obj.getClass();
			Method m = c.getMethod("meth");
			if (m.isAnnotationPresent(MyMarker.class)){
				System.out.println("Marker Present");
			}
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.val() + " " + anno.str());
			
		}catch(NoSuchMethodException e){
			System.out.println("Method not found" + e);
		}
	}
	public static void main(String...args){
		AnnoTest.meth();
	}
}
