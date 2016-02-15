package action.db;

public class Item {
	public Item(){}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getTransportCost() {
		return transportCost;
	}
	public void setTransportCost(double transportCost) {
		this.transportCost = transportCost;
	}
	@Override
	public String toString(){
		return "COD: " + getCod() + "\n"+
				"CAT: " + getCat() + "\n" +
				"DSC: " + getDescription() +"\n"+
				"PRI: " + getPrice() +"\n" +
				"IVA: " + getIva() + "\n" +
				"TCT: " + getTransportCost();
	}

	private String cod;
	private String cat;
	private String description;
	private double price;
	private int iva;
	private double transportCost;
}
