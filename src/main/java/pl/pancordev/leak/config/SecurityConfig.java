package pl.pancordev.leak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import pl.pancordev.leak.nowatel.jwt.JwtAuthenticationEntryPoint;

/**
 * @author Mateusz Becker
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private JwtAuthenticationEntryPoint unauthorizedHandler;
//    @Autowired
//    private CustomSecurityConfigurer customSecurityConfigurer;

//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        customSecurityConfigurer.configure(authenticationManagerBuilder);
//    }

//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and().csrf().disable()
////                .headers().frameOptions().disable()//only for h2-console
////                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests().antMatchers("/",
//                "/favicon.ico",
//                "/**/*.png",
//                "/**/*.gif",
//                "/**/*.svg",
//                "/**/*.jpg",
//                "/**/*.html",
//                "/**/*.css",
//                "/**/*.js").permitAll()
//                .antMatchers("/api/v1/auth/**").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/api/v1/user/check-username-availability", "/api/v1/user/check-email-availability").permitAll()
//                .antMatchers("/api/management/**").permitAll()
//                .antMatchers("/api/v1/supervisor/**").permitAll()
//                .antMatchers("/simulator/**").permitAll()
//                .anyRequest().authenticated();
//        customSecurityConfigurer.configure(http);
//    }
}
