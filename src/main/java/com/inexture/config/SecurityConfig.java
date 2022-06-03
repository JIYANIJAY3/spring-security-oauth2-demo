package com.inexture.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.net.URI;

@SuppressWarnings("ALL")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/", "/local"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/home")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true).
                logoutSuccessUrl("/local").
                deleteCookies("JSESSIONID").
                permitAll().
                and().
                csrf().
                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;
    }
}
