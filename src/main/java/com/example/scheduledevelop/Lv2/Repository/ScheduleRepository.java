package com.example.scheduledevelop.Lv2.Repository;

import com.example.scheduledevelop.Lv2.Entity.Schedule;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("Lv2")
//JPA Repository, 기본적인 CRUD 메서드 제공
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
