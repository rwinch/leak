package pl.pancordev.leak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import pl.pancordev.leak.nowatel.jwt.JwtAuthenticationFilter;

/**
 * @author Mateusz Becker
 */
@Component("customSecurityConfigurer")
@Conditional(DefaultSecurityConfigurer.DefaultSecurityEnabled.class)
public class DefaultSecurityConfigurer implements CustomSecurityConfigurer {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private UserDetailsService customUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    static class DefaultSecurityEnabled extends AllNestedConditions {

        public DefaultSecurityEnabled() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }

        @ConditionalOnProperty(name = "service.moodle.enabled", havingValue = "false", matchIfMissing = true)
        static class MoodleSecurityDisabled {
        }

        @ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "false", matchIfMissing = true)
        static class KeycloakSecurityDisabled {
        }
    }
}
