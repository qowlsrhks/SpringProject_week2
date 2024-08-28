package org.example.app.spartaproject_spring.controller;


import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.CommentDtoRequest;
import org.example.app.spartaproject_spring.entity.CommentEntity;
import org.example.app.spartaproject_spring.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class CommentController {
    private final CommentService commentService;

//    댓글 생성
    @PostMapping("/boards/comments")
    public ResponseEntity<CommentEntity> save(@RequestBody CommentDtoRequest request, Principal principal) {
        CommentEntity savedComment = commentService.save(request.getCommentId(), request, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);

    }

//    댓글 읽어오기
    @GetMapping("/boards/comments")
    public List<CommentEntity> read(CommentDtoRequest request) {
        return commentService.findAll(request.getCommentId());
    }

// 댓글 업데이트
    @PutMapping("/boards/comments")
    public ResponseEntity<Long> update(@RequestBody CommentDtoRequest request) {
        commentService.update(request);
        return ResponseEntity.ok(request.getCommentId());
    }

//    댓글 삭제
    @DeleteMapping("/boards/{board_id}comments/{comment_id}")
    public ResponseEntity<Long> delete(Long comment_id) {
        commentService.delete(comment_id);
        return ResponseEntity.ok(comment_id);
    }
}
