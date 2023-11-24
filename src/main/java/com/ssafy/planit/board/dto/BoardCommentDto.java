package com.ssafy.planit.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class BoardCommentDto {
    private int boardCommentId;
    private int boardId;
    private String userId;
    private Timestamp registerTime;
    private String content;
}
