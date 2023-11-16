package com.ssafy.planit.attraction.service;

import com.ssafy.planit.attraction.dto.AttractionDescriptionDto;
import com.ssafy.planit.attraction.dto.AttractionInfoDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AttractionService {
    public List<AttractionInfoDto> listAttraction(@RequestParam Map<String, Integer> map) throws Exception;
    public AttractionDescriptionDto viewAttraction(@RequestParam int contentId) throws Exception;
}

