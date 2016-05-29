package org.dmike.listeners;

import org.dmike.filters.AuthenticationFilter;
import org.dmike.filters.RequestLogFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by dmike on 29/05/16.
 * @author dmike
 */
public class Configurator implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();

        FilterRegistration.Dynamic registration ;

        registration = context.addFilter("requestLogFilter"
        ,new RequestLogFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null,false,"*.action");

        registration = context.addFilter("authenticationFilter"
        ,new AuthenticationFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null,false,"/tickets.action");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
