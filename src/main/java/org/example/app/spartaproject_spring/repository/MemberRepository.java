package org.example.app.spartaproject_spring.repository;

import org.example.app.spartaproject_spring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByUsername(String userName);

    MemberEntity findByMemberId(Long memberId);
}
