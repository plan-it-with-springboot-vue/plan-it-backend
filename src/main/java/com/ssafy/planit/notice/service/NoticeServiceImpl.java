package com.ssafy.planit.notice.service;

import com.ssafy.planit.notice.dto.NoticeDto;
import com.ssafy.planit.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    private NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        super();
        this.noticeMapper = noticeMapper;
    }

    @Override
    @Transactional
    public void writeArticle(NoticeDto noticeDto) throws Exception {
        noticeMapper.writeArticle(noticeDto);
    }

    @Override
    public List<NoticeDto> listArticle() throws Exception {
        return noticeMapper.listArticle();
    }


    @Override
    public NoticeDto getArticle(int noticeId) throws Exception {
        noticeMapper.updateHit(noticeId);
        return noticeMapper.getArticle(noticeId);
    }

    @Override
    @Transactional
    public void modifyArticle(NoticeDto noticeDto) throws Exception {
        noticeMapper.modifyArticle(noticeDto);
    }

    @Override
    @Transactional
    public void deleteArticle(int noticeId) throws Exception {
        noticeMapper.deleteArticle(noticeId);
    }
}
