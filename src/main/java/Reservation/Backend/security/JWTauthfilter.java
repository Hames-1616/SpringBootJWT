package Reservation.Backend.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Reservation.Backend.services.userDetail;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTauthfilter extends OncePerRequestFilter {


    @Autowired
    private JWTTokenProvider jwttokenprovider;

    @Autowired
    private userDetail Customuserdetail;
    //filters are defined
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
    }
    
}
