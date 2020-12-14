package pl.pancordev.leak.config.oauth2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pancordev.leak.nowatel.jwt.JwtAuthenticationFilter;

/**
 * @author Mateusz Becker
 */
@Configuration
@ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "true", matchIfMissing = false)
public class OAuth2DisableJwtFilterConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> registration(JwtAuthenticationFilter filter) {
        FilterRegistrationBean<JwtAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
