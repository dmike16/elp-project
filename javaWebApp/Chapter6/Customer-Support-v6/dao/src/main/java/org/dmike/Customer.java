package org.dmike;

import java.io.Serializable;

/**
 * Created by dmike on 16/04/16.
 * @author dmike
 */
public class Customer implements Serializable{

    public Customer() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    private static final long serialVersionUID = -5917832102169808022L;
}
