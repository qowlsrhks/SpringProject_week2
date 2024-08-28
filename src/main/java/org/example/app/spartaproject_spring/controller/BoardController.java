package org.example.app.spartaproject_spring.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.spartaproject_spring.dto.BoardDTO;
import org.example.app.spartaproject_spring.entity.BoardEntity;
import org.example.app.spartaproject_spring.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


//    일정 생성
    @PostMapping("/board/save")
    public ResponseEntity<BoardEntity> save(@RequestBody BoardDTO boardDTO) {
        BoardEntity savedBoard = boardService.save(boardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
    }

//    일정 조회
    @GetMapping("/board")
    public ResponseEntity<Optional<BoardEntity>> findById(Long board_id) {
        return ResponseEntity.ok(boardService.findByBoardId(board_id));
    }

//    일정 일괄 조회
    @GetMapping("/boardList")
    public ResponseEntity<List<BoardEntity>> findAll() {
        boardService.findAll();
        return ResponseEntity.ok(boardService.findAll());}

//    일정 수정
    @PostMapping("/boardUpdate")
    public ResponseEntity<BoardEntity> update(Long board_id, String title, String content) {
        BoardEntity updatedBoard = boardService.update(board_id, title, content);
        return ResponseEntity.ok(updatedBoard);
    }


//    일정 삭제
    @DeleteMapping("/boardDelete")
    public ResponseEntity<BoardEntity> delete(Long board_id) {
        BoardEntity deletedBoard = boardService.delete(board_id);
        return ResponseEntity.ok(deletedBoard);
    }

//    페이지
//    @GetMapping("/boardList")
//    public String pageList(Model model, @PageableDefault(sort ="boardId", direction = Sort.Direction.DESC) Pageable pageable) {
//        model.addAttribute("boardList", boardService.findAll());
//        model.addAttribute("page", boardService.pageList(pageable));
//        return "boardList";
//    }
}
