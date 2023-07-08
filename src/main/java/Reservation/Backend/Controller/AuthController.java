package Reservation.Backend.Controller;

import Reservation.Backend.model.authmodel;
import Reservation.Backend.model.user;
import Reservation.Backend.security.JWTTokenProvider;

import java.sql.Date;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aut")
public class AuthController
{
    @Value("${app.jwt-expiration-milliseconds}")
    private Long expiration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider ;

    @PostMapping("/login")
    public ResponseEntity<authmodel> login(@RequestBody user users){
        final authmodel auth ;
        final Authentication authentication = 
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword()));
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            auth = new authmodel(
            HttpStatus.OK.value(),
            "Successfully logged in",
            token,
            System.currentTimeMillis(),
            expiration);

            return ResponseEntity.ok(auth);
    }
}
