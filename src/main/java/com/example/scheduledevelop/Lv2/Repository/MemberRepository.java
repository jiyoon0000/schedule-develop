package com.example.scheduledevelop.Lv2.Repository;

import com.example.scheduledevelop.Lv2.Entity.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("Lv2")
//jpa repository를 사용하여 기본적인 CRUD 기능 사용
//이메일을 기준으로 user 조회
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
