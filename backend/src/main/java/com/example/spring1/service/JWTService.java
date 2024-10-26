package com.example.spring1.service;

import com.example.spring1.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.el.parser.Token;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

public class JWTService {
    private final String SECRET_KEY = "c0386888085265bec15cfad11376a3b2312c8076b7c49b171609043b3c53063f";

    private SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String generateToken(User user){
        return Jwts.
                builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (1*24*60*60*1000)))
                .signWith(getSignInKey())
                .compact();
    }

    public Claims getAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim(String token, Function<Claims,T> resolver){
        return resolver.apply(getAllClaims(token));
    }

    public String extractUsername(String token){
        return getClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserDetails userDetails){
        return getClaim(token, Claims::getSubject).equals(userDetails.getUsername()) && getClaim(token, Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }

    public boolean isTokenExpired(String token){
        return getClaim(token, Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }

}
