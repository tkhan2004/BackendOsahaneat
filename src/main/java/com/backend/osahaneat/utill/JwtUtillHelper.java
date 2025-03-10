package com.backend.osahaneat.utill;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.security.Key;
@Component
public class JwtUtillHelper {

    @Value("${Jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().setSubject("data").signWith(key).compact();
        return jws;

    }

    public Boolean validateToken(String jwtToken){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parserBuilder()
                    .setSigningKey(key)  // Thiết lập key để xác minh token
                    .build()
                    .parseClaimsJws(jwtToken);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
