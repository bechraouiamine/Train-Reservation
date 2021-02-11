package com.arolla.train.controllers;

import com.arolla.train.domain.Train;
import com.arolla.train.services.TrainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.controllers
 */
@RequestMapping("api/v1")
@RestController
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    
    @GetMapping(value="trains")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }
    
}
