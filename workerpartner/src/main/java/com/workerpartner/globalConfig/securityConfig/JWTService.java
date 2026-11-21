package com.workerpartner.globalConfig.securityConfig;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

	@Value("${jwt.secret}")
	private String secretKey;

	public SecretKey key() {
		SecretKey secretkey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

		return secretkey;
	}
  
	public String generateToken(Long customerId, String role)
	{
		return Jwts.builder()
				.subject(String.valueOf(customerId))
				.claim("role", role)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000))
				.signWith(key())
				.compact();
	}
	
	public Claims parseClaims(String token)
	{
		Claims claimsObj = Jwts.parser().verifyWith(key()).build().parseSignedClaims(token).getPayload();
		
		return claimsObj;
	}
}
