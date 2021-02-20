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

    public List<Seat> getSeatsByCoachRefAndTrainRef(String coachRef, String trainRef) {
        return seatRepository.findAllByCoachRefAndTrainRef(coachRef, trainRef);
    }

    public List<Seat> getSeatsByCoachRefAndTrainRefAndRefIn(String coachRef, String trainRef, List<String> refs) {
        return seatRepository.findAllByCoachRefAndTrainRefAndRefIn(coachRef, trainRef, refs);
    }

    public List<Seat> findAllByTrainRefAndBookingRefIsNull(String trainRef) {
        return seatRepository.findAllByTrainRefAndBookingRefIsNull(trainRef);
    }

    public Seat update(Seat seatToBook) {
        return seatRepository.save(seatToBook);
    }

    public long countByTrainRef(String trainRef) {
        return seatRepository.countByTrainRef(trainRef);
    }

    public long countByTrainRefAndBookingRefIsNotNull(String trainRef) {
        return seatRepository.countByTrainRefAndBookingRefIsNotNull(trainRef);
    }

    public long countByTrainRefAndCoachRef(String trainRef, String coachRef) {
        return seatRepository.countByTrainRefAndCoachRef(trainRef, coachRef);
    }

    public long countByTrainRefAndCoachRefAndBookingRefIsNotNull(String trainRef, String coachRef) {
        return seatRepository.countByTrainRefAndCoachRefAndBookingRefIsNotNull(trainRef, coachRef);
    }
}
