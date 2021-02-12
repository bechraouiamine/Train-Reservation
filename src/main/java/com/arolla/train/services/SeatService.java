package com.arolla.train.services;

import com.arolla.train.domain.Seat;
import com.arolla.train.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.services
 */
@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }
}
