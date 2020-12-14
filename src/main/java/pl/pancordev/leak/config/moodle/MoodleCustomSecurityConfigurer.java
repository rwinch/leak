package pl.pancordev.leak.config.moodle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import pl.pancordev.leak.config.CustomSecurityConfigurer;
import pl.pancordev.leak.nowatel.jwt.JwtAuthenticationFilter;
import pl.pancordev.leak.nowatel.jwt.MoodleAuthenticationProvider;

/**
 * @author Mateusz Becker
 */
@Component("customSecurityConfigurer")
@Conditional(MoodleCustomSecurityConfigurer.MoodleSecurityEnabled.class)
public class MoodleCustomSecurityConfigurer implements CustomSecurityConfigurer {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private MoodleAuthenticationProvider moodleAuthenticationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(moodleAuthenticationProvider);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    static class MoodleSecurityEnabled extends AllNestedConditions {

        public MoodleSecurityEnabled() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }

        @ConditionalOnProperty(name = "service.moodle.enabled", havingValue = "true", matchIfMissing = false)
        static class MoodleSecurityEnable {
        }

        @ConditionalOnProperty(name = "service.oauth2.enabled", havingValue = "false", matchIfMissing = true)
        static class KeycloakSecurityDisabled {
        }
    }

}
