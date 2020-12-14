package pl.pancordev.leak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.pancordev.leak.nowatel.jwt.JwtTokenProvider;

import java.util.Optional;

/**
 * @author Mateusz Becker
 */
@Component("webSocketSecurityConfigurer")
@ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "false", matchIfMissing = true)
public class DefaultWebSocketSecurityConfigurer implements WebSocketSecurityConfigurer {

    private JwtTokenProvider tokenProvider;

    @Autowired
    public DefaultWebSocketSecurityConfigurer(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Optional<UserDetails> extractUserDetails(String token) {
        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
            return Optional.of(tokenProvider.getUserFromJWT(token));
        }
        return Optional.empty();
    }
}
