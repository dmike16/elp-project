package cipolla;

public class NotValidDateException extends Exception{
	private static final long serialVersionUID = 1L;
	public NotValidDateException(){}
	public NotValidDateException(String err){
		super(err);
	}
}
