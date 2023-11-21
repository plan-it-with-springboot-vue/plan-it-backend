package com.ssafy.planit.board.controller;

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
    public BoardDto view(@RequestParam int articleNo) throws Exception {
        return boardService.getArticle(articleNo);
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

    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int articleNo) throws Exception {
        try {
            boardService.deleteArticle(articleNo);
            return new ResponseEntity<>("Board delete successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during board delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
