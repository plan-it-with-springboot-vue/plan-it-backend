package com.ssafy.planit.attraction.service;

import com.ssafy.planit.attraction.dto.AttractionCommentDto;
import com.ssafy.planit.attraction.dto.AttractionDescriptionDto;
import com.ssafy.planit.attraction.dto.AttractionInfoDto;
import com.ssafy.planit.attraction.dto.FavoritesDto;
import com.ssafy.planit.attraction.mapper.AttractionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionMapper attractionMapper;

    public AttractionServiceImpl(AttractionMapper attractionMapper) {
        super();
        this.attractionMapper = attractionMapper;
    }

    @Override
    public List<AttractionInfoDto> listAttraction(Map<String, Integer> map) throws Exception {
        return attractionMapper.listAttraction(map);
    }

    @Override
    public AttractionDescriptionDto viewAttraction(int contentId) throws Exception {
        return attractionMapper.viewAttraction(contentId);
    }

    @Override
    public List<AttractionInfoDto> searchByTitle(String title) throws Exception {
        return attractionMapper.searchByTitle(title);
    }

    @Override
    public List<AttractionCommentDto> viewAttractionComment(int contentId) throws Exception {
        return attractionMapper.viewAttractionComment(contentId);
    }

    @Override
    public void writeAttractionComment(AttractionCommentDto attractionCommentDto) throws Exception {
        attractionMapper.writeAttractionComment(attractionCommentDto);
    }

    @Override
    public void deleteAttractionComment(int reviewId) throws Exception {
        attractionMapper.deleteAttractionComment(reviewId);
    }

    @Override
    public List<FavoritesDto> listFavorites(String userId) throws Exception {
        return attractionMapper.listFavorites(userId);
    }

    @Override
    public void saveFavorites(FavoritesDto favoritesDto) throws Exception {
        attractionMapper.saveFavorites(favoritesDto);
    }

    @Override
    public void deleteFavorite(String userId, int contentId) throws Exception {
        attractionMapper.deleteFavorite(userId, contentId);
    }
}