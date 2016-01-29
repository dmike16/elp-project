public class LavoratoreConStraordinariPagati extends Lavoratore{
	public LavoratoreConStraordinariPagati(String nome, int liv,
		double stip, int ore)
	{
		super(nome,liv,stip);
		this.oreStraordinario = ore;
	}
	public LavoratoreConStraordinariPagati(String nome,double stip,
		int ore)
	{
		this(nome,0,stip,ore);
	}
	public int getOre(){
		return oreStraordinario;
	}
	public LavoratoreConStraordinariPagati setOre(int ore){
		this.oreStraordinario = ore;
		return this;
	}
	public static void cambiaRetribuzioneOraria(int ret){
		LavoratoreConStraordinariPagati.restribuzioneOraria = ret;
	}
	@Override
	public String toString(){
		return super.toString() + " || OreStra :: " + getOre();
	}
	@Override
	public double getSalario(){
		return super.getSalario() + oreStraordinario*LavoratoreConStraordinariPagati.restribuzioneOraria;
	}
	private int oreStraordinario;
	private static int restribuzioneOraria = 10;
}