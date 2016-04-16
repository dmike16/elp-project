package org.dmike;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by dmike on 16/04/16.
 * @author dmike
 */
class PojoCustomerDAO implements CustomerDAO{
    @Override
    public boolean hasPermission(Customer user) {
        return hasUserName(user) && credentials.get(user.getUsername()).equals(user.getPassword());
    }

    @Override
    public boolean hasUserName(Customer user) {
        return credentials.containsKey(user.getUsername());
    }

    private static final Map<String,String> credentials = new Hashtable<>();

    static {
        credentials.put("Nicholas", "password");
        credentials.put("Sarah", "drowssap");
        credentials.put("Mike", "wordpass");
        credentials.put("John", "green");
    }

}
