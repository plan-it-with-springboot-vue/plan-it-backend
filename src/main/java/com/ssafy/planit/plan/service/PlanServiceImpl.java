package com.ssafy.planit.plan.service;

import com.ssafy.planit.plan.dto.PlanDetailDto;
import com.ssafy.planit.plan.dto.PlanDto;
import com.ssafy.planit.plan.mapper.PlanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{

    private final PlanMapper planMapper;

    public PlanServiceImpl(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    public void savePlanWithDetails(PlanDto planDto) {

        planMapper.insertPlan(planDto);
        for (PlanDetailDto detail : planDto.getPlanDetail()) {
            detail.setPlanId(planDto.getPlanId());
            planMapper.insertPlanDetail(detail);
        }
    }

    @Override
    public PlanDto getPlanById(int planId) {
        return planMapper.getPlanById(planId);
    }

    @Override
    public List<PlanDto> listPlanByUserId(String userId) {
        return planMapper.listPlanByUserId(userId);
    }

    @Override
    public void deletePlanById(int planId) {
        planMapper.deletePlanById(planId);
    }

    @Override
    public void deletePlanDetailByPlanId(int planId) {
        planMapper.deletePlanDetailByPlanId(planId);
    }
}
