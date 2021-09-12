package com.todo.restapp.security.config;

import com.todo.restapp.security.model.User;
import com.todo.restapp.security.repo.UserRepository;
import com.todo.restapp.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository repo;

    @Bean
    AuthenticationProvider authProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        UserDetailsService service = name -> {
            User user = repo.findByName(name);
            if (user == null) throw new UsernameNotFoundException("UnAuthorized");
            return new CustomUserDetailsService(user);
        };

        dao.setUserDetailsService(service);
        dao.setPasswordEncoder(new BCryptPasswordEncoder());
        return dao;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator/health")
                .permitAll()
                .antMatchers("/h2-console/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/api/**")
                .hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/api/**")
                .hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE,"/api/**")
                .hasAuthority("USER")
                .antMatchers(HttpMethod.PUT,"/api/**")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic();

        http.headers().frameOptions().sameOrigin();
    }
}
