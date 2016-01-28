public class Rettangolo extends FiguraPiana{
	private final double base;
	private final double altezza;

	public Rettangolo(double b, double a){
		super("Rettangolo");
		this.base = b;
		this.altezza = a;
	}

	@Override
	public double getArea(){
		return this.base * this.altezza;
	}

	@Override
	public double getPerimetro(){
		return 2*(this.base + this.altezza);
	}
	public String toString(){
		return this.getNome() + " , " + "base=" + this.base + " altezza=" + this.altezza;
	}
}