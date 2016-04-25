package org.dmike;

/**
 * Created by dmike on 16/04/16.
 * @author dmike
 */
class PojoDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getCustomerDAO() {
        return new PojoCustomerDAO();
    }
    public TicketDAO getTicketDAO(){return new PojoTicketDAO();}
}
