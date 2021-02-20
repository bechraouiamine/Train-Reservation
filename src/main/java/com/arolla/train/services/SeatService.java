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

    public List<Seat> getSeatsByCoachRefAndTrainRefAndRefIn(String coachRef, String trainRef, List<String> refs) {
        return seatRepository.findAllByCoachRefAndTrainRefAndRefIn(coachRef, trainRef, refs);
    }

    public List<Seat> findAllByTrainRefAndBookingRefIsNull(String trainRef) {
        return seatRepository.findAllByTrainRefAndBookingRefIsNull(trainRef);
    }

    public Seat update(Seat seatToBook) {
        return seatRepository.save(seatToBook);
    }

    public long countByTrainId(UUID trainId) {
        return seatRepository.countByTrainId(trainId);
    }

    public long countByTrainIdAndBookingRefIsNull(UUID trainId) {
        return seatRepository.countByTrainId(trainId);
    }

    public long countByTrainIdAndCoachId(UUID trainId, UUID coachId) {
        return seatRepository.countByTrainIdAndCoachId(trainId, coachId);
    }

    public long countByTrainIdAndCoachIdAndBookingRefIsNull(UUID trainId, UUID coachId) {
        return seatRepository.countByTrainIdAndCoachIdAndBookingRefIsNull(trainId, coachId);
    }
}
