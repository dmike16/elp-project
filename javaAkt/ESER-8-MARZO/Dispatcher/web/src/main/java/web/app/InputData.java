package web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.controller.Controller;

public class InputData implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response){
		return "WEB-INF/jsp/veicoloForm.jsp";
	}
}
