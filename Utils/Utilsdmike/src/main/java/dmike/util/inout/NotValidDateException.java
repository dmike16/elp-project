package dmike.util.inout;

public class NotValidDateException extends Exception{
	public NotValidDateException(){}
	public NotValidDateException(String err){
		super(err);
	}
}
