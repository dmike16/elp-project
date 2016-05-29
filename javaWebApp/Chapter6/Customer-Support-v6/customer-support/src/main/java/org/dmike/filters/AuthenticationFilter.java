package org.dmike.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dmike on 29/05/16.
 * @author dmike
 */
public class AuthenticationFilter  implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if(session != null && session.getAttribute("username") == null){
            //((HttpServletResponse)servletResponse).sendRedirect("WEB-INF/jsp/login.jsp");
            ((HttpServletRequest)servletRequest).getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                    .forward(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
