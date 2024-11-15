package com.example.scheduledevelop.Lv7.Repository;

import com.example.scheduledevelop.Lv7.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//댓글 데이터베이스에 접근할 수 있는 저장소
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //특정 일정에 관련된 댓글 목록을 조회
    List<Comment> findByScheduleId(Long scheduleId);
}
