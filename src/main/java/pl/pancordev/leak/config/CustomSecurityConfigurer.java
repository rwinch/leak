package pl.pancordev.leak.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author Mateusz Becker
 */
public interface CustomSecurityConfigurer {

    void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception;

    void configure(HttpSecurity http) throws Exception;

}
