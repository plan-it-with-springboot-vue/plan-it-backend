package com.ssafy.planit.plan.controller;

import com.ssafy.planit.plan.dto.PlanDto;
import com.ssafy.planit.plan.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@Slf4j
@CrossOrigin
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/make")
    public ResponseEntity<String> createPlan(@RequestBody PlanDto planDto){
        try {
            planService.savePlanWithDetails(planDto);

            return new ResponseEntity<>("Plan create successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("PlanController.createPlan : " + planDto);
            System.out.println(e);
            return new ResponseEntity<>("Error occurred during Plan create", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/view")
    public PlanDto viewPlan(int planId){
        return planService.getPlanById(planId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePlan(int planId){
        try {
            planService.deletePlanById(planId);
            planService.deletePlanDetailByPlanId(planId);

            return new ResponseEntity<>("Plan and Plan detail delete successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error occurred during Plan and Plan detail delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
