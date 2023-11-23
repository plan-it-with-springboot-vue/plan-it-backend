package com.ssafy.planit.attraction.mapper;

import com.ssafy.planit.attraction.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionMapper {

    public List<AttractionMultiCategoriesDto> listAttraction(Map<String, Object> map) throws Exception;
    public AttractionDescriptionDto viewAttraction(@RequestParam int contentId) throws Exception;
    public List<AttractionInfoDto> searchByTitle(String title);
    public List<AttractionCommentDto> viewAttractionComment(@RequestParam int contentId) throws Exception;
    public void writeAttractionComment(@RequestBody AttractionCommentDto attractionCommentDto) throws Exception;
    public void deleteAttractionComment(@RequestParam int reviewId) throws Exception;
    public List<AttractionInfoDto> getUserFavorites(String userId);
    public void saveFavorites(@RequestBody FavoritesDto favoritesDto) throws Exception;
    public void deleteFavorite(String userId, int contentId) throws Exception;
    public List<AttractionInfoDto> popularlist() throws Exception;
    public List<AttractionInfoDto> recommendlist() throws Exception;
}
