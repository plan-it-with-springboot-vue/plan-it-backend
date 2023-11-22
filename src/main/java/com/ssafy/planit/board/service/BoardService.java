package com.ssafy.planit.board.service;

import com.ssafy.planit.board.dto.BoardCommentDto;
import com.ssafy.planit.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void writeArticle(BoardDto boardDto) throws Exception;
    List<BoardDto> listArticle() throws Exception;
    BoardDto getArticle(int boardId) throws Exception;
    void modifyArticle(BoardDto boardDto) throws Exception;
    void deleteArticle(int boardId) throws Exception;
    void writeComment(BoardCommentDto boardCommentDto) throws Exception;
    List<BoardCommentDto> listComment(int boardId) throws Exception;
    void modifyComment(BoardCommentDto boardCommentDto) throws Exception;
    void deleteComment(int boardCommentId) throws Exception;
}
