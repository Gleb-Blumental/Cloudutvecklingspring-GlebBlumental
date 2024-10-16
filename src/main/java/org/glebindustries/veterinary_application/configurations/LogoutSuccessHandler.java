package org.glebindustries.veterinary_application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Bean
public LogoutSuccessHandler cognitoLogoutSuccessHandler() {
    return (request, response, authentication) -> {
        String logoutUrl = "http://localhost:8080/logout?" +
                "client_id=3eqae7trsl4gd1cue823aai5l3&logout_uri=http://localhost:8080/";
        response.sendRedirect(logoutUrl);
    };
}