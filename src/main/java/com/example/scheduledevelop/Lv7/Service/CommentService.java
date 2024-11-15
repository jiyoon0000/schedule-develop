package com.example.scheduledevelop.Lv7.Service;

import com.example.scheduledevelop.Lv7.Entity.Comment;
import com.example.scheduledevelop.Lv7.Entity.Member;
import com.example.scheduledevelop.Lv7.Entity.Schedule;
import com.example.scheduledevelop.Lv7.Repository.CommentRepository;
import com.example.scheduledevelop.Lv7.Repository.MemberRepository;
import com.example.scheduledevelop.Lv7.Repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Profile("Lv7")
@Service
@RequiredArgsConstructor //final 필드에 대한 생성자 자동 생성

public class CommentService {

    private final CommentRepository commentRepository; //댓글 데이터 접근
    private final MemberRepository memberRepository; //유저 데이터 접근
    private final ScheduleRepository scheduleRepository; //일정 데이터 접근

    //댓글 생성
    public Comment createComment(Long memberId, Long scheduleId, String content){
        //유저 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"사용자를 찾을 수 없습니다."
                ));

        //일정 조회
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"일정을 찾을 수 없습니다."
                ));

        //새로운 댓글 생성
        Comment comment = new Comment(content, member, schedule);

        //데이터베이스에 저장
        return commentRepository.save(comment);
    }

    //특정 일정에 대한 댓글 조회
    public List<Comment> getCommentsBySchedule(Long scheduleId){
        return commentRepository.findByScheduleId(scheduleId);
    }

    //댓글 수정
    public Comment updateComment(Long commentId, String newContent){
        //댓글 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"댓글을 찾을 수 없습니다."
                ));

        //댓글 내용 수정
        comment.updateContent(newContent);

        return commentRepository.save(comment);
    }

    //댓글 삭제
    public void deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다."
                ));

        commentRepository.delete(comment);
    }
}
