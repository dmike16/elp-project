public class MotorinoMain{
	public static void main(String[] args){
		Motorino mot = new Motorino("Piaggio Vespa","Rosso",100d);
		Motorino mot2 = new Motorino("Scarabeo",110d);

		mot2.setColore("Verde");

		System.out.println(mot);
		System.out.println(mot2);
	}
}