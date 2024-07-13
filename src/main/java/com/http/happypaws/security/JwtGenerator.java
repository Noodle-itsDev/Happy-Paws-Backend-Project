package com.http.happypaws.security;

import java.util.Date;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentTime = new Date();
		Date expirationToken = new Date(currentTime.getTime() + SecurityConstant.JWT_EXPIRATION_TOKEN);
		
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(expirationToken)
				.signWith(SignatureAlgorithm.HS512, SecurityConstant.JWT_FIRMA)
				.compact();
		return token;
	}
	
	public String obtainUsernameJwt(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SecurityConstant.JWT_FIRMA)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public Boolean validateToken(String token) {
		
		try  {
			Jwts.parser().setSigningKey(SecurityConstant.JWT_FIRMA).parseClaimsJws(token);
			return true;
		} catch(Exception E) {
			throw new AuthenticationCredentialsNotFoundException("Jwt is expired or incorrect");
		}
	}

	
	
	
	
}
