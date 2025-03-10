package com.backend.osahaneat.Security;

import com.backend.osahaneat.utill.JwtUtillHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;

@Component
public class CustomJwtFillter extends OncePerRequestFilter {


    @Autowired
    JwtUtillHelper jwtUtillHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = getTokenFromHeader(request);
        System.out.printf("jwtToken: %s",jwtToken);

        if(jwtToken != null ) {
            if(jwtUtillHelper.validateToken(jwtToken)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(jwtToken, null, new ArrayList<>());

                // Gán authentication vào context
                SecurityContextHolder.getContext().setAuthentication(authentication); // ✅ Đúng cú pháp
            }

        }
        filterChain.doFilter(request, response);


    }

    private String getTokenFromHeader(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        String token = null;
        if(authorization != null && authorization.startsWith("Bearer ")){
            token = authorization.substring(7);
        }
        return token;
    }

}
