package com.workerpartner.globalConfig.securityConfig;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JWTFilter extends OncePerRequestFilter {

	private final JWTService jwtservice;
	
	JWTFilter(JWTService jwtservice)
	{
	 this.jwtservice=jwtservice;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

       String header = request.getHeader("Authorization");
       if(StringUtils.hasText(header) && header.startsWith("Bearer"))
       {
    	   Claims claims = jwtservice.parseClaims(header.substring(7));
    	   
    	   var auth = new UsernamePasswordAuthenticationToken(Long.valueOf(claims.getSubject()),
    			   null, List.of(new SimpleGrantedAuthority("ROLE_" + claims.get("role"))));  
    	   
    	   SecurityContextHolder.getContext().setAuthentication(auth);
    	    
       }
       filterChain.doFilter(request, response);
       
       
		
	}

	
}
