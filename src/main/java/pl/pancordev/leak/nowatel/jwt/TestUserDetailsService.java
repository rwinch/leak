package pl.pancordev.leak.nowatel.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Pawel Panek
 */
@Service
public class TestUserDetailsService implements UserDetailsService {

    PasswordEncoder passwordEncoder;

    Map<UUID, UserPrincipal> users;

    @Autowired
    public TestUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        users = Map.ofEntries(
                Map.entry(UUID.nameUUIDFromBytes("1".getBytes()), new UserPrincipal(UUID.nameUUIDFromBytes("1".getBytes()), "name1", "userName1", "token", "mail1", passwordEncoder.encode("pass1"), List.of(new SimpleGrantedAuthority("ROLE_STUDENT"), new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_SUPPORT")))),
                Map.entry(UUID.nameUUIDFromBytes("2".getBytes()), new UserPrincipal(UUID.nameUUIDFromBytes("2".getBytes()), "name1", "userName2", "token", "mail1", passwordEncoder.encode("pass1"), List.of(new SimpleGrantedAuthority("ROLE_STUDENT"), new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_SUPPORT")))),
                Map.entry(UUID.nameUUIDFromBytes("3".getBytes()), new UserPrincipal(UUID.nameUUIDFromBytes("3".getBytes()), "name1", "userName3", "token", "mail1", passwordEncoder.encode("pass1"), List.of(new SimpleGrantedAuthority("ROLE_STUDENT")))),
                Map.entry(UUID.nameUUIDFromBytes("4".getBytes()), new UserPrincipal(UUID.nameUUIDFromBytes("4".getBytes()), "name1", "teacher1", "token", "mail1", passwordEncoder.encode("pass1"), List.of(new SimpleGrantedAuthority("ROLE_STUDENT"), new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_TEACHER"))))
        );
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return users.values().stream().filter(u -> u.getUsername().equals(usernameOrEmail)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));
    }
}
