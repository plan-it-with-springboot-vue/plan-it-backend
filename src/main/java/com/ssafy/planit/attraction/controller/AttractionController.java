package com.ssafy.planit.attraction.controller;

import com.ssafy.planit.attraction.dto.AttractionCommentDto;
import com.ssafy.planit.attraction.dto.AttractionDescriptionDto;
import com.ssafy.planit.attraction.dto.AttractionInfoDto;
import com.ssafy.planit.attraction.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
