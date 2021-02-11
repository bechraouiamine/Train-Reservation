package com.arolla.train.controllers;

import com.arolla.train.services.BookingRefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.controllers
 */
@RequestMapping("/api/v1/train/booking")
@RestController
public class BookingRefController {

    public BookingRefController(BookingRefService bookingRefService) {
        this.bookingRefService = bookingRefService;
    }

    private final BookingRefService bookingRefService;

    @GetMapping("bookingRef")
    public String generateBookingRef() {
        return bookingRefService.generateRef();
    }
}
