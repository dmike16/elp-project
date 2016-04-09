package dmike.singleton;


final class Singleton{
  private Singleton(int x){
    this.x = x;
  }
  private int x;
  private static Singleton singleton;
  public static Singleton getReference(){
    if (singleton == null){
      singleton = new Singleton(47);
    }
    return singleton;
  }
  public void setValue(int n){
    x = n;
  }
  public int getValue(){
    return x;
  }
}
public class SingletonPattern{
  public static void main(String[] args) {
    Singleton s = Singleton.getReference();
    System.out.println(s.getValue());
    Singleton s2 = Singleton.getReference();
    System.out.println((s == s2));

    LimitedConnection conn1 = LimitedConnection.getReference();
    LimitedConnection conn2 = LimitedConnection.getReference();
    LimitedConnection conn3 = LimitedConnection.getReference();
    System.out.println(conn1);
    System.out.println(conn2);
    System.out.println(conn3);
    LimitedConnection conn4 = LimitedConnection.getReference();
    System.out.println(conn4);
    conn2.dispose();
    conn4 = LimitedConnection.getReference();
    System.out.println(conn4);
  }
}
