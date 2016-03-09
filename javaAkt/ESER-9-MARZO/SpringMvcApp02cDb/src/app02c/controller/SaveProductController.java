package app02c.controller;

import app02c.db.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app02c.domain.Product;
import app02c.form.ProductForm;
import app02c.validator.ProductValidator;

public class SaveProductController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request,
            HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        // populate action properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        String jspname = null;
        // validate ProductForm
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if (errors.isEmpty()) {
            // create Product from ProductForm
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            // no validation error, execute action method
            // insert code to save product to the database
            
            /*
            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);
            */
            
            try {
            	ProductDb productDb = new ProductDb();
            	productDb.addProduct(product);
                // store product in a scope variable for the view
                // inserisce dati in model perché il jsp possa visualizzarli
                request.setAttribute("product", product);
                // indica al Dispatcher Servlet a quale VIEW (jsp) deve passare il controllo
                jspname = "/WEB-INF/jsp/ProductDetails.jsp"; 
            } catch (Exception e){
            	errors.add("Eccezione: "+e.getMessage());
                request.setAttribute("errors", errors);
                request.setAttribute("form", productForm);
                jspname = "/WEB-INF/jsp/ProductForm.jsp";
            }
            
        } else {
            // store errors and form in a scope variable for the view
        	// inserisce dai in model perché il jsp possa visualizzare i dati
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            // indica al Dispatcher Servlet a quale VIEW (jsp) deve passare il controllo
            jspname = "/WEB-INF/jsp/ProductForm.jsp";
        }
        return jspname;
    }

}
