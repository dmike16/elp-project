/**
* Example of java Exception
* @author dmike
*/
package dmike.example;

class MyException extends Exception{
  MyException() {
    x = 0;
  }
  MyException(String msg){
    super(msg);
    x = 0;
  }
  MyException(String msg, int x){
    super(msg);
    this.x = x;
  }
  int val(){
    return x;
  }
  public String getMessage(){
    return "Datail Message: " + x + " "+ super.getMessage();
  }
  private final int x;
}


class MySecondException extends Exception{
  MySecondException(){}
  MySecondException(String msg){
    super(msg);
  }
  public String getMessage(){
    return "Another Exception Source " + super.getMessage();
  }
}

public class HandleException {
  public void g()
    throws MyException
  {
    System.out.println("G is throwing an Exception");
    throw new MyException("From g()",47);
  }
  public void f()
    throws MySecondException
  {
    try{
      System.out.println("Trying to call g()");
      g();
    }catch(MyException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args){
    ConstructorsException p = null;
    try{
      p = new ConstructorsException("Bella",4);
    } catch(Exception e){
      System.out.println("Constructor Fail. Cannot use the object ");
      e.printStackTrace();
    } finally{
      if ( p != null)
        p.dispose();
    }
  }
}
