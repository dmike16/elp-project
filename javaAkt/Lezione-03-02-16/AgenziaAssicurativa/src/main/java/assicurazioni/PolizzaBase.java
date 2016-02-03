package assicurazioni;

public class PolizzaBase{
	public PolizzaBase(){}
	public PolizzaBase(String targa, long rc){
		this.targa = targa;
		this.RC = rc;
	}
	public String getTarga(){
		return targa;
	}
	public void setTarga(String t){
		this.targa = t;
	}
	public long getRC(){
		return RC;
	}
	public void setRC(long rc){
		this.RC = rc;
	}
	public double premioAnnuale(){
		double tmp = (double)1/100;
		return tmp * getRC();
	}
	@Override
	public String toString(){
		return "Targa " + getTarga() + "\n RC " + getRC();
	}
	@Override
	public int hashCode(){
		return targa.hashCode() + (int)RC;
	}
	@Override
	public boolean equals(Object obj){
		if(obj != null && this.getClass().equals(obj.getClass())){
			PolizzaBase tmp = (PolizzaBase) obj;
			return targa.equals(tmp.getTarga()) && this.RC == tmp.getRC();  
		}
		return false;
	}
	private String targa = "Inserisci targa";
	private long RC = 0L;
}