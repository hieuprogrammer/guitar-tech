//package io.hieu.guitartech.security.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders11`q1`1   1.HttpSecurity;
//import org.springframework.23W3324security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*", "/img/*").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
//}