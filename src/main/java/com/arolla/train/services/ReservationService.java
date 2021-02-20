package com.arolla.train.services;

import com.arolla.train.domain.ReservationRequest;
import com.arolla.train.domain.ReservationResult;
import com.arolla.train.domain.Seat;
import com.arolla.train.domain.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.services
 */
@Service
public class ReservationService {

    private final SeatService seatService;

    private final TrainService trainService;

    private final BookingRefService bookingRefService;

    public ReservationService(SeatService seatService, BookingRefService bookingRefService, TrainService trainService) {
        this.seatService = seatService;
        this.bookingRefService = bookingRefService;
        this.trainService = trainService;
    }

    public ReservationResult book(ReservationRequest request) {
        List<Seat> seats = seatService.findAllByTrainRefAndBookingRefIsNull(request.getTrainRef());
        List<String> seatsBooked = new ArrayList<>();;
        String bookingRef = bookingRefService.generateRef();
        if (seats.size() >= request.getSeatsNumber()) {
            bookAndReturnSeats(request.getSeatsNumber(), seats, seatsBooked, bookingRef);
        }
        return new ReservationResult(request.getTrainRef(), seatsBooked, bookingRef);
    }

    private void bookAndReturnSeats(int seatsNumber, List<Seat> seats, List<String> seatsBooked, String bookingRef) {
        seats.subList(0, seatsNumber)
                .stream()
                .forEach(s -> {
                    s = bookSeat(s, bookingRef);
                    seatsBooked.add(s.getCoachReference() + s.getRef());
                });
    }

    private Seat bookSeat(Seat seat, String bookingRef) {
        seat.setBookingRef(bookingRef);
        return seatService.update(seat);
    }

    public long getBookedPercentageOnTrain(String trainRef) {
        UUID trainId = trainService.findByRef(trainRef);

        long seatsNumber = seatService.countByTrainId(trainId);
        long availableSeat = seatService.countByTrainIdAndBookingRefIsNull(trainId);

        return calculatePercentage(seatsNumber, availableSeat);

    }

    private long calculatePercentage(long total, long toCalculate) {
        return toCalculate * 100 / total;
    }
}
