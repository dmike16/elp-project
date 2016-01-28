public class Cubo extends FiguraSolida{
	private final double lato;

	public Cubo(double l){
		super("Cubo");
		this.lato = l;
	}
	public double getVolume(){
		return lato*lato*lato;
	}
	public String toString(){
		return this.getNome() + " , " + "l=" + this.lato;
	}
}