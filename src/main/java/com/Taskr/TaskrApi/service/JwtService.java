package com.Taskr.TaskrApi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    @Value("${app.jwt.secret}")
    private String secretKey;
    @Value("(${app.jwt.expiration})")
    private long expiration;

    public String generaToken(UserDetails user){
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    private String extractEmail(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean isValid(String token, UserDetails userDetails){
        try {
            final String email = extractEmail(token);
            return email.equals(userDetails.getUsername()) && isExpired(token);
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isExpired(String token){
        return Jwts.parser().
                verifyWith(getSigningKey()).
                build().
                parseSignedClaims(token).
                getPayload().
                getExpiration().
                before(new Date());
    }

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
