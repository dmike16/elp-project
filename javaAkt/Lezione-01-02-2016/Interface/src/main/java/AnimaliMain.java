public class AnimaliMain{
	public static void main(String[] args){
		Animale[] animal = {
			new Gatto(),
			new Topo(),
			new Gatto(),
			new Cane()
		};
		for(Animale a: animal){
			a.verso();
			if (a instanceof Gatto){
				((Gatto)a).graffio();
			}
		}
		Cane c = new Cane();
		System.out.println((c instanceof Animale));
	}
}