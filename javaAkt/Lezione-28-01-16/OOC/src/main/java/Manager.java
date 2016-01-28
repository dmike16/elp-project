public class Manager extends Impiegato{
	private double bonus;

	public Manager(String name, int eta, double salario, int gg,
		 int mm, int aa,double bonus)
	{
		
		super(name, eta, salario, gg, mm, aa);
		this.bonus = bonus;
	}
	public Manager(String nome, double bonus){
		super(nome);
		this.bonus = bonus;
	}
	public double getBonus(){
		return this.bonus;
	}
	public void setBonus(double nBonus){
		this.bonus = nBonus;
	}
	@Override
	public double getSalario(){
		return super.getSalario() + bonus;
	}
	@Override
	public String toString(){
		return super.toString() + " / " + bonus;
	}
}