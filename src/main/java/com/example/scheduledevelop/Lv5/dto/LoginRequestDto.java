package com.example.scheduledevelop.Lv5.dto;

//Jakarta Validation API에서 제공하는 유효성 검사 import
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    //사용자의 이메일을 저장하는 필드로 로그인 시 필수 입력값
    //null 값을 가질 수 없고 하나이상의 문자를 포함
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    //이메일 형식에 맞는지 검사
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    //비밀번호를 저장하는 필드로 필수 입력값
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
}

