package dmike.example;

public class EditServiceInMemory implements EditService{
  private static PersonBean person;
  private static String[] carModels = {"Ford","Nissan"};
  
  static{
    person = new PersonBean();
    person.setUserName("BrucePhill");
    person.setAge(23);
    person.setEmail("example@example.com");
    person.setSport("basketball");
    person.setGender("not sure");
    person.setResidency("KS");
    person.setOver21(true);   
    person.setCarModels( carModels);
  }
  @Override
  public PersonBean getPerson() {
    return EditServiceInMemory.person;
  }

  @Override
  public void savePerson(PersonBean personBean) {
    EditServiceInMemory.person.setUserName(personBean.getUserName() );
    EditServiceInMemory.person.setEmail(personBean.getEmail());
    EditServiceInMemory.person.setAge(personBean.getAge());
    EditServiceInMemory.person.setSport(personBean.getSport() );
    EditServiceInMemory.person.setGender( personBean.getGender() );
    EditServiceInMemory.person.setResidency( personBean.getResidency() );
    EditServiceInMemory.person.setOver21( personBean.isOver21() );
    EditServiceInMemory.person.setCarModels(personBean.getCarModels() );
    
  }

}
