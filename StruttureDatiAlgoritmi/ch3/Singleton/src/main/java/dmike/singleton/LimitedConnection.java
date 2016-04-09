package dmike.singleton;

final public class LimitedConnection{
  public static int getLimit(){
    return limit;
  }
  public void dispose(){
    if (pool[id].out()){
      pool[id].deactive();
    }
  }
  public String toString(){
    return "Connection: " + msg + " port: " + port;
  }
  public static LimitedConnection getReference(){
    if (pool == null){
      pool = new LimitedConnection[limit];
      pool[0] = new LimitedConnection("Inside",80,0);
      pool[1] = new LimitedConnection("Middle",48,1);
      pool[2] = new LimitedConnection("OutSide",90,2);
    }
    LimitedConnection ref = null;
    for(int i = 0; i < limit && ref == null; i++){
      if (pool[i].in()){
        ref = pool[i];
        ref.active();
      }
    }
    if (ref != null)
      return new LimitedConnection(ref.msg,ref.port,ref.id);

    return null;
  }
  private void active(){
    checkIn = false;
    checkOut = true;
  }
  private void deactive(){
    checkIn = true;
    checkOut = false;
  }
  private boolean in(){
    return checkIn;
  }
  private boolean out(){
    return checkOut;
  }
  private LimitedConnection(){}
  private LimitedConnection(String msg, int port,int id){
    this.port = port;
    this.msg = msg;
    this.id = id;
  }
  private static LimitedConnection[] pool = null;
  private String msg = "";
  private int port = 0;
  private int id = 0;
  private boolean checkIn = true;
  private boolean checkOut = false;
  private static final int limit = 3;
}
