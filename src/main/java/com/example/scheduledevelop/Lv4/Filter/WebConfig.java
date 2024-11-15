package com.example.scheduledevelop.Lv4.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//Spring 설정 클래스 어노테이션
@Configuration
@Profile("Lv4")
public class WebConfig {

    //LoginFilter를 애플리케이션에 등록하는 메서드
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter(){
        FilterRegistrationBean<LoginFilter> filterRegistrationBean = new FilterRegistrationBean<>();

       //LoginFilter를 설정하여 모든 요청에서 세션 검사 수행
        filterRegistrationBean.setFilter(new LoginFilter());

        //필터의 순서를 설정
        filterRegistrationBean.setOrder(1);

        //모든 URL에 필터를 적용하도록 설정
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
