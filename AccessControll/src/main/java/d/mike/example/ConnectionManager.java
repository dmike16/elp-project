package d.mike.example;

/**
 * Created by dmike on 22/11/14.
 * @author dmike
 * @author d.mike gruop
 * @version 1.0
 * 
 */
public class ConnectionManager {
    public static Connection getConn() {
        if (count >= listConn.length -1)
            return null;
        else {
            ++count;
            return listConn[count];
        }
    }
    private static Connection[] listConn = new Connection[4];
    private static int count = -1;

    static {
        listConn[0]= Connection.makeConnection(1,"OTG");
        listConn[1]= Connection.makeConnection();
        listConn[2]= Connection.makeConnection(2,"HDMI");
        listConn[3]= Connection.makeConnection(3,"USB");
    }
}
