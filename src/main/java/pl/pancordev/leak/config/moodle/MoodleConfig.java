package pl.pancordev.leak.config.moodle;

import com.nowatel.moodle.config.MoodleAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Mateusz Becker
 */
@Configuration
@ConditionalOnProperty(name = "service.moodle.enabled", havingValue = "true", matchIfMissing = false)
@Import(MoodleAutoConfiguration.class)
public class MoodleConfig {
    public static final String CIRCUIT_BREAKER_MOODLE = "moodle";
}
