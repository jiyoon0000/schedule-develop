package com.example.scheduledevelop.Lv7.Repository;

import com.example.scheduledevelop.Lv7.Entity.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("Lv7")
//jpa repository를 사용하여 기본적인 CRUD 기능 사용
//이메일을 기준으로 user 조회
//유저 정보를 조회할 때, 로그인 시 사용
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmailAndPassword(String email, String password);
}
