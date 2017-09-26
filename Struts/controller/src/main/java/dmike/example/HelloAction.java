package dmike.example;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport implements SessionAware{
	
	@Override public String execute() throws Exception{
	  if("exception".equalsIgnoreCase(userName)){
	    throw new Exception("OOO Exception");
	  }
		messageStore = new MessageStore();		
		messageStore.setMessage(String.format("%s to %s", messageStore.getMessage(),userName));
		increaseHelloCount();
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

	@Override  public void setSession(Map<String, Object> session) {
    userSession = session;
    
  }
	
	private void increaseHelloCount(){
	  Integer helloCount = (Integer)userSession.get(HELLO_COUNT);
	  if(helloCount == null){
	    helloCount = 0;
	  }
	  userSession.put(HELLO_COUNT, ++helloCount);
	}

	private String userName;
	private MessageStore messageStore;
	private Map<String,Object> userSession;
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(HelloAction.class);
  private static final String HELLO_COUNT = "helloCount";
	
}
