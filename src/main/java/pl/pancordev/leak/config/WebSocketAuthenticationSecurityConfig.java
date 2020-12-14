package pl.pancordev.leak.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import pl.pancordev.leak.nowatel.jwt.UserPrincipal;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Becker
 */
//@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class WebSocketAuthenticationSecurityConfig implements WebSocketMessageBrokerConfigurer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketAuthenticationSecurityConfig.class);
//
//
//    private WebSocketSecurityConfigurer webSocketSecurityConfigurer;
//
//    @Autowired
//    public WebSocketAuthenticationSecurityConfig(WebSocketSecurityConfigurer webSocketSecurityConfigurer) {
//        this.webSocketSecurityConfigurer = webSocketSecurityConfigurer;
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//
//        registration.interceptors(new ChannelInterceptor() {
//
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//
//                    Optional.ofNullable(accessor.getNativeHeader("Authorization")).ifPresentOrElse(ah -> {
//                        String bearerToken = ah.get(0).replace("Bearer ", "");
//                        webSocketSecurityConfigurer.extractUserDetails(bearerToken)
//                                .ifPresentOrElse(userDetails -> {
//                                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                                    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//                                    if (validateAuthentication(accessor, userPrincipal)) {
//                                        accessor.setUser(authentication);
//                                    }
//                                }, () -> {
//                                    sendConnectErrorMessage("Invalid token", accessor.getSessionId());
//                                });
//                    }, () -> sendConnectErrorMessage("Authorization header with Bearer token required.", accessor.getSessionId()));
//                }
//                return message;
//            }
//        });
//    }
//
//    private boolean validateAuthentication(StompHeaderAccessor accessor, UserPrincipal userPrincipal) {
//        return true;
//    }
//
//    private boolean verifyHeader(List<String> headers, String header, String sessionId) {
//        if (headers == null) {
//            LOGGER.warn("Can't find {} header.", header);
//            sendConnectErrorMessage("Missing Nowatel Header '" + header + "' in CONNECT message.", sessionId);
//            return true;
//        }
//        if (headers.isEmpty() || headers.get(0).isEmpty()) {
//            LOGGER.warn("{} header found but is empty.", header);
//            sendConnectErrorMessage("Missing Nowatel Header '" + header + "' in CONNECT message.", sessionId);
//            return true;
//        }
//        return false;
//    }
//
//    private void sendConnectErrorMessage(String message, String sessionId) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.create(StompCommand.ERROR);
//        headerAccessor.setMessage(message);
//        headerAccessor.setSessionId(sessionId);
//
//    }
}
