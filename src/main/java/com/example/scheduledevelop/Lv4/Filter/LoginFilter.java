package com.example.scheduledevelop.Lv4.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    )
        throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        if(requestURI.equals("/members/signup") || requestURI.equals("/members/login")){
            chain.doFilter(request,response);
            return;
        }

        Cookie[] cookies = httpRequest.getCookies();
        boolean hasSessionId = false;

        if(cookies != null){
            for(Cookie cookie : cookies){
                if("SESSIONID".equals(cookie.getName())){
                    hasSessionId = true;
                    break;
                }
            }
        }

        if(!hasSessionId){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        chain.doFilter(request,response);
    }
}
