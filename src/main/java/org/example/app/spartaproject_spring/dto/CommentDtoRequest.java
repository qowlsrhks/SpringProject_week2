package org.example.app.spartaproject_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.app.spartaproject_spring.entity.BoardEntity;
import org.example.app.spartaproject_spring.entity.CommentEntity;
import org.example.app.spartaproject_spring.entity.MemberEntity;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDtoRequest {

    private Long commentId;
    private String comment;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private Long memberId;
    private Long boardId;

    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .comment(comment)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }


}
