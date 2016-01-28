public class Circonferenza extends FiguraPiana{
	private final double raggio;

	public Circonferenza(double r){
		super("Circonferenza");
		this.raggio = r;
	}
	public double getArea(){
		return this.raggio * this.raggio * Math.PI;
	}
	public double getPerimetro(){
		return this.raggio*2*Math.PI;
	}
	public String toString(){
		return this.getNome() + " , " + "r=" + this.raggio;
	}
}