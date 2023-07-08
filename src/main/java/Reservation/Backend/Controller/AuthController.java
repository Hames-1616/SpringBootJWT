package Reservation.Backend.Controller;

import Reservation.Backend.model.authmodel;
import Reservation.Backend.model.user;
import Reservation.Backend.security.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    public ResponseEntity<authmodel> login(@RequestBody user users){}
}
