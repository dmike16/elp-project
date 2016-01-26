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
}