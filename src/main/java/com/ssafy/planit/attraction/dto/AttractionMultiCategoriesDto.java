package com.ssafy.planit.attraction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class AttractionMultiCategoriesDto {
    private int contentId;
    private List<Integer> contentTypeIds;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String tel;
    private String firstImage;
    private String firstImage2;
    private int readcount;
    private int sidoCode;
    private int gugunCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String mlevel;
}
