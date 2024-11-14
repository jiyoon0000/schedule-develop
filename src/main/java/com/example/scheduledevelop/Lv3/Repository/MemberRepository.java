package com.example.scheduledevelop.Lv3.Repository;

import com.example.scheduledevelop.Lv3.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//jpa repository를 사용하여 기본적인 CRUD 기능 사용
//이메일을 기준으로 user 조회
//유저 정보를 조회할 때, 로그인 시 사용
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
