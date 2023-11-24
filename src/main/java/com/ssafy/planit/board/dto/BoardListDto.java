package com.ssafy.planit.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BoardListDto {
    private List<BoardDto> articles;
    private int currentPage;
    private int totalPageCount;
}
