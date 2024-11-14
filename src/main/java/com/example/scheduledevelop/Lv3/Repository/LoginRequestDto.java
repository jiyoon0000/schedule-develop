package com.example.scheduledevelop.Lv3.Repository;

import lombok.Getter;

@Getter

public class LoginRequestDto {

    //로그인 요청에서 필요한 정보를 전달받기 위한 dto
    //email과 password를 로그인 요청을 할 때 사용
    private String email;
    private String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
