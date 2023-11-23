package com.ssafy.planit.board.service;

import com.ssafy.planit.board.dto.BoardCommentDto;
import com.ssafy.planit.board.dto.BoardDto;
import com.ssafy.planit.board.dto.BoardListDto;
import com.ssafy.planit.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public BoardListDto listArticle(Map<String, String> map) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
        int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
        int start = currentPage * sizePerPage - sizePerPage;
        param.put("start", start);
        param.put("listsize", sizePerPage);

        String key = map.get("key");
        param.put("key", key == null ? "" : key);
        if ("user_id".equals(key))
            param.put("key", key == null ? "" : "b.user_id");

        List<BoardDto> list = null;
        //최신순 검색
        if(map.get("sort").equals("latest")){
            list = boardMapper.listArticle(param);
        }
        else if(map.get("sort").equals("popularity")){
            list = boardMapper.listArticlePopularity(param);
        }

        if ("user_id".equals(key))
            param.put("key", key == null ? "" : "user_id");
        int totalArticleCount = boardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

        BoardListDto boardListDto = new BoardListDto();
        boardListDto.setArticles(list);
        boardListDto.setCurrentPage(currentPage);
        boardListDto.setTotalPageCount(totalPageCount);

        return boardListDto;
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

    @Override
    public void writeComment(BoardCommentDto boardCommentDto) throws Exception {
        boardMapper.writeComment(boardCommentDto);
    }

    @Override
    public List<BoardCommentDto> listComment(int boardId) throws Exception {
        return boardMapper.listComment(boardId);
    }

    @Override
    public void modifyComment(BoardCommentDto boardCommentDto) throws Exception {
        boardMapper.modifyComment(boardCommentDto);
    }

    @Override
    public void deleteComment(int boardCommentId) throws Exception {
        boardMapper.deleteComment(boardCommentId);
    }
}
