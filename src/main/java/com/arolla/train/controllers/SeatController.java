package com.arolla.train.controllers;

import com.arolla.train.domain.Seat;
import com.arolla.train.services.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.controllers
 */
@RestController
@RequestMapping("/api/v1")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("seats")
    public List<Seat> getSeats() {
        return seatService.getSeats();
    }
    
    @GetMapping("seats/{coachRef}/{trainRef}")
    public List<Seat> getSeatsByCoachRefAndTrainRef(@PathVariable("coachRef") String coachRef, @PathVariable("trainRef") String trainRef) {
        return seatService.getSeatsByCoachRefAndTrainRef(coachRef, trainRef);
    }
}
