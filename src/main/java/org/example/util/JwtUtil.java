package org.example.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtil {

    public static String generateJwt(String subject, String customerId, Long expireTime, String secret) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTimeMillis = currentTimeMillis + expireTime;

        return Jwts.builder()
                .subject(subject)
                .claim("customerId", customerId)
                .issuedAt(new Date())
                .expiration(new Date(expirationTimeMillis))
                .signWith(getSignInKey(secret))
                .compact();
    }


    public static Claims getClaims(String token, String key) {

        Claims claims = null;

        try {
            claims = Jwts.parser()
                    .verifyWith(getSignInKey(key))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException ex) {
//            throw new TokenException(TOKEN_ERROR, TOKEN_EXPIRED_MESSAGE);
        } catch (Exception ex) {
//            throw new TokenException(TOKEN_ERROR, TOKEN_INVALID_MESSAGE);
        }

        return claims;
    }

    private static SecretKey getSignInKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
