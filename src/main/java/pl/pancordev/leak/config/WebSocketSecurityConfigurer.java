package pl.pancordev.leak.config;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * @author Mateusz Becker
 */
public interface WebSocketSecurityConfigurer {
    Optional<UserDetails> extractUserDetails(String token);
}
