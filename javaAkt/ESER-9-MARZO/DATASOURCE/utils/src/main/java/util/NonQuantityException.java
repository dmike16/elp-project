package util;

public class NonQuantityException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NonQuantityException(){
		super("Quantità non disponibile");
	}
	public NonQuantityException(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString(){
		return msg;
	}
	private String msg = "Quantità non disponibile";
}
