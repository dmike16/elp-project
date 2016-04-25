package org.dmike;

import java.util.Map;

/**
 * Created by andrea on 24/04/16.
 * @author dmike
 */
public interface TicketDAO {
    int insert(Ticket ticket);
    Map<Integer,Ticket> retrive();
    Ticket retrive(int id);
}
