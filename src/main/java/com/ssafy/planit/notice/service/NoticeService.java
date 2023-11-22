package com.ssafy.planit.notice.service;

import com.ssafy.planit.notice.dto.NoticeDto;

import java.util.List;

public interface NoticeService {
    void writeArticle(NoticeDto noticeDto) throws Exception;
    List<NoticeDto> listArticle() throws Exception;
    NoticeDto getArticle(int noticeId) throws Exception;
    void modifyArticle(NoticeDto noticeDto) throws Exception;
    void deleteArticle(int noticeId) throws Exception;
}
