package org.dmike;

/**
 * Created by dmike on 16/04/16.
 * @author dmike
 */
public abstract class DAOFactory {
    public static final int POJO= 1;

    public abstract CustomerDAO getCustomerDAO();
    public abstract TicketDAO getTicketDAO();

    public static DAOFactory getDAOFactory(int type){
        switch (type) {
            case POJO:
                return new PojoDAOFactory();
            default:
                return null;
        }
    }

}
