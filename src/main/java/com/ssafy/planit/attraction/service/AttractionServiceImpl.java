package com.ssafy.planit.attraction.service;

import com.ssafy.planit.attraction.dto.*;
import com.ssafy.planit.attraction.mapper.AttractionMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionMapper attractionMapper;

    public AttractionServiceImpl(AttractionMapper attractionMapper) {
        super();
        this.attractionMapper = attractionMapper;
    }

    @Override
    public List<AttractionMultiCategoriesDto> listAttraction(Map<String, Object> map) throws Exception {
        // contentTypeIds 파라미터가 존재하면 List로 변환하여 map에 추가
        if (map.containsKey("contentTypeId")) {
            String contentTypeIdString = map.get("contentTypeId").toString();
            List<Integer> contentTypeIds = Arrays.stream(contentTypeIdString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            map.put("contentTypeIds", contentTypeIds);
        }

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