package com.ssafy.planit.plan.mapper;

import com.ssafy.planit.plan.dto.PlanDetailDto;
import com.ssafy.planit.plan.dto.PlanDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {

    public void insertPlan(PlanDto planDto);
    public void insertPlanDetail(PlanDetailDto planDetailDto);
    public PlanDto getPlanById(int planId);
    public void deletePlanById(int planId);
    public void deletePlanDetailByPlanId(int planId);
}
