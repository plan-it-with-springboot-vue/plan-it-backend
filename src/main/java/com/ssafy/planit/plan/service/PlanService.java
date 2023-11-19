package com.ssafy.planit.plan.service;

import com.ssafy.planit.plan.dto.PlanDto;

public interface PlanService {

    public void savePlanWithDetails(PlanDto planDto) throws Exception;
    public PlanDto getPlanById(int planId);
    public void deletePlanById(int planId);
    public void deletePlanDetailByPlanId(int planId);

}
