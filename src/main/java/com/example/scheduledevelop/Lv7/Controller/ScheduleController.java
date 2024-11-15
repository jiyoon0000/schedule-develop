package com.example.scheduledevelop.Lv7.Controller;

import com.example.scheduledevelop.Lv7.Entity.Schedule;
import com.example.scheduledevelop.Lv7.Service.ScheduleService;
import com.example.scheduledevelop.Lv7.dto.ScheduleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Profile("Lv7")
@RestController
//API 기본 경로 설정
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성 API
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@Validated @RequestBody ScheduleRequestDto requestDto){

        //title, contents를 사용해 일정 생성
        Schedule schedule =
                scheduleService.createSchedule(
                        requestDto.getTitle(),
                        requestDto.getContents());
        //생성된 일정과 함께 Created(201) 상태 반환
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    //특정 일정 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id){
        //id로 특정 일정 조회
        Schedule schedule = scheduleService.getSchedule(id);

        //조회된 일정과 함께 OK(200) 반환
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    //일정 수정 API
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto){
       //특정 일정을 id로 조회한 후에 title, contents가 수정되면 업데이트
        Schedule schedule = scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        //수정된 일정과 함께 ok 상태 반환
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    //일정 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
