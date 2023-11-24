package com.ssafy.planit.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class BoardDto {
    private int boardId;
    private String subject;
    private String content;
    private int hit;
    private Timestamp registerTime;
    private String userId;
}
