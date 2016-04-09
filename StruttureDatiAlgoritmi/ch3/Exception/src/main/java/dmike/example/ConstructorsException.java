package dmike.example;

class InsedeException extends Exception{
  InsedeException(){}
  public String getMessage(){
    return "Fail Inside the Constructor " + super.getMessage();
  }
}

class CleanAllUp {
  public void dispose(){
    System.out.println("Proper Clean up");
  }
}
public class ConstructorsException{
  public ConstructorsException(String msg, int c)
    throws InsedeException
  {
    String tmp=msg;
    cleanObj = new CleanAllUp();
    try{
      for(int i = 0; i < c; i++){
        tmp = tmp + "*-*";
        if (i == MAX){
          throw new InsedeException();
        }
      }
    }catch(InsedeException e){
      this.msg = msg;
      try{
        cleanObj.dispose();
      }finally{
        throw e;
      }
    }
    this.msg = tmp;
  }
  public String toString(){
    return "The message is: " + msg;
  }
  public void dispose(){
    cleanObj.dispose();
  }
  private static final int MAX = 3;
  private String msg;
  private CleanAllUp cleanObj;
}
