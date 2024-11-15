package com.example.scheduledevelop.Lv5.Repository;

import lombok.Getter;

@Getter

//회원가입 시 필요한 유저의 정보들 전달받기 위한 dto
public class MemberRequestDto {
    private String username;
    private String email;
    private String password;

    public MemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
