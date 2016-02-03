package assicurazioni;

public class PolizzaIncendioFurto extends PolizzaBase{
	public PolizzaIncendioFurto(){super();}
	public PolizzaIncendioFurto(String targa,long rc, long incf){
		super(targa,rc);
		this.IF = incf;
	}
	public long getIncedioFurto(){
		return  IF;
	}
	public void setIncendioFurto(long infc){
		this.IF = infc;
	}
	@Override
	public double premioAnnuale(){
		double tmp = (double)1/100;
		return tmp * (IF + getRC());
	}
	@Override
	public String toString(){
		return super.toString() + "\n Incendio e Furto: " + 
		getIncedioFurto();
	}
	@Override
	public int hashCode(){
		return super.hashCode() + (int)IF;
	}
	@Override
	public boolean equals(Object obj){
		if(super.equals(obj)){
			PolizzaIncendioFurto tmp = (PolizzaIncendioFurto) obj;
			return IF == tmp.getIncedioFurto();
		}
		return false;
	}
	private long IF = 0L;
}