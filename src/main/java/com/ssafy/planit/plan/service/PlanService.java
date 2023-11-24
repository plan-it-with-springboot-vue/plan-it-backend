package com.ssafy.planit.plan.service;

import com.ssafy.planit.plan.dto.PlanDto;

import java.util.List;

public interface PlanService {

    public void savePlanWithDetails(PlanDto planDto) throws Exception;
    public PlanDto getPlanById(int planId);
    public List<PlanDto> listPlanByUserId(String userId);
    public void deletePlanById(int planId);
    public void deletePlanDetailByPlanId(int planId);

}
