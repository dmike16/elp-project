package d.mike.example;

/**
 * Created by dmike on 22/11/14.
 * @author dmike
 * @author d.mike gruop
 * @version 1.0
 * 
 *
 */
public class Connection {
    public static Connection makeConnection(){
        return new Connection();
    }
    public static Connection makeConnection(int id, String type){
        return new Connection(id,type);
    }
    public String getType(){return type;}
    public int getId(){return id;}
    public void setType(String conn){
        type =conn;
    }
    public void setId(int num){
        id =num;
    }
    private String type="No Name";
    private int id=-1;
    private Connection (){}
    private Connection (int id, String type){
        this.id =id;
        this.type =type;
    }
}