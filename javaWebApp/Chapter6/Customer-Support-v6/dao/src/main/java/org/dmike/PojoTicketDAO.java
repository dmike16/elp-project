package org.dmike;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrea on 24/04/16.
 * @author dmike
 */
public class PojoTicketDAO implements TicketDAO {
    @Override
    public synchronized int insert(Ticket ticket) {
        int id = ++__PK_TICKET_DB;
        ticketDB.put(id,ticket);

        return id;
    }

    @Override
    public Map<Integer,Ticket> retrive() {
        LinkedHashMap<Integer,Ticket> all = new LinkedHashMap<>();

        for(Map.Entry<Integer,Ticket> entry: ticketDB.entrySet()) {
            all.put(entry.getKey(), entry.getValue().clone());
        }

        return all;
    }

    @Override
    public Ticket retrive(int id) {
        return ticketDB.get(id);
    }

    private static Map<Integer,Ticket> ticketDB;
    private static volatile int __PK_TICKET_DB;

    static {
        ticketDB = new LinkedHashMap<>();
        __PK_TICKET_DB = 0;
    }
}
