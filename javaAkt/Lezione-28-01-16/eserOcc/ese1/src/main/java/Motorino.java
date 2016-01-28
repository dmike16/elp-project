public class Motorino{
	private final String tipo;
	private String colore;
	private final double maxVel;

	public Motorino(String tipo, String colore, double max){
		this.tipo = tipo;
		this.colore = colore;
		if (max < 0)
			this.maxVel = 50;
		else
			this.maxVel = max;
	}
	public Motorino(String tipo, double max){
		this(tipo,"No color",max);
	}
	public String getTipo(){
		return tipo;
	}
	public String getColore(){
		return colore;
	}
	public void setColore(String col){
		this.colore = col;
	}
	public double getMaxVel(){
		return maxVel;
	}
	@Override
	public String toString(){
		return "Modello: " + this.getTipo() + " " + " Colore: " +
		this.getColore() + " Max Velocità: " + String.format("%.2f",this.getMaxVel());
	}
}