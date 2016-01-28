public class Sfera extends FiguraSolida{
	private final double raggio;

	public Sfera(double r){
		super("Sfera");
		this.raggio = r;
	}
	public double getVolume(){
		return (4.0d/3.0d)*Math.PI*raggio*raggio*raggio;
	}
	public String toString(){
		return this.getNome() + " , " + "r=" + this.raggio;
	}
}