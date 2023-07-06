package Reservation.Backend.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import Reservation.Backend.model.ReservationApiexcep;
import Reservation.Backend.model.responsemodel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTTokenProvider {
    //hold some utility methods
    @Value("${app.jwt-secret}")
    private String jwtsecretkey;

    @Value("${app.jwt-expiration-milliseconds}")
    private Long expirationTime;

    public String generateToken(Authentication auth)
    {
        String username = auth.getName();
        Date expireDate = new Date(new Date().getTime()+expirationTime);
        return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(expireDate)
        .signWith(key())
        .compact()
        ;
    }

    public String getUserName(String token){
        //claims contains tokens and sihgning keys etc
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token)
    {
        try{
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        }
        catch(MalformedJwtException e)
        {
            throw new ReservationApiexcep(HttpStatus.BAD_REQUEST, "Invalid token");
        }
        catch(ExpiredJwtException e)
        {
            throw new ReservationApiexcep(HttpStatus.BAD_REQUEST, "token Expired");
        }
        catch(UnsupportedJwtException e)
        {
            throw new ReservationApiexcep(HttpStatus.BAD_REQUEST, "Unsupported Token");
        }
        catch(IllegalArgumentException e)
        {
            throw new ReservationApiexcep(HttpStatus.BAD_REQUEST, "Invalid Argument");
        }
    }

    //for keygeneration
    private SecretKey key()
    {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtsecretkey));
    }
}
