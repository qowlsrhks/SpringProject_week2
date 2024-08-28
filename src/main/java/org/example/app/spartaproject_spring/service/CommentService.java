package org.example.app.spartaproject_spring.service;

import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.CommentDtoRequest;
import org.example.app.spartaproject_spring.entity.BoardEntity;
import org.example.app.spartaproject_spring.entity.CommentEntity;
import org.example.app.spartaproject_spring.entity.MemberEntity;
import org.example.app.spartaproject_spring.repository.BoardRepository;
import org.example.app.spartaproject_spring.repository.CommentRepository;
import org.example.app.spartaproject_spring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

//    댓글 작성
    public CommentEntity save(Long boardId, CommentDtoRequest request, String userName) {
        Optional<MemberEntity> userOptional = memberRepository.findByUsername(userName);
        MemberEntity memberEntity;
        if(userOptional.isPresent()) {
            memberEntity = userOptional.get();
        } else {
            System.out.println("사용자가 존재하지 않습니다" + userName);
            return null;
        }
        BoardEntity boardEntity = boardRepository.findByBoardId(boardId).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 게시글이 존재 하지 않습니다" + boardId));

        request.setMemberId(memberEntity.getMemberId());
        request.setBoardId(boardEntity.getBoardId());

        return commentRepository.save(request.toEntity());
    }

//    댓글 조회
    @Transactional(readOnly = true)
    public List<CommentEntity> findAll(Long boardId) {
        BoardEntity boardEntity = boardRepository.findByBoardId(boardId).orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다" + boardId));
        return boardEntity.getCommentEntities();
    }

//    댓글 수정
    @Transactional
    public void update(CommentDtoRequest request) {
        CommentEntity commentEntity = commentRepository.findByCommentId(request.getCommentId()).orElseThrow(() ->
                new IllegalArgumentException("댓글이 존재하지 않습니다. id=" + request.getCommentId()));
        commentEntity.update(request.getComment());
    }
//    댓글 삭제
    @Transactional
    public void delete(Long commentId) {
        CommentEntity commentEntity = commentRepository.findByCommentId(commentId).orElseThrow(() ->
                new IllegalArgumentException("댓글이 존재하지 않습니다. id=" + commentId));
        commentRepository.delete(commentEntity);
    }

}
