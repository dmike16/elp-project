package app02c.db;

import app02c.domain.*;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ProductDb {

    private Connection con;

    public ProductDb() throws ClassNotFoundException, SQLException, NamingException {
        establishConnection();
    }

    // method used to establish connection with database
    private void establishConnection() {
    	/*
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String conUrl = "jdbc:odbc:productDSN";
        con = DriverManager.getConnection(conUrl);
        */
    	
    	/*
    	String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    	String username = "SYSTEM";
    	String password = "arnaldo";
		*/
    	try {
    		Context initContext = new InitialContext();
    		Context envContext = (Context) initContext.lookup("java:comp/env");
    		DataSource ds = (DataSource) envContext.lookup("jdbc/hr");
    		con = ds.getConnection();
    	} catch (SQLException e) {
    		System.out.println("SQLException "+e);
    	} catch (NamingException e) {
    		System.out.println("NamingException "+e);
    	}

        //con = DriverManager.getConnection(dbURL,username,password);
    }

    // used to search the product against first name and returns the ArrayList
    // that contains only those Product objects which matches the search criteria
    public ArrayList retrieveProductList(String pName){
        ArrayList prodList = new ArrayList();
        try {
        	

       	String sql = "SELECT * FROM my_products WHERE name = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.setString(1, pName);

        ResultSet rs = pStmt.executeQuery();

        String name;
        String description;
        double price;

        while (rs.next()) {
            name = rs.getString("name");
            description = rs.getString("description");
            price = rs.getInt("price");

            // creating a Product object
            Product prodBean = new Product();
            prodBean.setName(name);
            prodBean.setDescription(description);
            prodBean.setPrice(price);

            // adding a bean to arraylist
            prodList.add(prodBean);
        }
        } catch (SQLException e) {
        	System.out.println("SQLException "+e);
        }
        return prodList;
    }

    // this method accepts an object of Product, and stores it into the database
    public void addProduct(Product product) throws SQLException {
        String sql = " INSERT INTO my_products VALUES (?, ?, ?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        String name = product.getName();
        String description = product.getDescription();
        double price = product.getPrice();

        pStmt.setString(1, name);
        pStmt.setString(2, description);
        pStmt.setDouble(3, price);

        pStmt.executeUpdate();
    }

    // overriding finalize method to release acquired resources
    public void finalize() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
        }
    }
}
