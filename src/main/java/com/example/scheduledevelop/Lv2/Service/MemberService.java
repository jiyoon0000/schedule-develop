package com.example.scheduledevelop.Lv2.Service;

import com.example.scheduledevelop.Lv2.Entity.Member;
import com.example.scheduledevelop.Lv2.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Profile("Lv2")
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

    //유저 삭제
    //id로 유저를 조회 후 삭제
    public void deleteMember(Long id){
        Member member = getMember(id);
        memberRepository.delete(member);
    }
}
