package com.example.scheduledevelop.Lv7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter

public class MemberRequestDto {

    //유저 생성 요청시 필요한 필드
    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(max = 4, message = "이름은 최대 4글자입니다.")
    private String username;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이내입니다.")
    private String password;

    //service, controller 에서 member의 entity로 변환되어 사용
    public MemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
