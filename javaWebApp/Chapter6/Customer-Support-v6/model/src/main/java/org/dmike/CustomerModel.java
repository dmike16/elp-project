package org.dmike;

import org.dmike.Customer;

import java.util.Map;

/**
 * @author dmike
 *
 */
public class CustomerModel
{
    public CustomerModel(){
        super();
    }
    public CustomerModel(int type){
        this.rdbms = type;
    }

    public boolean checkUserCredentials(Customer user){
        DAOFactory customerFactory = DAOFactory.getDAOFactory(DAOFactory.POJO);
        CustomerDAO custDAO = customerFactory.getCustomerDAO();

        return custDAO.hasPermission(user);
    }

    public boolean checkUserCredentials(Customer user, Map<String,String> errors){
        DAOFactory customerFactory = DAOFactory.getDAOFactory(DAOFactory.POJO);
        CustomerDAO custDAO = customerFactory.getCustomerDAO();
        boolean check = false;

        if(!custDAO.hasUserName(user)){
            errors.put("username","User Name Invalid");
        }else{
            if(!custDAO.hasPermission(user)){
                errors.put("password","password not correct");
            }else{
                check = true;
            }
        }

        return check;
    }

    private int rdbms;

}
