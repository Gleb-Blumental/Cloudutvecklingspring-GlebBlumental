package org.glebindustries.veterinary_application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CognitoWebConfiguration implements WebMvcConfigurer {
    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.cognitoClientRegistration());
    }

    private ClientRegistration cognitoClientRegistration() {
        return ClientRegistration.withRegistrationId("cognito")
                .clientId("your-cognito-client-id")
                .clientSecret("your-cognito-client-secret")
                .scope("openid", "profile", "email")
                .authorizationUri("https://your-cognito-domain/oauth2/authorize")
                .tokenUri("https://your-cognito-domain/oauth2/token")
                .userInfoUri("https://your-cognito-domain/oauth2/userInfo")
                .clientName("Cognito")
                .build();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
