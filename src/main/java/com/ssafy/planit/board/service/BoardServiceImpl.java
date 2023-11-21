package com.ssafy.planit.board.service;

import com.ssafy.planit.board.dto.BoardDto;
import com.ssafy.planit.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        super();
        this.boardMapper = boardMapper;
    }

    @Override
    @Transactional
    public void writeArticle(BoardDto boardDto) throws Exception {
        boardMapper.writeArticle(boardDto);
    }

    @Override
    public List<BoardDto> listArticle() throws Exception {
        return boardMapper.listArticle();
    }


    @Override
    public BoardDto getArticle(int boardId) throws Exception {
        boardMapper.updateHit(boardId);
        return boardMapper.getArticle(boardId);
    }

    @Override
    @Transactional
    public void modifyArticle(BoardDto boardDto) throws Exception {
        boardMapper.modifyArticle(boardDto);
    }

    @Override
    @Transactional
    public void deleteArticle(int boardId) throws Exception {
        boardMapper.deleteArticle(boardId);
    }
}
