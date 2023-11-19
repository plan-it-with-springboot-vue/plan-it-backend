package com.ssafy.planit.plan.controller;

import com.ssafy.planit.plan.dto.PlanDto;
import com.ssafy.planit.plan.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
@Slf4j
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
}
