package com.arolla.train.controllers;

import com.arolla.train.domain.ReservationRequest;
import com.arolla.train.domain.ReservationResult;
import com.arolla.train.services.ReservationService;
import com.arolla.train.services.SeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.controllers
 */
@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(path = "/reservation")
    public ReservationResult book(@RequestBody ReservationRequest reservation) {
        return reservationService.book(reservation);
    }

}
