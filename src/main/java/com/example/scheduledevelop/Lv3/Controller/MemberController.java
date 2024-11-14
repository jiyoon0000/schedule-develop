package com.example.scheduledevelop.Lv3.Controller;

import com.example.scheduledevelop.Lv3.Entity.Member;
import com.example.scheduledevelop.Lv3.Service.MemberService;
import com.example.scheduledevelop.Lv3.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Profile("Lv3")
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    //새로운 유저 생성 API
    //request로 받은 username, email, password로 새로운 유저 생성
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberRequestDto requestDto){
        Member member = memberService.createMember(
                requestDto.getUsername(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        //생성된 member와 함께 created 상태 반환
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    //특정 유저 조회 API
    //id로 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id){
        Member member = memberService.getMember(id);
        //조회된 member와 함께 200OK 상태 반환
        return new ResponseEntity<>(member,HttpStatus.OK);
    }

    //유저 삭제 API
    //반환할 데이터가 없으니까 void 사용
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){

        //id로 특정 유저 조회 후 삭제
        //삭제 시 200OK 상태 반환
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
