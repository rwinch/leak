package pl.pancordev.leak.nowatel.jwt;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.converter.ClaimConversionService;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mateusz Becker
 */
public class JwtUtils {

    public static UserPrincipal extractUserPrincipal(Jwt token) {
        List<SimpleGrantedAuthority> authorities = getNestedClaimAsList(token.getClaimAsMap("realm_access"), "roles")
                .stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())).collect(Collectors.toList());
        return new UserPrincipal(UUID.fromString(token.getSubject()), token.getClaimAsString("preferred_username"), token.getClaimAsString("moodle_token"), authorities);
    }

    @SuppressWarnings("unchecked")
    public static List<String> getNestedClaimAsList(Map<String, Object> claims, String claim) {
        if (!claims.containsKey(claim)) {
            return null;
        }
        final TypeDescriptor sourceDescriptor = TypeDescriptor.valueOf(Object.class);
        final TypeDescriptor targetDescriptor = TypeDescriptor.collection(
                List.class, TypeDescriptor.valueOf(String.class));
        Object claimValue = claims.get(claim);
        List<String> convertedValue = (List<String>) ClaimConversionService.getSharedInstance().convert(
                claimValue, sourceDescriptor, targetDescriptor);
        if (convertedValue == null) {
            throw new IllegalArgumentException("Unable to convert claim '" + claim +
                    "' of type '" + claimValue.getClass() + "' to List.");
        }
        return convertedValue;
    }
}
