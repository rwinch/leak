package pl.pancordev.leak.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

/**
 * @author Mateusz Becker
 */
@Configuration
public class CommonBeansConfig {

    @Bean
    public Clock getClockUTC() {
        return Clock.systemUTC();
    }

    @Bean
    public ModelMapper mapperToDto() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setDestinationNameTransformer(NameTransformers.builder())
                .setDestinationNamingConvention(NamingConventions.builder());
        return mapper;
    }

    @Bean
    public ModelMapper mapperToEntity() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
