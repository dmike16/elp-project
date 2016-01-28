public class Portafogli{
	private double euro;
	private double lire;
	private static final double CONVERSION_FACTOR = 1936.27;

	public Portafogli(){
		this.euro = 0;
		this.lire = 0;
	}
	public Portafogli(double euro, double lire){
		this.euro = euro;
		this.lire = lire;
	}
	public double getEuro(){
		return euro;
	}
	public double getLire(){
		return lire;
	}
	public void aggiungiEuro(double qty){
		if (qty < 0){
			togliEuro(Math.abs(qty));
		} else{
			this.euro += qty;
		}
	}
	public void aggiungiLire(double qty){
		if(qty < 0){
			togliLire(Math.abs(qty));
		}else {
			this.lire += qty;
		}
	}
	public void togliEuro(double qty){
		if ((this.euro -qty) > 0)
			this.euro -= qty;
		else
			System.out.println("Prelievo non Consentito hai pochi euro");
	}
	public void togliLire(double qty){
		if ((this.lire - qty) > 0)
			this.lire -= qty;
		else 
			System.out.println("Prelievo non Consentito hai poche lire");
	}
	public double quantiSoldi(){
		double conv = this.lire / CONVERSION_FACTOR ;
		return this.euro + conv;
	}
	public boolean alVerde(){
		return this.euro == 0 && this.lire == 0;
	}
	@Override
	public String toString(){
		return "EURO : " + this.getEuro() + " / LIRE : " + this.getLire();
	}
}