package com.example.scheduledevelop.Lv4.Controller;

import com.example.scheduledevelop.Lv4.Entity.Member;
import com.example.scheduledevelop.Lv4.Repository.LoginRequestDto;
import com.example.scheduledevelop.Lv4.Service.MemberService;
import com.example.scheduledevelop.Lv4.dto.MemberRequestDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Profile("Lv4")
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    //새로운 유저 생성 API
    //request로 받은 username, email, password로 새로운 유저 생성
    @PostMapping("/signup")
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

    //유저 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest, HttpServletResponse response){
        //이메일과 비밀번호가 일치하는 유저를 조회
        try{
            Member member = memberService.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword());
            //로그인 성공시 200ok
            return new ResponseEntity<>("Login complete", HttpStatus.OK);
        }catch (ResponseStatusException e){
            //이메일 또는 비밀번호가 틀려서 로그인 실패 시 401
            return new ResponseEntity<>("Wrong email or password", HttpStatus.UNAUTHORIZED);
        }
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
