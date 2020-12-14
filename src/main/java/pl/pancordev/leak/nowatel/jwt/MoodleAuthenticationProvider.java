package pl.pancordev.leak.nowatel.jwt;

import com.nowatel.moodle.exception.MoodleError;
import com.nowatel.moodle.exception.MoodleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author Mateusz Becker
 */
@Component
@ConditionalOnProperty(name = "service.moodle.enabled", havingValue = "true", matchIfMissing = false)
public class MoodleAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoodleAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        try {
            UserPrincipal user = new UserPrincipal(UUID.nameUUIDFromBytes("tak".getBytes()), "username", "moodleToken", List.of(new SimpleGrantedAuthority("LEAK")));
            return new UsernamePasswordAuthenticationToken(user, password, List.of());
        } catch (MoodleException ex) {
            if (ex.getError().equals(MoodleError.INVALID_LOGIN)) {
                throw new BadCredentialsException("Moodle authentication failed for: " + login);
            }
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            LOGGER.warn("Unexpected error during moodle authentication.", ex);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
