//package com.greenfox.basicauththeader.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@Configuration
//public class SecurityConf extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//                .inMemoryAuthentication()
//                .withUser("Agnes")
//                .password("pass")
//                .roles("USER")
//                .and()
//                .withUser("Agnesadmin")
//                .password("asd")
//                .roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSec) throws Exception {
//
//        httpSec
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/").permitAll()
//                .antMatchers("/delete").hasRole("ADMIN");
//
//    }
//}
