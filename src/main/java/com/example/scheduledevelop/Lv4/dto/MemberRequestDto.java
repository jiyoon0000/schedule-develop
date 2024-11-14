package com.example.scheduledevelop.Lv4.dto;

import lombok.Getter;

@Getter

public class MemberRequestDto {

    //유저 생성 요청시 필요한 필드
    private String username;
    private String email;
    private String password;

    //service, controller 에서 member의 entity로 변환되어 사용
    public MemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
