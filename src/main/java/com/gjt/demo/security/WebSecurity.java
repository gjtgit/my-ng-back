package com.gjt.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用springsecurity5，需要加上{noop}指定使用NoOpPasswordEncoder给DelegatingPasswordEncoder去校验密码
        auth.inMemoryAuthentication().withUser("gjt").password("{noop}123").roles("USER")
        .and().withUser("gjt2").password("{noop}123").roles("USER");
    }
       
}
