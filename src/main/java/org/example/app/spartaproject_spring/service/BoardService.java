package org.example.app.spartaproject_spring.service;

import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.BoardDTO;
import org.example.app.spartaproject_spring.entity.BoardEntity;
import org.example.app.spartaproject_spring.entity.MemberEntity;
import org.example.app.spartaproject_spring.repository.BoardRepository;
import org.example.app.spartaproject_spring.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    //    일정 저장
    public BoardEntity save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .build();
        return boardRepository.save(boardEntity);
    }

    //    단건 조회
    public Optional<BoardEntity> findByBoardId(Long boardId) {
        boardRepository.findByBoardId(boardId);
        return boardRepository.findByBoardId(boardId);
    }

    //    일정 조회
    public List<BoardEntity> findAll() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    //    수정
    public BoardEntity update(Long boardId, String title, String content) {
        BoardEntity boardEntity = boardRepository.findByBoardId(boardId).orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다" + boardId));
        boardEntity.update(title, content);
        return boardRepository.save(boardEntity);
    }

    //    삭제
    public BoardEntity delete(Long boardId) {
        BoardEntity boardEntity = boardRepository.findByBoardId(boardId).orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다" + boardId));
        boardRepository.delete(boardEntity);
        return boardEntity;
    }

    //    페이징
    @Transactional(readOnly = true)
    public Page<BoardEntity> pageList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }


}
