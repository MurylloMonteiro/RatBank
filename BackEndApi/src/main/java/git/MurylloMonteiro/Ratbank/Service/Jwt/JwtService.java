package git.MurylloMonteiro.Ratbank.Service.Jwt;

import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final SecretKey KEY = Keys.hmacShaKeyFor("chave-super-simples-32-bytes-minimo!".getBytes());

    public String generateToken(UUID username) {
        return Jwts.builder()
                .issuer("Ratbank")
                .subject(username.toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 240_000_000))
                .signWith(KEY)
                .compact();
    }

    public String validateToken(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
