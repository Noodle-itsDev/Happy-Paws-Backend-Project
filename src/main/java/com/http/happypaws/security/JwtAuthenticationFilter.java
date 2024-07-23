package com.http.happypaws.security;

import java.io.IOException;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private CustomUsersDetailsService customUserDetailsService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	private String obtainTokenRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		} 
		return null;
	}
	
	@Override 
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String token = obtainTokenRequest(request);
		
		if(StringUtils.hasText(token) && jwtGenerator.validateToken(token)) {
			String username = jwtGenerator.obtainUsernameJwt(token);
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			List<String> userRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
			
			if (userRoles.contains("Voluntario")||userRoles.contains("Gestor")) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	

}
