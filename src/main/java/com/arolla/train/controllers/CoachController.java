package com.arolla.train.controllers;

import com.arolla.train.domain.Coach;
import com.arolla.train.services.CoachService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.controllers
 */
@RequestMapping("/api/v1/")
@RestController
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }
    
    @GetMapping(value="coachs")
    public List<Coach> getAllCoach() {
        return coachService.getAllCoachs();
    }
    
}
