// Classe Server
class UtilString{
	// Parametri escpliciti formali
	public static boolean eVocale(char c){
		String cs = "" + c;
		c = cs.toLowerCase().charAt(0);

		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
	public static boolean haVocali(String s){
		for (int i = 0, len = s.length(); i < len; i++){
			char c = s.charAt(i);
			if (eVocale(c)){
				return true;
			}
		}
		return false;
	}
	public static int quanteVocali(String s){
		int result = 0;

		for(int i = 0, len = s.length(); i < len; i++){
			if (eVocale(s.charAt(i))){
				result++;
			}
		}
		return result;
	}
	public static String contrario(String s){
		String result = "";

		for (int i = s.length()-1; i >= 0; result += s.charAt(i),i--);

		return result;
	}
	public static boolean palindromo(String s){
		int i = -1;
		int j = s.length();

		s = s.toLowerCase();

		while(++i < --j && s.charAt(i) == s.charAt(j));

		return  (i >= j);
	}
	public static int sommaCifre(String s){
		int sum = 0;

		for(int i = 0,len = s.length(); i < len; i++){
			if (Character.isDigit(s.charAt(i))){
				sum = sum + Integer.parseInt(s.substring(i,i+1));
			}
		}
		return sum;
	}
	public static void stampaIniziali(String Nome, String Cognome){
		System.out.println(Nome.toUpperCase().charAt(0) + "." + " " + Cognome.toUpperCase().charAt(0) + ".");
	}
	public static void stampaVocali(String s){
		for(int i = 0,len = s.length(); i < len; i++){
			if (eVocale(s.charAt(i)))
				System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	public static int contaOccorrenze(String s, char occ){
		int count = 0;

		for(int i = 0,len = s.length(); i < len; i++){
			if (s.charAt(i) == occ){
				count++;
			}
		}

		return count;
	}
	public static boolean occorrenze3Consecutive(String s, char occ){
		int count = 0;
		int i = 0;

		for(int len = s.length(); i < (len - 2) && count < 3; i++){
			if (s.charAt(i) == occ){
				count++;
			} else {
				count = 0;
			}
		}
		if (count < 3 && s.charAt(i++) == occ){
			count++;
			if (count < 3 && s.charAt(i++) == occ){
				count++;
			}
		}

		return (count == 3);
	}
	public static boolean caratteriConsecutivi(String s){
		int count = 0;
		for(int i = 0,len = s.length(); i < len - 2 && count < 3; i++){
			count = 0;
			for(int j = i; j < i + 3; j++){
				if(s.charAt(i) == s.charAt(j)){
					count++;
				}
			}
			if (count == 2)i++;
		}
		return (count == 3);
	}
	public static boolean occorrenzeConsecutive(String s, int n, char occ){
		int count = 0;

		for(int i = 0, len = s.length(); i < len && count != n; i++){
			if (s.charAt(i) == occ){
				count++;
			}else {
				count = 0;
			}
		}

		return (count == n);
	}
	public static String sostituisciOccorrenze(String s, char neww, char old){
		char[] temp = new char[s.length()];

		for(int i = 0,len = s.length(); i < len; i++){
			if(s.charAt(i) == old)
				temp[i] = neww;
			else
				temp[i] = s.charAt(i);
		}

		return (new String(temp));
	}
	public static String alternaString(String s,String t){
		char[] temp = new char[s.length()+t.length()];
		int min = 2*((s.length() < t.length())? s.length(): t.length());

		for(int i = 0; i < min; i = i + 2){
			temp[i] = s.charAt(i/2);
			temp[i + 1] = t.charAt(i/2);
		}
		for (int i = min/2; i < s.length(); i++)
			temp[i] = s.charAt(i);
		for(int i = min/2 ; i < t.length(); i++)
			temp[i] = t.charAt(i);

		return new String(temp);

	}
	public static void stampaConInizialiMaiuscole(String s){
		String result = s.substring(0,1).toUpperCase();

		int k = 1;
		for(int i = 1, len = s.length(),j = 0; i < len; i++){
			if (s.charAt(i) == ' ' || s.charAt(i) == ',' || s.charAt(i) == '.'){
				j++;
				result += s.substring(k,i+1);
				k = i + 1;
			}else if (j != 0) {
				result += s.substring(i,i + 1).toUpperCase();
				j = 0;
				k = i + 1;
			}
		}
		result += s.substring(k);
		System.out.println(result);
	}
}
