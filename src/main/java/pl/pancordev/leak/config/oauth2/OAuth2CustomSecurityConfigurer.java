package pl.pancordev.leak.config.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;
import pl.pancordev.leak.config.CustomSecurityConfigurer;
import pl.pancordev.leak.nowatel.jwt.JwtUtils;
import pl.pancordev.leak.nowatel.jwt.UserPrincipal;

/**
 * @author Mateusz Becker
 */
@Component("customSecurityConfigurer")
@ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "true", matchIfMissing = false)
public class OAuth2CustomSecurityConfigurer implements CustomSecurityConfigurer {

    @Value("${security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwt -> {
                    UserPrincipal up = JwtUtils.extractUserPrincipal(jwt);
                    return new UsernamePasswordAuthenticationToken(up, null, up.getAuthorities());
                });
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}
