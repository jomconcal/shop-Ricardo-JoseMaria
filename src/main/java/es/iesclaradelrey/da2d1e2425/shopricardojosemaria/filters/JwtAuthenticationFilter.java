package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.filters;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserDetailsService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.JwtService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.JwtServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AppUserDetailsService appUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String pathRequest = request.getRequestURI();
        if(pathRequest.contains("/app/v1/products/find")){
            String authHeader= request.getHeader("Authorization");
            if(authHeader==null || !authHeader.startsWith("Bearer ")){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            String token = authHeader.substring(7);

            try{
                jwtService.validateAccessToken(token);
                String userName= jwtService.extractUserName(token);
                UserDetails userDetails= appUserDetailsService.loadUserByUsername(userName);
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }catch (Exception e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
