package com.ese.webservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.info(request.getParameter("memail") + " / " + request.getParameter("mpwd"));
        request.setAttribute("loginfail", request.getParameter("memail"));
        request.getRequestDispatcher("/login").forward(request, response);
    }
}
