package com.ssafy.planit.plan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PlanDto {

    private int planId;
    private String title;
    private Date startSchedule;
    private Date endSchedule;
    private String userId;
    private List<PlanDetailDto> planDetail;

}
