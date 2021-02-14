package com.arolla.train.services;

import com.arolla.train.domain.Seat;
import com.arolla.train.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public List<Seat> getSeatsByCoachRefAndTrainRef(String coachRef, String trainRef) {
        return seatRepository.findAllByCoachRefAndTrainRef(coachRef, trainRef);
    }
}
