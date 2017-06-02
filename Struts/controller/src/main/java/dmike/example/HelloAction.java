package dmike.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	@Override public String execute(){
		messageStore = new MessageStore();
		messageStore.setMessage(String.format("%s to %s", messageStore.getMessage(),userName));
		
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	private String userName;
	private MessageStore messageStore;
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
}
