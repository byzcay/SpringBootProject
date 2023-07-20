package com.mantis;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

    @Component
    public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws ServletException, java.io.IOException {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = request.getHeader("Authorization");

        Integer id = null;
        if (token != null && token.startsWith("Bearer ")) {
            String tokenValue = token.substring(7);
            id = jwtTokenUtil.extractUserIdFromToken(tokenValue);
            System.out.println(id);
        }
        chain.doFilter(request, response);
    }
}
