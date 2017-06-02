package dmike.example;

public class MessageStore {
	
	public MessageStore(){
		message = "Hello Struts";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override public String toString(){
		return String.format("%s (from toString)", message);
	}

	private String message;

}
