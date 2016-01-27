public class PersonaMain{
	public static void main(String[] args){
		Persona p = new Persona("Mario", 33);
		Persona p2 = new Persona("Max", 45);

		//String n = p2.nome; Error - Private Attribute
		String n = p2.getName();
		p2.setEta(-123);

		System.out.println("Eta: " + p2.getEta());
		System.out.println("Persona: " + p);
	}
}