package org.example.app.spartaproject_spring.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.MemberDTO;
import org.example.app.spartaproject_spring.entity.MemberEntity;
import org.example.app.spartaproject_spring.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class MemberController {

    private final MemberService memberService;

//    회원 등록
    @PostMapping("/member/save")
    public ResponseEntity<MemberEntity> save(@RequestBody MemberDTO memberDTO) {
        MemberEntity savedMember = memberService.save(memberDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

//    회원 검색
    @GetMapping("/member/search")
    public ResponseEntity<MemberEntity> findById(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.findByUsername(memberDTO.getUsername()));
    }
//    회원 전체 조회
    @GetMapping("/member/findALl")
    public ResponseEntity<List<MemberEntity>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

//    회원 삭제
    @DeleteMapping("/member/delete")
    public ResponseEntity<String> delete(@RequestBody MemberDTO memberDTO) {
        memberService.delete(memberDTO);
        return ResponseEntity.ok("success");
    }

}
