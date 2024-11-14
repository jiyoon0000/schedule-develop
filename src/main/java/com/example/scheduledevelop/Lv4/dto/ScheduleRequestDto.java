package com.example.scheduledevelop.Lv4.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String title;

    private String contents;

    public ScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
