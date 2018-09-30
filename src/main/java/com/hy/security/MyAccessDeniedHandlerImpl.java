package com.hy.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoy
 */
@Component("myAccessDeniedHandlerImpl")
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        httpServletResponse.sendRedirect("/403.html");
    }
}
