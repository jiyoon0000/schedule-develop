package com.example.scheduledevelop.Lv7.Entity;

import com.example.scheduledevelop.Lv3.Entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor //기본생성자 생성
@Entity
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    //기본 키 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //내용은 필수 입력ㄱ값
    @Column(nullable = false)
    private String content;

    //댓글 작성 시 자동으로 생성일 추가
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    //댓글 작성 시 자동으로 수정일 변경
    @LastModifiedDate
    private LocalDateTime updatedDate;

    //댓글-유저 다:1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member user;

    //댓글-일정 다:1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    //생성자 : 초기화
    public Comment(String content, Member user, Schedule schedule) {
        this.content = content;
        this.user = user;
        this.schedule = schedule;
    }

    public Comment(String content, com.example.scheduledevelop.Lv7.Entity.Member member, com.example.scheduledevelop.Lv7.Entity.Schedule schedule) {
    }

    //댓글내용 업데이트
    public void updateContent(String content){
        this.content = content;
    }
}
