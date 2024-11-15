package com.example.scheduledevelop.Lv7.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    //댓글 내용은 필수로 입력해야함
    @NotBlank(message = "댓글 내용은 필수 입력값입니다.")
    private String content;

    public CommentRequestDto(String content) {
        this.content = content;
    }
}
