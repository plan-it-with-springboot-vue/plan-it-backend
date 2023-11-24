package com.ssafy.planit.notice.mapper;

import com.ssafy.planit.notice.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface NoticeMapper {
    void writeArticle(NoticeDto noticeDto) throws SQLException;
    List<NoticeDto> listArticle() throws SQLException;
    NoticeDto getArticle(int noticeId) throws SQLException;
    void updateHit(int noticeId) throws SQLException;
    void modifyArticle(NoticeDto noticeDto) throws SQLException;
    void deleteArticle(int noticeId) throws SQLException;
}
