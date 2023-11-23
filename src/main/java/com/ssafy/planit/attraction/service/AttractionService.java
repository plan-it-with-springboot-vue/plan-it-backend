package com.ssafy.planit.attraction.service;

import com.ssafy.planit.attraction.dto.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AttractionService {
    public List<AttractionMultiCategoriesDto> listAttraction(Map<String, Object> map) throws Exception;
    public AttractionDescriptionDto viewAttraction(@RequestParam int contentId) throws Exception;
    List<AttractionInfoDto> searchByTitle(String title) throws Exception;
    public List<AttractionCommentDto> viewAttractionComment(@RequestParam int contentId) throws Exception;
    public void writeAttractionComment(@RequestBody AttractionCommentDto attractionCommentDto) throws Exception;
    public void deleteAttractionComment(@RequestParam int reviewId) throws Exception;
    public List<AttractionInfoDto> getUserFavorites(String userId);
    public void saveFavorites(@RequestBody FavoritesDto favoritesDto) throws Exception;
    void deleteFavorite(String userId, int favoritesId) throws Exception;
}

