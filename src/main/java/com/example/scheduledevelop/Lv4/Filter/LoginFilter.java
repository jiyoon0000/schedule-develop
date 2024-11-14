package com.example.scheduledevelop.Lv4.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {

    //doFilter 메서드는 요청마다 호출되며 세션 검사를 실행
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    )
        throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //요청된 URL 경로를 가져옴
        String requestURI = httpRequest.getRequestURI();
        //특정 경로는 세션 검사 없이 통과
        if(requestURI.equals("/members/signup") || requestURI.equals("/members/login")){
            //다음 필터 또는 서블릿으로 요청을 전달해준다.
            chain.doFilter(request,response);
            //세션 검사 종료
            return;
        }

        //모든 쿠키를 가져옴
        Cookie[] cookies = httpRequest.getCookies();
        boolean hasSessionId = false;

        //SESSIONID 라는 이름의 쿠키가 있는지 검사한 후 있으면 반복하지 않고 종료
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("SESSIONID".equals(cookie.getName())){
                    hasSessionId = true;
                    break;
                }
            }
        }

        //SESSIONID 쿠키가 없으면 인증되지 않은 요청으로 인식하고 401을 반환
        if(!hasSessionId){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //요청을 종료하고 이후 실행하지 않음
            return;
        }

        //세션이 존재하면 요청을 다음 필터로 전달
        chain.doFilter(request,response);
    }
}
