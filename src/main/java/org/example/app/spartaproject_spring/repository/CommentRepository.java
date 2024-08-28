package org.example.app.spartaproject_spring.repository;

import org.example.app.spartaproject_spring.entity.BoardEntity;
import org.example.app.spartaproject_spring.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findByBoardIdAndCommentId(BoardEntity boardId, Long commentId);

    Optional<CommentEntity> findByCommentId(Long commentId);
}
