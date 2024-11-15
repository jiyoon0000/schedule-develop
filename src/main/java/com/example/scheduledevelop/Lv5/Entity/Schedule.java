package com.example.scheduledevelop.Lv5.Entity;

import jakarta.persistence.*;

//schedule이 데이터베이스의 테이블과 매핑됨
@Entity(name = "Lv5schedule")
@Table(name = "schedule")

//BaseEntity를 상속받아 생성일, 수정일 필드가 포함되어 있다.
public class Schedule extends BaseEntity {

    //id 필드가 기본키
    @Id
    //데이터베이스에서 자동으로 ID를 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //제목은 반드시 입력되야한다.
    @Column(nullable = false)
    private String title;

    //내용은 텍스트 형식으로 저장
    @Column(columnDefinition = "text")
    private String contents;

    //기본생성자 생성
    //JPA가 entity 생성 시에 필요함
    public Schedule(){
    }

    //생성자
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    //제목과 내용을 수정할 수 있음
    public void updateSchedule(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
