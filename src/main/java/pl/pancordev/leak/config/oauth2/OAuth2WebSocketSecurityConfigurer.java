package pl.pancordev.leak.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.pancordev.leak.config.WebSocketSecurityConfigurer;
import pl.pancordev.leak.nowatel.jwt.JwtUtils;
import pl.pancordev.leak.nowatel.jwt.UserPrincipal;

import java.util.Optional;

/**
 * @author Mateusz Becker
 */
@Component("webSocketSecurityConfigurer")
@ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "true", matchIfMissing = false)
public class OAuth2WebSocketSecurityConfigurer implements WebSocketSecurityConfigurer {

    private JwtDecoder jwtDecoder;

    @Autowired
    public OAuth2WebSocketSecurityConfigurer(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public Optional<UserDetails> extractUserDetails(String token) {
        if (StringUtils.hasText(token)) {
            try {
                Jwt jwt = jwtDecoder.decode(token);
                UserPrincipal userPrincipal = JwtUtils.extractUserPrincipal(jwt);
                return Optional.of(userPrincipal);
            } catch (Exception e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
