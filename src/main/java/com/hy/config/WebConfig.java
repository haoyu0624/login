package com.hy.config;

import com.hy.security.MyAuthenctiationFailureHandler;
import com.hy.security.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/signIn.html")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/signIn.html").permitAll()
                .antMatchers("/user").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
