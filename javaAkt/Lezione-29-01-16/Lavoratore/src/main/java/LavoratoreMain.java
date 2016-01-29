public class LavoratoreMain{
	public static void main(String[] args){
		Lavoratore l1 = new Lavoratore("Mario",3,1150.00d);
		Lavoratore l2 = new LavoratoreConStraordinariPagati("Alex",5,1150.00d,5);

		System.out.println(l1);
		System.out.println(l2);

		System.out.println(l1.getSalario());
		System.out.println(l2.getSalario());

	}
}