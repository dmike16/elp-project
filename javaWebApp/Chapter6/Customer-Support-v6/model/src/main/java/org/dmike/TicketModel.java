package org.dmike;

/**
 * Created by andrea on 24/04/16.
 * @author dmike
 */

import java.util.Map;

public class TicketModel {
    public TicketModel(){
        super();
    }
    public TicketModel(int rdbms){
        this.rdbms = rdbms;
    }

    public int store(Ticket ticket){
        DAOFactory ticketFactory = DAOFactory.getDAOFactory(DAOFactory.POJO);

        return ticketFactory.getTicketDAO().insert(ticket);
    }
    public Map<Integer,Ticket> retrive(){
        DAOFactory ticketFactory = DAOFactory.getDAOFactory(DAOFactory.POJO);
        return ticketFactory.getTicketDAO().retrive();
    }

    public Ticket retrive(int pk){
        DAOFactory ticketFactory = DAOFactory.getDAOFactory(DAOFactory.POJO);
        return ticketFactory.getTicketDAO().retrive(pk);
    }


    private int rdbms;
}
