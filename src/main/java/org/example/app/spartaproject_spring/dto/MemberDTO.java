package org.example.app.spartaproject_spring.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Long memberId;

    private String username;

    private String email;
}
