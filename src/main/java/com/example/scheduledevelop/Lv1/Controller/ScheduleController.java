package com.example.scheduledevelop.Lv1.Controller;

import com.example.scheduledevelop.Lv1.Entity.Schedule;
import com.example.scheduledevelop.Lv1.Service.ScheduleService;
import com.example.scheduledevelop.Lv1.dto.ScheduleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Profile("Lv1")
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleRequestDto requestDto){

        Schedule schedule =
                scheduleService.createSchedule(
                        requestDto.getTitle(),
                        requestDto.getContents());
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id){
        Schedule schedule = scheduleService.getSchedule(id);

        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto){
        Schedule schedule = scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
