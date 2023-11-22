package com.ssafy.planit.board.controller;

import com.ssafy.planit.board.dto.BoardCommentDto;
import com.ssafy.planit.board.dto.BoardDto;
import com.ssafy.planit.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@CrossOrigin
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        super();
        this.boardService = boardService;
    }

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody BoardDto boardDto) throws Exception {
        try {
            boardService.writeArticle(boardDto);
            return new ResponseEntity<>("Board write successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during board write", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<BoardDto> list() throws Exception {
        return boardService.listArticle();
    }

    @GetMapping("/view")
    public BoardDto view(@RequestParam int boardId) throws Exception {
        return boardService.getArticle(boardId);
    }

    @PostMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody BoardDto boardDto) throws Exception {
        try {
            boardService.modifyArticle(boardDto);
            return new ResponseEntity<>("Board modify successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during board modify", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int boardId) throws Exception {
        try {
            boardService.deleteArticle(boardId);
            return new ResponseEntity<>("Board delete successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during board delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/comment/write")
    public ResponseEntity<String> writeComment(@RequestBody BoardCommentDto boardCommentDto) throws Exception {
        try {
            boardService.writeComment(boardCommentDto);
            return new ResponseEntity<>("BoardComment write successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during boardComment write", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comment/list")
    public List<BoardCommentDto> listComment(@RequestParam int boardId) throws Exception {
        return boardService.listComment(boardId);
    }

    @PostMapping("/comment/modify")
    public ResponseEntity<String> modifyComment(@RequestBody BoardCommentDto boardCommentDto) throws Exception {
        try {
            boardService.modifyComment(boardCommentDto);
            return new ResponseEntity<>("BoardComment modify successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during boardComment modify", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/comment/delete")
    public ResponseEntity<String> deleteComment(@RequestParam int boardCommentId) throws Exception {
        try {
            boardService.deleteComment(boardCommentId);
            return new ResponseEntity<>("BoardComment delete successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during boardComment delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
