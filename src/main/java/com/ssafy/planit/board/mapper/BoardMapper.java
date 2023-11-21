package com.ssafy.planit.board.mapper;

import com.ssafy.planit.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {
    void writeArticle(BoardDto boardDto) throws SQLException;
    List<BoardDto> listArticle() throws SQLException;
    BoardDto getArticle(int boardId) throws SQLException;
    void updateHit(int boardId) throws SQLException;
    void modifyArticle(BoardDto boardDto) throws SQLException;
    void deleteArticle(int boardId) throws SQLException;
}
