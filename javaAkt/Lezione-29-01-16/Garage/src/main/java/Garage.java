import java.util.ArrayList;
import java.util.Arrays;

public class Garage{
	public Garage(){}
	public void inserisciVeicolo(VeicoloAMotore vec){
		if (!isFull() && (isSupportato(vec))){
			veicoli.add(vec);
		}
	}
	public VeicoloAMotore estraiVeicolo(int n){
		if(n >= veicoli.size() || veicoli.isEmpty()){
			return null;
		}
		return veicoli.get(n);
	}
	public void stampa(){
		int i = -1;
		VeicoloAMotore p = null;
		while((p = estraiVeicolo(++i)) != null){
			System.out.println("Post " + i + "\n" +
				p);
		}
	}
	public static void addSupportedVeicol(Class<? extends VeicoloAMotore> veic){
		supported.add(veic);
	}
	private boolean isSupportato(Object obj){
		for(Class<?> p: supported){
			if(p.isInstance(obj)){
				return true;
			}
		}
		return false;		
	}
	private boolean isFull(){
		return veicoli.size() == 15;
	}
	private static ArrayList<Class<? extends VeicoloAMotore>> supported = 
		new ArrayList<>(Arrays.asList(
			Automobile.class,
			Furgone.class,
			Motocicletta.class
			));
	private static int capienza = 15;
	private final ArrayList<VeicoloAMotore> veicoli = new ArrayList<>();
}