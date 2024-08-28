package org.example.app.spartaproject_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.app.spartaproject_spring.entity.MemberEntity;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

    private Long boardId;

    private String title;

    private String content;

    private String comment;

    private String writer;

    private MemberEntity memberId;

    private LocalDateTime createdDate;

    private LocalDateTime updateDate;
}
