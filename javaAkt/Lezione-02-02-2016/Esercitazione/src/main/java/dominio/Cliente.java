package dominio;

import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	public Cliente(String nome,String cognome, int gg, int mm, int aa)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = (new GregorianCalendar(aa,mm-1,gg)).getTime();
	}
	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public int getEta(){
		long millSecondDiff = (new Date()).getTime() - this.dataNascita.getTime();
		return (int) ((millSecondDiff / 86400000) / 365);
	}
	@Override
	public String toString(){
		return getNome() + " " + getCognome() + " anni " +
		getEta();
	}
	private final String nome;
	private final String cognome;
	private final Date dataNascita;
}