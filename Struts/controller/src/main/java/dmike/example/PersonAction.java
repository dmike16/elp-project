package dmike.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PersonAction extends ActionSupport implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(PersonAction.class);
	private String[] sports;
	private String[] genders;
	private List<State> states;
	private String[] carModels;
	private EditService service = new EditServiceInMemory();
	private CarModelService carService = new CarModelServiceHardCoded();
	private PersonBean personBean;

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}
	
	
	public String[] getSports() {
    return sports;
  }
  
  public String[] getGenders() {
    return genders;
  }
  
  public List<State> getStates(){
    states = new ArrayList<>();
    states.add( new State("AZ", "Arizona") );
    states.add( new State("CA", "California") );
    states.add( new State("FL", "Florida") );
    states.add( new State("KS", "Kansas") );
    states.add( new State("NY", "New York") );
    
    
    return states;
  }


  public String[] getCarModels() {
    return carModels;
  }

  @Override public String execute(){
		LOG.info("[INFO] EXECUTE");
		service.savePerson(this.getPersonBean());
		return SUCCESS;
	}
	
	@Override public String input(){
		LOG.info("[INFO] INPUT");
		
		return INPUT;
	}
	
	public void prepareInput(){
	  LOG.debug("In prepareInput method..:");
	  sports = new String[]{"footbal","basketball","soccer"};
	  genders = new String[]{"M","F"};
	}
	
	public void prepareExecute(){
	  LOG.debug("In prepare execute method...");
	}

  @Override  public void prepare() throws Exception {
    // TODO Auto-generated method stub
    LOG.debug("In prepare method.....");
    carModels = carService.getCarModels();
    this.setPersonBean(service.getPerson());
  }

}
