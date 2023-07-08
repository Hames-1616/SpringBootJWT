package Reservation.Backend.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JWTentrypoint j;

    @Autowired
    private JWTauthfilter ja;

    @Bean
    SecurityFilterChain dSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET)
        .permitAll()
        .requestMatchers("/api/auth/**")
        .permitAll()
        .requestMatchers(HttpMethod.POST,"/api/addbus","route/addRoute")
        .authenticated()
        .and()
        .exceptionHandling(exception -> exception.authenticationEntryPoint(j))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.addFilterBefore(ja, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {
        //automatic configuration handled by spring
        return configuration.getAuthenticationManager();
    }
}
