package com.ssafy.planit.attraction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoritesDto {

    private int favoritesId;
    private AttractionInfoDto attraction;

}