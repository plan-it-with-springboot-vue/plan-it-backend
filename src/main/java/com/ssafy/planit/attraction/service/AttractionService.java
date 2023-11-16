package com.ssafy.planit.attraction.service;

import com.ssafy.planit.attraction.dto.AttractionCommentDto;
import com.ssafy.planit.attraction.dto.AttractionDescriptionDto;
import com.ssafy.planit.attraction.dto.AttractionInfoDto;
import com.ssafy.planit.attraction.dto.FavoritesDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AttractionService {
    public List<AttractionInfoDto> listAttraction(@RequestParam Map<String, Integer> map) throws Exception;
    public AttractionDescriptionDto viewAttraction(@RequestParam int contentId) throws Exception;
    public List<AttractionCommentDto> viewAttractionComment(@RequestParam int contentId) throws Exception;
    public void writeAttractionComment(@RequestParam AttractionCommentDto attractionCommentDto) throws Exception;
    public void deleteAttractionComment(@RequestParam int reviewId) throws Exception;
    public List<FavoritesDto> listFavorites(@RequestParam String userId) throws Exception;
    public void saveFavorites(@RequestBody FavoritesDto favoritesDto) throws Exception;
    void deleteFavorite(String userId, int contentId) throws Exception;
}

