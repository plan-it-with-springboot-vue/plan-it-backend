package com.ssafy.planit.attraction.controller;

import com.ssafy.planit.attraction.dto.AttractionCommentDto;
import com.ssafy.planit.attraction.dto.AttractionDescriptionDto;
import com.ssafy.planit.attraction.dto.AttractionInfoDto;
import com.ssafy.planit.attraction.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attraction")
@Slf4j
public class AttractionController {
    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/list")
    public List<AttractionInfoDto> list(@RequestParam Map<String, Integer> map) throws Exception {
        return attractionService.listAttraction(map);
    }

    @GetMapping("/view")
    public AttractionDescriptionDto view(@RequestParam int contentId) throws Exception {
        return attractionService.viewAttraction(contentId);
    }

    @GetMapping("/review")
    public List<AttractionCommentDto> list(@RequestParam int contentId) throws Exception{
        return attractionService.viewAttractionComment(contentId);
    }

    @PostMapping("/review/write")
    public ResponseEntity<String> review(@RequestBody AttractionCommentDto attractionCommentDto) throws Exception{
        try{
            attractionService.writeAttractionComment(attractionCommentDto);
            return new ResponseEntity<>("AttractionComment write successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred during AttractionComment write", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review/delete")
    public ResponseEntity<String> delete(@RequestParam int reviewId) throws Exception{
        try{
            attractionService.deleteAttractionComment(reviewId);
            return new ResponseEntity<>("AttractionComment delete successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred during AttractionComment delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
