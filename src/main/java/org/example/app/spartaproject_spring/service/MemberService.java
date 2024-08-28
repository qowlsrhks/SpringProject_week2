package org.example.app.spartaproject_spring.service;

import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.MemberDTO;
import org.example.app.spartaproject_spring.entity.MemberEntity;
import org.example.app.spartaproject_spring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    회원 등록
    public MemberEntity save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.builder()
                .username(memberDTO.getUsername())
                .email(memberDTO.getEmail())
                .build();
        return memberRepository.save(memberEntity);
    }

    //    회원 조회
    public MemberEntity findByUsername(String username) {
        memberRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 회원입니다.")
        );
        return memberRepository.findByUsername(username).get();
    }
//    회원 전체 조회
    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }

//    회원 삭제
    public void delete(MemberDTO memberDTO) {
        MemberEntity memberEntity = findByUsername(memberDTO.getUsername());
        memberRepository.delete(memberEntity);
    }

}
