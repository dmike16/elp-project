package dmike.util.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handlerRequest(
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException;
	public String handlerResponse(
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException;
}
