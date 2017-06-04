package dmike.example;

public class CarModelServiceHardCoded implements CarModelService{

  @Override
  public String[] getCarModels() {

    String [] carModelsAvailable = {"Ford","Chrysler","Toyota","Nissan"};
    
    return carModelsAvailable ;
  }

}
