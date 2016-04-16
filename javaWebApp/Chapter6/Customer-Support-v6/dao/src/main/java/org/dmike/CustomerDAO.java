package org.dmike;

import sun.security.util.Password;

/**
 * Created by dmike on 16/04/16.
 * @author dmike
 */
public interface CustomerDAO {
    public boolean hasPermission(Customer user);
    public boolean hasUserName(Customer user);
}
