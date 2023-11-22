package com.ssafy.planit.notice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class NoticeDto {
    private int noticeId;
    private String subject;
    private String content;
    private int hit;
    private Timestamp registerTime;
    private String userId;
}
