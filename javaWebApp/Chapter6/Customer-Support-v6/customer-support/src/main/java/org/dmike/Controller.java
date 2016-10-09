package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 */
public interface Controller {
    String handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}