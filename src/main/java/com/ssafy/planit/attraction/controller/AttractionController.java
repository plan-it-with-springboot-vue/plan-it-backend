package com.ssafy.planit.attraction.controller;

import com.ssafy.planit.attraction.dto.*;
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
@CrossOrigin
public class AttractionController {
    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/list")
    public List<AttractionMultiCategoriesDto> list(@RequestParam Map<String, Object> map) throws Exception {
        return attractionService.listAttraction(map);
    }

    @GetMapping("/view")
    public AttractionDescriptionDto view(@RequestParam int contentId) throws Exception {
        return attractionService.viewAttraction(contentId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AttractionInfoDto>> searchByTitle(@RequestParam String title) {
        try {
            List<AttractionInfoDto> attractions = attractionService.searchByTitle(title);
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review")
    public List<AttractionCommentDto> list(@RequestParam int contentId) throws Exception{
        return attractionService.viewAttractionComment(contentId);
    }

    @PostMapping("/review/write")
    public ResponseEntity<String> write(@RequestBody AttractionCommentDto attractionCommentDto) throws Exception{
        try{
            attractionService.writeAttractionComment(attractionCommentDto);
            return new ResponseEntity<>("AttractionComment write successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred during AttractionComment write", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/review/delete")
    public ResponseEntity<String> delete(@RequestParam int reviewId) throws Exception{
        try{
            attractionService.deleteAttractionComment(reviewId);
            return new ResponseEntity<>("AttractionComment delete successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred during AttractionComment delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/like")
    public List<AttractionInfoDto> list(@RequestParam String userId) throws Exception {
        return attractionService.getUserFavorites(userId);
    }

    @PostMapping("like")
    public ResponseEntity<String> save(@RequestBody FavoritesDto favoritesDto){
        try {
            attractionService.saveFavorites(favoritesDto);
            return new ResponseEntity<>("Favorites save successfully", HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Error occurred during Favorites save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/like")
    public ResponseEntity<String> deleteFavorite(@RequestParam String userId, @RequestParam int contentId) {
        try {
            attractionService.deleteFavorite(userId, contentId);
            return new ResponseEntity<>("Favorite deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during deletion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
