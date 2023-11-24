package com.ssafy.planit.attraction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class AttractionCommentDto {
    private int reviewId;
    private String content;
    private Timestamp registerTime;
    private String userId;
    private int contentId;

    public AttractionCommentDto(String content, Timestamp registerTime, String userId, int contentId) {
        this.content = content;
        this.registerTime = registerTime;
        this.userId = userId;
        this.contentId = contentId;
    }
}