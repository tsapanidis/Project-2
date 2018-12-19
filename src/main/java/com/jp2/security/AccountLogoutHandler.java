package com.jp2.security;

import com.jp2.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccountLogoutHandler extends SimpleUrlLogoutSuccessHandler {
    private static final Logger LOG = LoggerFactory.getLogger(AccountLogoutHandler.class);

    @Autowired
    private OwnerService authenticationService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        try {
            authenticationService.logout((String) authentication.getCredentials(), (String) authentication.getPrincipal());

            super.onLogoutSuccess(httpServletRequest, httpServletResponse, authentication);
        } catch (Exception ex) {
            LOG.error("Exception thrown while logging out: " + ex.getMessage(), ex);
            httpServletResponse.sendRedirect("/");
        }
    }
}