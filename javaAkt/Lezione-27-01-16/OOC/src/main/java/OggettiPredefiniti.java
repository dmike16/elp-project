import java.util.*;

public class OggettiPredefiniti{
	public static void main(String[] args){
		Date d = new Date(); // Chiamata del costruttore

		System.out.println(d);

		Date d2 = null;
		if (d2 != null) 
			System.out.println(d2.toString()); // RuntimeException - NullPointException 
		
		GregorianCalendar calendar = new GregorianCalendar(2010,11,17);
		//Alternaticva
		// GregorianCalendar calendar  = new GregorianCalendar(2010,Calendar.DECEMBER,17);
		d2 = calendar.getTime();
		System.out.println(d2);		
	}
}