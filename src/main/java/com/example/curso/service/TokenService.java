package com.example.curso.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.curso.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) throws JWTCreationException {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT
                .create()
                .withIssuer("Remedios_api")
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withExpiresAt(dataExpire())
                .sign(algorithm);
    }

    public String getSubject(String tokenJWT) throws JWTCreationException {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT
                .require(algorithm)
                .withIssuer("Remedios_api")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }

    private Instant dataExpire() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
