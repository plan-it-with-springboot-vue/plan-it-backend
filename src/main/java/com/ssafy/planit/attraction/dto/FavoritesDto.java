package com.ssafy.planit.attraction.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class FavoritesDto {
    private int favoritesId;
    private int contentId;
    private String userId;

    public FavoritesDto(int contentId, String userId) {
        this.contentId = contentId;
        this.userId = userId;
    }
}