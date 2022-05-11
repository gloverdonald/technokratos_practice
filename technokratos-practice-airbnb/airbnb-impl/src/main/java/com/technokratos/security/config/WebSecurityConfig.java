package com.technokratos.security.config;

import com.technokratos.security.filter.TokenAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@PropertySource("classpath:application.properties")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PERMIT_ALL = {
            "/api/v1/auth/sign-in",
            "/api/v1/auth/sign-up",
            "/api/v1/auth/refresh",
            "/api/v1/email/confirm/**"
    };

    private final TokenAuthorizationFilter authorizationFilter;
    private final OAuthProperties oAuthProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers(PERMIT_ALL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authorizationFilter, BasicAuthenticationFilter.class)
                .oauth2Login();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        String clientId = oAuthProperties.getClientId();
        String clientSecret = oAuthProperties.getClientSecret();
        ClientRegistration registration = CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .scope()
                .build();
        return new InMemoryClientRegistrationRepository(registration);
    }
}

