package org.example.app.spartaproject_spring.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER_TBL")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;



}
