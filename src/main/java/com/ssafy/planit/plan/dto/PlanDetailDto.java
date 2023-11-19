package com.ssafy.planit.plan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
public class PlanDetailDto {

    private int planDetailId;
    private int planId;
    private String contentId;
    private Date planDate;
    private Time time;
    private int sequence;

}
