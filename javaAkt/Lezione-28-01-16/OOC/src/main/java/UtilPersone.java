import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UtilPersone{
	public static Impiegato maxSalario(Impiegato[] impiegati){
		if (impiegati.length == 0)return null;

		Impiegato max = impiegati[0];

		for(int i = 1, len = impiegati.length; i < len; i++){
			if (impiegati[i].getSalario() > max.getSalario()){
				max = impiegati[i];
			}
		}

		return max;
	}
	public static Impiegato[] selezionaDate(Impiegato[] arr, Date d, double salario){
		int count = 0;
		for(Impiegato ele : arr){
			if (ele.getAssunzione().compareTo(d) < 0 && ele.getSalario() >= salario){
				count++;
			}
		}
		Impiegato[] imp = new Impiegato[count];
		count = 0;
		for(int i = 0,len = arr.length; i < len ; i++){
			if (arr[i].getAssunzione().compareTo(d) < 0 && arr[i].getSalario() >= salario){
				imp[count++] = arr[i];
			}	
		}

		return imp;
	}
	public static Impiegato[] selezionaDate(Persona[] arr, Date d, double salario){
		int count = 0;
		for(Persona ele : arr){
			if(ele instanceof Impiegato){
				Impiegato tmp = (Impiegato) ele;
				if (tmp.getAssunzione().compareTo(d) < 0 && tmp.getSalario() >= salario){
					count++;
				}
			}
		}
		Impiegato[] imp = new Impiegato[count];
		count = 0;
		for(int i = 0,len = arr.length; i < len; i++){
			if(arr[i] instanceof Impiegato){
				Impiegato tmp = (Impiegato) arr[i];
				if (tmp.getAssunzione().compareTo(d) < 0 && tmp.getSalario() >= salario){
					imp[count++] = tmp;
				}
			}	
		}

		return imp;
	}
	public static Persona leggiPersona()
	{
		System.out.println("Inserisci Nome ed Eta separati dal pipe: nome|eta");
		Scanner cin = new Scanner(System.in);
		Persona p = null;
		while(p == null){
		try{
			StringTokenizer st =  new StringTokenizer(cin.nextLine(),"|");

			String nome = st.nextToken().trim();
			int eta = Integer.parseInt(st.nextToken().trim());

			p = new Persona(nome,eta);
		} catch(RuntimeException e){
			System.out.println("Dati non inserici correttamente\n" +
				"Richiesto nome|eta");
			//e.printStackTrace();
		} catch(ExceptionPreCondozioni e){
			System.out.println("Eta negativa");
		}
	}
	cin.close();
	return p;
	}
}