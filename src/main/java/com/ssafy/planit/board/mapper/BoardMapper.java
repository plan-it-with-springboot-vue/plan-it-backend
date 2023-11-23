package com.ssafy.planit.board.mapper;

import com.ssafy.planit.board.dto.BoardCommentDto;
import com.ssafy.planit.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    void writeArticle(BoardDto boardDto) throws SQLException;
    List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
    List<BoardDto> listArticlePopularity(Map<String, Object> param) throws SQLException;
    int getTotalArticleCount(Map<String, Object> param) throws SQLException;
    BoardDto getArticle(int boardId) throws SQLException;
    void updateHit(int boardId) throws SQLException;
    void modifyArticle(BoardDto boardDto) throws SQLException;
    void deleteArticle(int boardId) throws SQLException;
    void writeComment(BoardCommentDto boardCommentDto) throws Exception;
    List<BoardCommentDto> listComment(int boardId) throws Exception;
    void modifyComment(BoardCommentDto boardCommentDto) throws Exception;
    void deleteComment(int boardCommentId) throws Exception;
}
