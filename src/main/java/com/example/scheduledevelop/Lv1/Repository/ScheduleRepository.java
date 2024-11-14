package com.example.scheduledevelop.Lv1.Repository;

import com.example.scheduledevelop.Lv1.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA Repository, 기본적인 CRUD 메서드 제공
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
