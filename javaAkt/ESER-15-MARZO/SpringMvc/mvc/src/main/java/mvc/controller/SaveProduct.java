package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import mvc.domain.Product;
import mvc.domain.ProductDb;
import mvc.form.ProductForm;
import mvc.validate.FormValidate;

public class SaveProduct implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ProductForm pdt = new ProductForm();

		pdt.setName(request.getParameter("title"));
		pdt.setDescription(request.getParameter("isbn"));
		pdt.setPrice(request.getParameter("price"));
		pdt.setAuthor(request.getParameter("author"));

		FormValidate vp = new FormValidate();
		List<String> errors = vp.validate(pdt);

		ModelAndView mv = null;

		if(errors.isEmpty()){
			
			ProductDb db = null;
			try{
				db = new ProductDb();
												
				Product p = new Product();

				p.setName(pdt.getName());
				p.setDescription(pdt.getDescription());
				p.setPrice(Float.parseFloat(pdt.getPrice()));
				p.setAuthor(pdt.getAuthor());
				
				db.insert(p);
				
				mv = new ModelAndView("listProduct");
				mv.getModel().put("product", p);
			}catch(Exception e){
				errors.add(e.getMessage());
				mv = new ModelAndView("ProductForm");
				mv.getModel().put("errors", errors);
				mv.getModel().put("product", pdt);
			}finally{
				try{
					db.dispose();
				}catch(Exception e){
					errors.add(e.getMessage());
				}
			}
		}else{
			mv = new ModelAndView("ProductForm");
			mv.getModel().put("errors", errors);
			mv.getModel().put("product", pdt);
		}


		return mv;
	}

}
