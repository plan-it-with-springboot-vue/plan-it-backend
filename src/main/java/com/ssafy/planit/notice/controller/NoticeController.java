package com.ssafy.planit.notice.controller;

import com.ssafy.planit.notice.dto.NoticeDto;
import com.ssafy.planit.notice.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        super();
        this.noticeService = noticeService;
    }

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody NoticeDto noticeDto) throws Exception {
        try {
            noticeService.writeArticle(noticeDto);
            return new ResponseEntity<>("Notice write successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during notice write", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<NoticeDto> list() throws Exception {
        return noticeService.listArticle();
    }

    @GetMapping("/view")
    public NoticeDto view(@RequestParam int noticeId) throws Exception {
        return noticeService.getArticle(noticeId);
    }

    @PostMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody NoticeDto noticeDto) throws Exception {
        try {
            noticeService.modifyArticle(noticeDto);
            return new ResponseEntity<>("Notice modify successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during notice modify", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int noticeId) throws Exception {
        try {
            noticeService.deleteArticle(noticeId);
            return new ResponseEntity<>("Notice delete successfully", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during notice delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
