package com.example.scheduledevelop.Lv5.Service;

import com.example.scheduledevelop.Lv5.Entity.Schedule;
import com.example.scheduledevelop.Lv5.Repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//Lv3 프로파일에서만 활성화
@Profile("Lv5")
@Service
//final 필드의 생성자를 자동으로 생성해주는 Lombok 어노테이션
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository lv2ScheduleRepository;

    //새로운 일정 생성
    public Schedule createSchedule(String title, String contents){

        //title, contents 를 사용하여 새로운 schedule 생성
        Schedule schedule = new Schedule(title, contents);

        //생성한 schedule을 database에 저장
        return lv2ScheduleRepository.save(schedule);
    }

    //특정 일정 조회
    //id를 가지고 schedule을 조회, 없으면 404 error
    public Schedule getSchedule(Long id){
        return lv2ScheduleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Not found schedule"));
    }

    //일정 수정
    //id로 schedule 조회 후 title, contents가 수정되고 나면 변경된 schedule을 다시 저장
    public Schedule updateSchedule(Long id, String title, String contents){
        Schedule schedule = getSchedule(id);
        schedule.updateSchedule(title, contents);
        return lv2ScheduleRepository.save(schedule);
    }

    //일정 삭제
    //id로 schedule 조회 후 조회한 schedule 삭제
    public void deleteSchedule(Long id){
        Schedule schedule = getSchedule(id);
        lv2ScheduleRepository.delete(schedule);
    }
}
