package com.example.scheduledevelop.Lv7.Controller;

import com.example.scheduledevelop.Lv7.Entity.Comment;
import com.example.scheduledevelop.Lv7.Service.CommentService;
import com.example.scheduledevelop.Lv7.dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("Lv7")
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor

public class CommentController {

    //댓글 관련 비지니스 로직 호출
    private final CommentService commentService;

    //댓글 생성 API
    @PostMapping
    public ResponseEntity<Comment> createComment(
            //유저 아이디, 일정 아이디, 댓글 내용 가져오기
            @RequestParam Long memberId,
            @RequestParam Long scheduleId,
            @Validated @RequestBody CommentRequestDto requestDto
            ){
        //댓글 생성
        Comment comment = commentService.createComment(
                memberId,scheduleId,requestDto.getContent()
        );
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    //특정 일정에 대한 댓글 목록 조회 API
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<Comment>> getCommentsBySchedule(@PathVariable Long scheduleId){
        //댓글 목록 조회
        List<Comment> comments = commentService.getCommentsBySchedule(scheduleId);

        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    //댓글 수정 API
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long commentId,
            @Validated @RequestBody CommentRequestDto requestDto
    ){
        //댓글 수정
        Comment comment = commentService.updateComment(commentId, requestDto.getContent());

        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    //댓글 삭제 API
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
