package com.example.scheduledevelop.Lv7.Repository;

import com.example.scheduledevelop.Lv7.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByScheduleId(Long scheduleId);
}
