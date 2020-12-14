package pl.pancordev.leak.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import java.util.List;

/**
 * @author Mateusz Becker
 */
//@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/simulator")
//                .setAllowedOrigins("*")
//                .withSockJS()
//                .setStreamBytesLimit(512 * 1024)
//                .setHttpMessageCacheSize(1000)
//                .setDisconnectDelay(30 * 1000);
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/topic", "/queue");
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//        DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
//        resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        converter.setObjectMapper(objectMapper);
//        converter.setContentTypeResolver(resolver);
//        messageConverters.add(converter);
//        return false;
//    }
//
//    @Override
//    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
//                .nullDestMatcher().authenticated()
//                .simpSubscribeDestMatchers("/user/queue/errors").permitAll()
//                .simpDestMatchers("/app/**").hasAnyRole("STUDENT", "TEACHER")
//                .simpSubscribeDestMatchers("/user/**", "/topic/**").hasAnyRole("STUDENT", "TEACHER")
//                .simpTypeMatchers(SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).denyAll()
//                .anyMessage().authenticated();
//    }
//
//    @Override
//    protected boolean sameOriginDisabled() {
//        return true;
//    }
//
//    @Bean
//    public ServletServerContainerFactoryBean createWebSocketContainer() {
//        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//        container.setMaxTextMessageBufferSize(32 * 1024);
//        container.setMaxBinaryMessageBufferSize(32 * 1024);
//        return container;
//    }

}
