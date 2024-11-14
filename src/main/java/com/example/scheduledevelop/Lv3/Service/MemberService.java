package com.example.scheduledevelop.Lv3.Service;

import com.example.scheduledevelop.Lv3.Entity.Member;
import com.example.scheduledevelop.Lv3.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Profile("Lv3")
@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    //새로운 유저 생성
    //이름, 이메일, 비밀번호를 가지고 생성
    public Member createMember(String username, String email, String password){
        Member member = new Member(username,email,password);
        return memberRepository.save(member);
    }

    //특정 유저 조회
    //id로 유저를 조회, 없으면 404 NOT_FOUND 에러
    public Member getMember(Long id){
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Not found member"
                ));
    }

    //유저 로그인
    //이메일과 비밀번호로 유저를 찾음
    //인증 실패한 경우 401 UNAUTHORIZED 반환
    public Member findByEmailAndPassword(String email, String password){
        return memberRepository.findByEmailAndPassword(email,password)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,"Wrong email or password"
                ));
    }

    //유저 삭제
    //id로 유저를 조회 후 삭제
    public void deleteMember(Long id){
        Member member = getMember(id);
        memberRepository.delete(member);
    }
}
