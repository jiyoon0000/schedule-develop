package com.example.scheduledevelop.Lv2.Entity;

import jakarta.persistence.*;

@Entity(name = "Lv2member")
//member 테이블과 매핑
@Table(name = "member")

//BaseEntity를 상속받아 생성일과 수정일 관리
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //이름, 이메일, 비밀번호는 반드시 값이 있어야함
    //nullable = false 사용
    //username은 중복을 허용하지 않는다.
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    //기본 생성자
    public Member() {
    }

    //생성자
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //getter 메서드
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
